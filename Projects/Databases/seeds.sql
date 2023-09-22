

INSERT INTO Clients (name,age, address, zip_code, phone_number, debt) VALUES
  ('Joao Townsend',25, 'Rua das ervilhas n6', '7080-029', 999999999, 0),
  ('Sara Lopes',27, 'Rua das batatas n50', '2540-708', 988888888, 12.34),
  ('Joao Oliveira',33, 'Rua do sabugal n80', '4056-091', 977777777, 5.67);
  

  INSERT INTO Movies(title,genre,rating,tier,launch_date,stock,rental_price) VALUES
  ('Ghost in the Shell', 'Sci-Fi', 8.7, 'Special','2017-03-30',8, 9.99),
  ('Her', 'Romance', 8.9, 'Special','2014-02-13',9, 9.99),
  ('Ready Player One', 'Action', 8.6, 'Catalog','2018-03-29',6, 5.99),
  ('I, Robot', 'Sci-Fi', 7.1, 'Super','2004-09-02',4, 14.99);

  INSERT INTO Actors(name) VALUES 
  ('Scarlett Johansson'),
  ('Denzel Washington'),
  ('Tom Cruise');

  INSERT INTO Attendants(name) VALUES
  ('Remco Evenepoel'),
  ('Tadej Pogačar'),
  ('Jonas Vingegaard');

  INSERT INTO Loans(client_id,movie_id,attendants_id,loan_date,return_date,is_returned) VALUES
  (1,1,1,'2021-7-9','2021-8-10',true),
  (2,4,2,'2022-8-10','2022-9-10',false),
  (3,3,3,'2023-7-26','2023-8-26',false),
  (3,1,3,'2023-7-26','2023-8-26',false),
  (3,4,3,'2023-7-26','2023-8-26',false);


  INSERT INTO Movie_Actors(movie_id,actor_id) VALUES
  (1,1),
  (1,3),
  (2,2),
  (2,3),
  (3,1),
  (4,1);


  INSERT INTO Copies(movie_id,is_on_loan) VALUES
  (1,true),
  (1,true),
  (2,false),
  (2,true),
  (3,true),
  (4,false),
  (4,false);