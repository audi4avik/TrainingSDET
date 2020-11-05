use sdet4_avik;
-- Activity 1 > create table
create table salesman(
salesman_id int primary key,
name varchar(32),
city varchar(32),
commisiion int
);

describe salesman;

-- Activity 2 > insert a single value
insert into salesman values (1001, 'John Doe', 'New York', 15);
select * from salesman;

-- insert multiple rows
insert into salesman values 
(1002, 'Jane Doe', 'Paris', 16),
(1003, 'Kylie Doe', 'Lyon', 12),
(1004, 'Elle Jane', 'Berlin', 9),
(1005, 'Nom Nom', 'Stockholm', 3);

-- View all columns
select * from salesman;

-- Activity 3 > Different selections
select salesman_id, city from salesman;
select * from salesman where city='Paris';
select salesman_id, commission from salesman where name='Jane Doe';

-- Activity 4 > Alter and Update
ALTER TABLE salesman ADD grade int;
UPDATE salesman SET grade=100;
SELECT * FROM salesman;

-- Activity 5
UPDATE salesman SET grade=200 WHERE city='Rome';
UPDATE salesman SET grade=300 WHERE name='James Hoog';
UPDATE salesman SET name='Pierre' WHERE name='McLyon';

