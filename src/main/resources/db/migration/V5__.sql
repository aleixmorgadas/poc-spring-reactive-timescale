DROP MATERIALIZED VIEW IF EXISTS account_balance;

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
WITH NO DATA;

DROP MATERIALIZED VIEW IF EXISTS monthly_account_balance;

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