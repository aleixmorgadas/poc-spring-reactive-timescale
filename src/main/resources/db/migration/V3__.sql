CREATE MATERIALIZED VIEW account_balance
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