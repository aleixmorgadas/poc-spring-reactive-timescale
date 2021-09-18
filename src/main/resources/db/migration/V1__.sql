CREATE TABLE IF NOT EXISTS transactions(
   time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   id uuid NOT NULL,
   name VARCHAR(50) NOT NULL,
   account_id uuid NOT NULL,
   asset VARCHAR(10) NOT NULL,
   value DOUBLE PRECISION NOT NULL,
   concept VARCHAR(255),
   PRIMARY KEY (id, time)
);

SELECT create_hypertable('transactions','time');

CREATE MATERIALIZED VIEW IF NOT EXISTS account_balance
AS
SELECT
    name,
    account_id,
    asset,
    sum(value) as balance
FROM
    transactions
GROUP BY name, account_id, asset
WITH DATA;

CREATE UNIQUE INDEX account_balance_index ON account_balance(name, account_id, asset);

CREATE MATERIALIZED VIEW IF NOT EXISTS monthly_account_balance
            WITH (timescaledb.continuous)
AS
SELECT
    time_bucket('30 days', time) as bucket,
    name,
    account_id,
    asset,
    sum(value) as balance
FROM
    transactions
GROUP BY bucket, name, account_id, asset
WITH NO DATA;

CREATE OR REPLACE FUNCTION refresh_account_balances()
    RETURNS TRIGGER LANGUAGE plpgsql
AS $$
BEGIN
    REFRESH MATERIALIZED VIEW CONCURRENTLY account_balance;
    RETURN NULL;
END $$;

DROP TRIGGER IF EXISTS refresh_account_balances ON transactions;

CREATE TRIGGER refresh_account_balances
    AFTER INSERT OR UPDATE OR DELETE OR TRUNCATE
    ON transactions
    FOR EACH STATEMENT
EXECUTE PROCEDURE refresh_account_balances();