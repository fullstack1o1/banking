CREATE TABLE customers (
       customer_id SERIAL PRIMARY KEY,
       username VARCHAR(50) UNIQUE NOT NULL,
       password VARCHAR(100) NOT NULL,
       email VARCHAR(100) UNIQUE NOT NULL,
       full_name VARCHAR(100) NOT NULL,
       date_of_birth DATE NOT NULL,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE accounts (
      account_id SERIAL PRIMARY KEY,
      customer_id INT REFERENCES customers(customer_id),
      account_number VARCHAR(20) UNIQUE NOT NULL,
      balance DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
      account_type VARCHAR(20) NOT NULL,
      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE transactions (
      transaction_id SERIAL PRIMARY KEY,
      account_id INT REFERENCES accounts(account_id),
      transaction_type VARCHAR(20) NOT NULL,
      amount DECIMAL(15, 2) NOT NULL,
      transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE beneficiaries (
       beneficiary_id SERIAL PRIMARY KEY,
       customer_id INT REFERENCES customers(customer_id),
       beneficiary_name VARCHAR(100) NOT NULL,
       account_number VARCHAR(20) NOT NULL,
       added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE sessions (
      session_id SERIAL PRIMARY KEY,
      customer_id INT REFERENCES customers(customer_id),
      session_token VARCHAR(100) UNIQUE NOT NULL,
      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
