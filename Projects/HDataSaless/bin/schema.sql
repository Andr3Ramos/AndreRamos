CREATE TABLE clients (
                        client_id SERIAL PRIMARY KEY,
                        name VARCHAR(16)
);

CREATE TABLE products (
                         product_id SERIAL PRIMARY KEY,
                         name VARCHAR(64) NOT NULL,
                         category VARCHAR(64),
                         buy_price DOUBLE,
                         sell_price DOUBLE,
                         stock DOUBLE
);

CREATE TABLE sales (
                      sale_id SERIAL PRIMARY KEY,
                      total_cost DOUBLE
);

CREATE TABLE sale_items (
                           quantity_sold INT,
                           total_cost DOUBLE
);

CREATE TABLE stores (
                       store_id SERIAL PRIMARY KEY,
                       name VARCHAR(64),
                       nif INT,
                       address VARCHAR(100)
);

