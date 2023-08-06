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