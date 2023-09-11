-- Inserting into clients table
INSERT INTO clients (name) VALUES ('John Doe');
INSERT INTO clients (name) VALUES ('Jane Smith');
INSERT INTO clients (name) VALUES ('Bob Johnson');

-- Inserting into stores table
INSERT INTO stores (name, nif, address)
VALUES ('Store A', 123456789, '123 Main St');
INSERT INTO stores (name, nif, address)
VALUES ('Store B', 987654321, '456 Elm St');

-- Inserting into products table
INSERT INTO products (name, category, buy_price, sell_price, stock, store_id)
VALUES ('Product A', 'Category X', 10.00, 20.00, 100, 1);
INSERT INTO products (name, category, buy_price, sell_price, stock, store_id)
VALUES ('Product B', 'Category Y', 15.00, 25.00, 200, 2);
INSERT INTO products (name, category, buy_price, sell_price, stock, store_id)
VALUES ('Product C', 'Category Z', 8.00, 18.00, 150, 1);
INSERT INTO products (name, category, buy_price, sell_price, stock, store_id)
VALUES ('Product D', 'Category B', 6.00, 128.00, 150, 1);


-- Inserting into sale_items table
INSERT INTO sale_items (product_id, quantity_sold, total_cost)
VALUES (1, 5, 50.00);
INSERT INTO sale_items (product_id, quantity_sold, total_cost)
VALUES (2, 8, 100.00);
INSERT INTO sale_items (product_id, quantity_sold, total_cost)
VALUES (3, 10, 150.00);

-- Inserting into sales table
INSERT INTO sales (client_id,store_id,total_cost,sale_item_id) VALUES (1,1,1100.00,2);
INSERT INTO sales (client_id,store_id,total_cost,sale_item_id) VALUES (2,1,2150.00,1);
INSERT INTO sales (client_id,store_id,total_cost,sale_item_id) VALUES (2,2,2200.00,1);

