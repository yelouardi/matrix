DROP TABLE IF EXISTS person;

CREATE TABLE person (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail_adresses VARCHAR(250) DEFAULT NULL,
  birth_date DATE DEFAULT NULL
);

INSERT INTO person (first_name, last_name, mail_adresses, birth_date) VALUES
  ('Aliko', 'Dangote', 'adangote@sqli.com','1973-11-17'),
  ('Amira', 'El ouardi', 'aelouardi@sqli.com','2015-09-26'),
  ('Ibrahim', 'El ouardi', 'ielouardi@sqli.com','2016-10-23'),
  ('Yassine', 'El ouardi', 'yelouardi@sqli.com','1986-09-14')
