/*CREATE TABLE Person(
	id integer NOT NULL,
	name varchar(250) Not NULL,
	location varchar(250),
	birth_date timestamp,
	primary key(id)
);*/

INSERT INTO Person ( ID , NAME , LOCATION , BIRTH_DATE ) VALUES
 (10001, 'Sathya', 'Chennai', current_timestamp),
 (10002, 'John', 'New York', current_timestamp),
 (10003, 'Doe', 'California', current_timestamp);
