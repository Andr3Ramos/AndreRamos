CREATE TABLE clients (
                        client_id SERIAL PRIMARY KEY,
                        name VARCHAR(16)
);
CREATE TABLE stores (
                        store_id SERIAL PRIMARY KEY,
                        name VARCHAR(64),
                        nif INT,
                        address VARCHAR(100)
);

CREATE TABLE products (
                         product_id SERIAL PRIMARY KEY,
                         name VARCHAR(64) NOT NULL,
                         category VARCHAR(64),
                         buy_price DECIMAL,
                         sell_price DECIMAL,
                         stock DECIMAL,
                         store_id INT,
                         FOREIGN KEY (store_id) REFERENCES stores(store_id)
);

CREATE TABLE sale_items (
                            sale_item_id SERIAL PRIMARY KEY,
                            product_id INT,
                            quantity_sold INT,
                            total_cost DECIMAL,
                            FOREIGN KEY (product_id) REFERENCES products(product_id)
);
CREATE TABLE sales (
                       sale_id SERIAL PRIMARY KEY,
                       client_id INT,
                       store_id INT,
                       total_cost DECIMAL,
                       sale_item_id INT,
                       FOREIGN KEY (store_id) REFERENCES stores(store_id),
                       FOREIGN KEY(sale_item_id) REFERENCES sale_items(sale_item_id)

);

