

--D1
SELECT CONCAT('€'debt FROM Clients WHERE name = 'Sara Lopes');

--D2
SELECT title FROM Movies WHERE genre = 'Action' AND rating > 8.5;

--D3
SELECT address, zip_code FROM Clients WHERE name = 'Joao Townsend';

--D4
UPDATE Clients SET phone_number = '999867874' WHERE name = 'Sara Lopes';

--D5
SELECT COUNT(*) FROM Copies WHERE is_on_loan = true;

--D6
SELECT title,rating FROM Movies ORDER BY rating DESC LIMIT 3;

--D7
SELECT tier, SUM(rating) FROM Movies GROUP BY tier;

--D8
SELECT rental_price FROM Movies WHERE title ='Ready Player One';

--D9
SELECT title 
FROM Movies 
WHERE id IN(
    SELECT movie_id 
    FROM Movie_Actors 
    WHERE actor_id IN(
        SELECT actor_id 
        FROM Actors 
        WHERE name = 'Scarlett Johansson'));

--D10
SELECT name 
FROM Attendants 
WHERE id IN(
    SELECT attendants_id 
    FROM Loans 
    WHERE movie_id IN(
        SELECT movie_id  
        FROM Movies 
        WHERE rental_price > 5));

--D11
SELECT AVG(age) 
FROM Clients 
WHERE id IN(
    SELECT client_id 
    FROM Loans 
    WHERE movie_id IN(
        SELECT movie_id 
        FROM Movies 
        WHERE title = 'Ghost in the Shell'
    )
);

--D12
SELECT copie_id
FROM Copies
WHERE movie_id IN(
    SELECT id
    FROM Movies 
    WHERE title ='I, Robot')
        AND is_on_loan = false;           

--D13
SELECT name 
From Clients 
WHERE id IN(
    SELECT client_id 
    FROM Loans 
    WHERE movie_id IN(
        SELECT id 
        From Movies 
        WHERE tier = 'Super'
    )
);
 
--D14
UPDATE Movies SET stock = stock - 1 WHERE title = 'I, Robot';

--D15
SELECT title 
FROM Movies 
WHERE id IN (
    SELECT movie_id 
    FROM Movie_Actors 
    WHERE actor_id = (
        SELECT id 
        FROM Actors 
        WHERE name = 'Scarlett Johansson'))
            AND id NOT IN (
                SELECT movie_id 
                FROM Loans 
                WHERE client_id = (
                    SELECT id 
                    FROM Clients 
                    WHERE name = 'Joao Townsend'
    )
);

--D16
SELECT title, return_date
FROM Movies, Loans 
WHERE Movies.id IN(
    SELECT movie_id 
    FROM Movies 
    WHERE client_id = (
        SELECT id 
        FROM Clients  
        WHERE name = 'Joao Oliveira' ))
             AND is_returned = false;

--D17
SELECT SUM(rental_price)
FROM Movies
WHERE title = 'Ghost in the Shell'
    AND id IN (
        SELECT movie_id
        FROM Loans
        WHERE loan_date  BETWEEN '2023-7-14'AND '2023-7-28'
    );
