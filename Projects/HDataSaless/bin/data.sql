-- Inserting into client table
INSERT INTO clients (name) VALUES ('John Doe');
INSERT INTO clients (name) VALUES ('Jane Smith');
INSERT INTO clients (name) VALUES ('Bob Johnson');

-- Inserting into product table
INSERT INTO products (name, category, buy_price, sell_price, stock)
VALUES ('Product A', 'Category X', 10.00, 20.00, 100);
INSERT INTO products (name, category, buy_price, sell_price, stock)
VALUES ('Product B', 'Category Y', 15.00, 25.00, 200);
INSERT INTO products (name, category, buy_price, sell_price, stock)
VALUES ('Product C', 'Category Z', 8.00, 18.00, 150);

-- Inserting into sale table
INSERT INTO sales (total_cost) VALUES (100.00);
INSERT INTO sales (total_cost) VALUES (150.00);
INSERT INTO sales (total_cost) VALUES (200.00);

-- Inserting into sale_item table
INSERT INTO sale_items (quantity_sold, total_cost) VALUES (5, 50.00);
INSERT INTO sale_items (quantity_sold, total_cost) VALUES (8, 100.00);
INSERT INTO sale_items (quantity_sold, total_cost) VALUES (10, 150.00);

-- Inserting into store table
INSERT INTO stores (name, nif, address)
VALUES ('Store A', 123456789, '123 Main St');
INSERT INTO stores (name, nif, address)
VALUES ('Store B', 987654321, '456 Elm St');
