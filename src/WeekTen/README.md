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


### Homework 8
1. CREATE TABLE company (id SERIAL PRIMARY KEY, first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) NOT NULL, email VARCHAR(100), birthday DATE);
2. insert into employee (id, first_name, last_name, email, birthday) values (1, 'Pen', 'Jorck', 'pjorck0@wix.com', '1936-08-10');
   insert into employee (id, first_name, last_name, email, birthday) values (2, 'Ulric', 'Schellig', null, '1944-07-23');
   insert into employee (id, first_name, last_name, email, birthday) values (3, 'Marlie', 'Realy', 'mrealy2@unblog.fr', '1937-01-06');
   insert into employee (id, first_name, last_name, email, birthday) values (4, 'Annadiane', 'Gurko', 'agurko3@baidu.com', '1952-10-08');
   insert into employee (id, first_name, last_name, email, birthday) values (5, 'Tiffi', 'Fedynski', 'tfedynski4@hc360.com', null);
   insert into employee (id, first_name, last_name, email, birthday) values (6, 'Kristi', 'Teulier', 'kteulier5@unicef.org', '1965-02-28');
   insert into employee (id, first_name, last_name, email, birthday) values (7, 'Michaelina', 'Rawsthorne', 'mrawsthorne6@cnet.com', '1964-07-25');
   insert into employee (id, first_name, last_name, email, birthday) values (8, 'Paten', 'Jendrassik', 'pjendrassik7@i2i.jp', '1930-05-17');
   insert into employee (id, first_name, last_name, email, birthday) values (9, 'Major', 'Kingzet', 'mkingzet8@google.de', null);
   insert into employee (id, first_name, last_name, email, birthday) values (10, 'Tish', 'Chinn', 'tchinn9@printfriendly.com', '1957-11-22');
   insert into employee (id, first_name, last_name, email, birthday) values (11, 'Lorne', 'Kittley', 'lkittleya@freewebs.com', null);
   insert into employee (id, first_name, last_name, email, birthday) values (12, 'Enoch', 'Raoult', 'eraoultb@europa.eu', '1932-07-19');
   insert into employee (id, first_name, last_name, email, birthday) values (13, 'Ileana', 'Lepere', 'ileperec@spiegel.de', null);
   insert into employee (id, first_name, last_name, email, birthday) values (14, 'Colas', 'McKeggie', 'cmckeggied@china.com.cn', '1919-08-18');
   insert into employee (id, first_name, last_name, email, birthday) values (15, 'Arabel', 'McGeachey', null, null);
   insert into employee (id, first_name, last_name, email, birthday) values (16, 'Stevena', 'Barbisch', 'sbarbischf@sohu.com', '1927-04-18');
   insert into employee (id, first_name, last_name, email, birthday) values (17, 'Zelda', 'Plaskett', 'zplaskettg@craigslist.org', '1922-05-31');
   insert into employee (id, first_name, last_name, email, birthday) values (18, 'Benni', 'Ewin', 'bewinh@yahoo.co.jp', '1917-03-19');
   insert into employee (id, first_name, last_name, email, birthday) values (19, 'Lula', 'Lotwich', null, '1968-08-06');
   insert into employee (id, first_name, last_name, email, birthday) values (20, 'Sutton', 'Burnside', 'sburnsidej@nydailynews.com', '1943-10-23');
   insert into employee (id, first_name, last_name, email, birthday) values (21, 'Gino', 'Yurkov', 'gyurkovk@chron.com', '1979-06-11');
   insert into employee (id, first_name, last_name, email, birthday) values (22, 'Murry', 'Baldi', 'mbaldil@unesco.org', '1928-11-02');
   insert into employee (id, first_name, last_name, email, birthday) values (23, 'Cindra', 'Bachman', 'cbachmanm@irs.gov', '1906-10-09');
   insert into employee (id, first_name, last_name, email, birthday) values (24, 'Hersh', 'Willets', 'hwilletsn@arizona.edu', '1904-07-10');
   insert into employee (id, first_name, last_name, email, birthday) values (25, 'Doreen', 'Gensavage', 'dgensavageo@nih.gov', '1985-12-10');
   insert into employee (id, first_name, last_name, email, birthday) values (26, 'Dane', 'Tellenbrook', 'dtellenbrookp@github.com', '1934-10-27');
   insert into employee (id, first_name, last_name, email, birthday) values (27, 'Junette', 'Mangham', 'jmanghamq@webeden.co.uk', '1909-03-01');
   insert into employee (id, first_name, last_name, email, birthday) values (28, 'Sheffie', 'Arnell', 'sarnellr@cloudflare.com', '1958-07-28');
   insert into employee (id, first_name, last_name, email, birthday) values (29, 'Stinky', 'Kimmel', null, null);
   insert into employee (id, first_name, last_name, email, birthday) values (30, 'Elie', 'Doohan', 'edoohant@cnet.com', null);
   insert into employee (id, first_name, last_name, email, birthday) values (31, 'Leone', 'Hek', 'lheku@ted.com', '1975-04-29');
   insert into employee (id, first_name, last_name, email, birthday) values (32, 'Beckie', 'Rubinowicz', 'brubinowiczv@posterous.com', '1975-06-20');
   insert into employee (id, first_name, last_name, email, birthday) values (33, 'Denny', 'Thurlby', 'dthurlbyw@yellowpages.com', '1993-02-21');
   insert into employee (id, first_name, last_name, email, birthday) values (34, 'Kora', 'Martynka', null, '1996-11-07');
   insert into employee (id, first_name, last_name, email, birthday) values (35, 'Cathie', 'Buey', null, null);
   insert into employee (id, first_name, last_name, email, birthday) values (36, 'Gilemette', 'Tomsett', 'gtomsettz@topsy.com', null);
   insert into employee (id, first_name, last_name, email, birthday) values (37, 'Hieronymus', 'Beeze', 'hbeeze10@cisco.com', null);
   insert into employee (id, first_name, last_name, email, birthday) values (38, 'Gustavo', 'Harriss', 'gharriss11@omniture.com', null);
   insert into employee (id, first_name, last_name, email, birthday) values (39, 'Korney', 'Radin', 'kradin12@amazon.com', null);
   insert into employee (id, first_name, last_name, email, birthday) values (40, 'Rodolphe', 'Chaman', null, null);
   insert into employee (id, first_name, last_name, email, birthday) values (41, 'Livvyy', 'Pollard', 'lpollard14@seattletimes.com', null);
   insert into employee (id, first_name, last_name, email, birthday) values (42, 'Benjamin', 'Fike', null, '1909-09-26');
   insert into employee (id, first_name, last_name, email, birthday) values (43, 'Pamela', 'Luckett', 'pluckett16@cbslocal.com', '1989-02-02');
   insert into employee (id, first_name, last_name, email, birthday) values (44, 'Franciskus', 'Culbert', 'fculbert17@walmart.com', '1911-04-06');
   insert into employee (id, first_name, last_name, email, birthday) values (45, 'Rowen', 'Agg', 'ragg18@yellowbook.com', '1903-09-10');
   insert into employee (id, first_name, last_name, email, birthday) values (46, 'Renelle', 'Riggott', null, '1906-06-05');
   insert into employee (id, first_name, last_name, email, birthday) values (47, 'Gavrielle', 'Glasscoo', 'gglasscoo1a@webmd.com', '1958-06-19');
   insert into employee (id, first_name, last_name, email, birthday) values (48, 'Margalit', 'De Few', 'mdefew1b@macromedia.com', '1981-01-29');
   insert into employee (id, first_name, last_name, email, birthday) values (49, 'Eba', 'Mehew', 'emehew1c@sun.com', '1908-10-01');
   insert into employee (id, first_name, last_name, email, birthday) values (50, 'Frank', 'De-Ville', 'fdeville1d@slashdot.org', '1987-06-16');
3. UPDATE employee SET first_name = 'Jennifer', last_name = 'Lawrance', email = 'jennifer@lawrance.com', birthday = '1989-04-22' WHERE id = 5; UPDATE employee SET first_name = 'Emma', last_name = 'Stone', email = 'emma@stone.com', birthday = '1959-12-03' WHERE id = 1; UPDATE employee SET first_name = 'Tom', last_name = 'Hardy', email = 'tom@hardy.com', birthday = '2000-10-25' WHERE id = 20; UPDATE employee SET first_name = 'Ryan', last_name = 'Ghosling', email = 'ryan@ghosling.com', birthday = '1999-04-15' WHERE id = 44;
4. DELETE FROM employee WHERE  id = 2; DELETE FROM employee WHERE  id = 5; DELETE FROM employee WHERE  id = 7; DELETE FROM employee WHERE  id = 8; DELETE FROM employee WHERE  id = 15;