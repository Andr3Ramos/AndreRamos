CREATE TABLE Clients(
    id SERIAL PRIMARY KEY,
    name CHAR(30),
    age INTEGER,
    address CHAR(50),
    zip_code CHAR(8),
    phone_number INTEGER,
    debt NUMERIC
    );

CREATE TABLE Attendants(
    id SERIAL PRIMARY KEY,
    name CHAR(50)
    );

CREATE TABLE Movies(
    id SERIAL PRIMARY KEY,
    title CHAR(50),
    genre CHAR(50),
    tier CHAR(15),
    launch_date DATE,
    rating DECIMAL,
    stock INTEGER,
    rental_price NUMERIC
        );

CREATE TABLE Loans(
    loan_id SERIAL PRIMARY KEY,
    client_id INTEGER,
    attendants_id INTEGER,
    movie_id INTEGER,
    loan_date DATE,
    return_date DATE,
    is_returned BOOLEAN,
  
    FOREIGN KEY(attendants_id) REFERENCES Attendants(id),
    FOREIGN KEY(client_id) REFERENCES Clients(id),
    FOREIGN KEY(movie_id) REFERENCES Movies(id)
   );

CREATE TABLE Actors(
    id SERIAL PRIMARY KEY,
    name CHAR(50)
);

CREATE TABLE Movie_Actors (
  movie_id INTEGER ,
  actor_id INTEGER ,
  PRIMARY KEY (movie_id, actor_id),
  FOREIGN KEY (movie_id) REFERENCES Movies (id),
  FOREIGN KEY (actor_id) REFERENCES Actors (id)
);

CREATE TABLE Copies(
    copie_id SERIAL PRIMARY KEY,
    movie_id INTEGER,
    is_on_loan BOOLEAN,
    FOREIGN KEY(movie_id) REFERENCES Movies(id)
);

