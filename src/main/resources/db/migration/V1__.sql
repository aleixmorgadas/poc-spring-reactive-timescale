CREATE TABLE IF NOT EXISTS transactions(
   time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
   id uuid NOT NULL,
   name VARCHAR(50) NOT NULL,
   account_id uuid NOT NULL,
   asset VARCHAR(4) NOT NULL,
   value DOUBLE PRECISION NOT NULL,
   PRIMARY KEY (id, time)
);

SELECT create_hypertable('transactions','time');