![Patika](https://github.com/m1erla/javaPatika/blob/de6ecc4983fb627feccd58c9d2a34f9ad954e888/src/patika-dev2.png)


# SQL Lesson

### Homework 1 WHERE and Comparison and Logical Operators
---
```sh 
1. SELECT title, description FROM film;
2. SELECT * FROM film WHERE length >60 AND length <75;
3. SELECT * FROM film WHERE rental_rate = 0.99 AND replacement_cost = 12.99 OR replacement_cost = 28.99;
4. SELECT * FROM customer WHERE first_name = 'Mary'; -- last_name value = 'Smith'
5. SELECT * FROM film WHERE NOT (length >= 50 AND rental_rate = 2.99 OR rental_rate = 4.99);
```

### Homework 2 BETWEEN ve IN
---
```sh 
1. SELECT * FROM film WHERE replacement_cost BETWEEN 12.99 AND 16.99;
2. SELECT first_name, last_name FROM actor WHERE first_name IN ('Penelope','Nick','Ed');
3. SELECT * FROM film WHERE rental_rate IN (0.99,2.99,4.99) AND replacement_cost IN (12.99,15.99,29.99);
```

### Homework 3 LIKE ve ILIKE
---
```sh 
1. SELECT country FROM public.country WHERE country LIKE 'A%a';
2. SELECT country FROM public.country WHERE country LIKE '______%n';
3. SELECT title FROM public.film WHERE title ILIKE '%T____'; -- '!--*' == NOT ILIKE or '--*' == ILIKE or '--' == LIKE
4. SELECT * FROM public.film WHERE title LIKE 'C%' AND length > 90 AND rental_rate = 2.99;
```

### Homework 4 DISTINCT ve COUNT
---
```sh 
1. SELECT DISTINCT replacement_cost FROM public.film;
2. SELECT COUNT(DISTINCT replacement_cost) FROM public.film;
3. SELECT COUNT(title) FROM public.film WHERE title LIKE 'T%' AND rating = 'G';
4. SELECT COUNT(country) FROM public.country WHERE country LIKE '_____';
```

### Homework 5 ORDER BY LIMIT ve OFFSET
---
```sh 
1. SELECT title, length FROM film WHERE title LIKE '%n' ORDER BY length DESC LIMIT 5;
2. SELECT title, length FROM film WHERE title LIKE '%n' ORDER BY length ASC OFFSET 5 LIMIT 5;
3. SELECT last_name, store_id FROM customer WHERE store_id = 1 ORDER BY last_name DESC LIMIT 4;
```

### Homework 6 Aggregate Functions
---
```sh 
1. SELECT AVG(rental_rate) FROM film;
2. SELECT COUNT(title) FROM film WHERE title LIKE 'C%';
3. SELECT MAX(length) FROM film WHERE rental_rate = 0.99;
4. SELECT COUNT(DISTINCT replacement_cost) FROM film WHERE length > 150;
```

### Homework 7 GROUP BY HAVING
---
```sh 
1. SELECT rating, COUNT(title) FROM film GROUP BY rating;
2. SELECT replacement_cost, COUNT(*) FROM film GROUP BY replacement_cost HAVING COUNT(*) > 50;
3. SELECT store_id, COUNT(*) FROM customer GROUP BY store_id;
4. SELECT country_id, COUNT(*) FROM city GROUP BY country_id ORDER BY COUNT(*) DESC LIMIT 1;
```
### Homework 8 Creating Tables Updating Data
---
```sh 
1. CREATE TABLE company (id SERIAL PRIMARY KEY, first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) NOT NULL, email VARCHAR(100), birthday DATE);
2. insert into employee (id, first_name, last_name, email, birthday) values (1, 'Pen', 'Jorck', 'pjorck0@wix.com', '1936-08-10');
   insert into employee (id, first_name, last_name, email, birthday) values (2, 'Ulric', 'Schellig', null, '1944-07-23');
   insert into employee (id, first_name, last_name, email, birthday) values (49, 'Eba', 'Mehew', 'emehew1c@sun.com', '1908-10-01');
   insert into employee (id, first_name, last_name, email, birthday) values (50, 'Frank', 'De-Ville', 'fdeville1d@slashdot.org', '1987-06-16');
3. UPDATE employee SET first_name = 'Jennifer', last_name = 'Lawrance', email = 'jennifer@lawrance.com', birthday = '1989-04-22' WHERE id = 5; UPDATE employee SET first_name = 'Emma', last_name = 'Stone', email = 'emma@stone.com', birthday = '1959-12-03' WHERE id = 1; UPDATE employee SET first_name = 'Tom', last_name = 'Hardy', email = 'tom@hardy.com', birthday = '2000-10-25' WHERE id = 20; UPDATE employee SET first_name = 'Ryan', last_name = 'Ghosling', email = 'ryan@ghosling.com', birthday = '1999-04-15' WHERE id = 44;
4. DELETE FROM employee WHERE  id = 2; DELETE FROM employee WHERE  id = 5; DELETE FROM employee WHERE  id = 7; DELETE FROM employee WHERE  id = 8; DELETE FROM employee WHERE  id = 15;
```

### Homework 9 INNER JOIN
---
```sh 
1. SELECT city, country FROM city INNER JOIN country ON city.country_id = country.country_id;
2. SELECT payment_id, first_name, last_name FROM customer INNER JOIN payment ON customer.customer_id = payment.customer_id;
3. SELECT rental_id, first_name, last_name FROM customer INNER JOIN rental ON customer.customer_id = rental.customer_id;
```

### Homework 10 LEFT JOIN RIGHT JOIN FULL JOIN
---
```sh 
1. SELECT city.city, country.country FROM city LEFT JOIN country ON city.country_id = country.country_id;
2. SELECT payment.payment_id, customer.first_name, customer.last_name FROM customer RIGHT JOIN payment ON customer.customer_id = payment.customer_id;
3. SELECT rental_id, first_name, last_name FROM customer FULL JOIN rental ON customer.customer_id= rental.customer_id;
```

### Homework 11 UNION INTERSECT EXCEPT
---
```sh 
1. SELECT first_name FROM actor UNION SELECT first_name FROM customer;
2. SELECT first_name FROM actor INTERSECT SELECT first_name FROM customer;
3. SELECT first_name FROM actor EXCEPT SELECT first_name FROM customer;
4. SELECT first_name FROM actor UNION ALL SELECT first_name FROM customer;
```

### Homework 12 INQUIRE SCENARIOS
---
```sh 
1. SELECT COUNT(*) FROM film WHERE length > ( SELECT AVG(length) FROM film );
2. SELECT COUNT(*) FROM film WHERE rental_rate = ( SELECT MAX(rental_rate) FROM film );
3. SELECT * FROM film WHERE rental_rate = ( SELECT MIN(rental_rate) FROM film ) AND replacement_cost = ( SELECT MIN(replacement_cost) FROM film );
4. SELECT customer_id, COUNT(*) AS transaction_count FROM payment GROUP BY customer_id ORDER BY transaction_count DESC;
```
### RECAP
---
```sh 
1. SELECT COUNT(*) FROM film WHERE title ILIKE '%e%e%e%e%';
2. SELECT COUNT(*), category.name FROM category JOIN film_category ON film_category.category_id = category.category_id JOIN film ON film.film_id = film_category.film_id GROUP BY category.name;
3. SELECT COUNT(*), rating FROM film  GROUP BY rating ORDER BY COUNT(*) DESC LIMIT 1;
4. SELECT title, length, replacement_cost FROM film WHERE title LIKE 'K%' ORDER BY length DESC, replacement_cost ASC LIMIT 3;
5. SELECT SUM(amount), customer.first_name, customer.last_name FROM payment JOIN customer ON customer.customer_id = payment.customer_id GROUP BY payment.customer_id, customer.first_name, customer.last_name ORDER BY SUM(amount) DESC LIMIT 1;
```