CREATE OR REPLACE FUNCTION refresh_account_balances()
    RETURNS TRIGGER LANGUAGE plpgsql
AS $$
BEGIN
    REFRESH MATERIALIZED VIEW account_balance;
    RETURN NULL;
END $$;

DROP TRIGGER IF EXISTS refresh_account_balances ON transactions;

CREATE TRIGGER refresh_account_balances
    AFTER INSERT OR UPDATE OR DELETE OR TRUNCATE
    ON transactions
    FOR EACH STATEMENT
EXECUTE PROCEDURE refresh_account_balances();