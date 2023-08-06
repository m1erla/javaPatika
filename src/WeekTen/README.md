# SQL Lesson

### Homework 1
1. SELECT title, description FROM film;
2. SELECT * FROM film WHERE length >60 AND length <75;
3. SELECT * FROM film WHERE rental_rate = 0.99 AND replacement_cost = 12.99 OR replacement_cost = 28.99;
4. SELECT * FROM customer WHERE first_name = 'Mary'; -- last_name value = 'Smith'
5. SELECT * FROM film WHERE NOT (length >= 50 AND rental_rate = 2.99 OR rental_rate = 4.99);


### Homework 2
1. SELECT * FROM film WHERE replacement_cost BETWEEN 12.99 AND 16.99;
2. SELECT first_name, last_name FROM actor WHERE first_name IN ('Penelope','Nick','Ed');
3. SELECT * FROM film WHERE rental_rate IN (0.99,2.99,4.99) AND replacement_cost IN (12.99,15.99,29.99);


### Homework 3
1. SELECT country FROM public.country WHERE country LIKE 'A%a';
2. SELECT country FROM public.country WHERE country LIKE '______%n';
3. SELECT title FROM public.film WHERE title ILIKE '%T____'; -- '!--*' == NOT ILIKE or '--*' == ILIKE or '--' == LIKE
4. SELECT * FROM public.film WHERE title LIKE 'C%' AND length > 90 AND rental_rate = 2.99;


### Homework 4
1. SELECT DISTINCT replacement_cost FROM public.film;
2. SELECT COUNT(DISTINCT replacement_cost) FROM public.film;
3. SELECT COUNT(title) FROM public.film WHERE title LIKE 'T%' AND rating = 'G';
4. SELECT COUNT(country) FROM public.country WHERE country LIKE '_____';


### Homework 5
1. SELECT title, length FROM film WHERE title LIKE '%n' ORDER BY length DESC LIMIT 5;
2. SELECT title, length FROM film WHERE title LIKE '%n' ORDER BY length ASC OFFSET 5 LIMIT 5;
3. SELECT last_name, store_id FROM customer WHERE store_id = 1 ORDER BY last_name DESC LIMIT 4;


### Homework 6
1. SELECT AVG(rental_rate) FROM film;
2. SELECT COUNT(title) FROM film WHERE title LIKE 'C%';
3. SELECT MAX(length) FROM film WHERE rental_rate = 0.99;
4. SELECT COUNT(DISTINCT replacement_cost) FROM film WHERE length > 150;


### Homework 7
1. SELECT rating, COUNT(title) FROM film GROUP BY rating;
2. SELECT replacement_cost, COUNT(*) FROM film GROUP BY replacement_cost HAVING COUNT(*) > 50;
3. SELECT store_id, COUNT(*) FROM customer GROUP BY store_id;
4. SELECT country_id, COUNT(*) FROM city GROUP BY country_id ORDER BY COUNT(*) DESC LIMIT 1;