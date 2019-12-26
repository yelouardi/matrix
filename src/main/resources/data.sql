DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS profile_person;



CREATE TABLE profile_person (
  profile_id INT AUTO_INCREMENT  PRIMARY KEY,
  profile_title VARCHAR(250) NOT NULL,
  profile_description VARCHAR(250) NOT NULL
);

INSERT INTO profile_person (profile_title, profile_description) VALUES
  ('Developpeur Junior', 'Developpeur Junior 3ans'),
  ('Developpeur Sénior', 'Developpeur Sénior 5ans'),
  ('Business Analyste Junior', 'Business Analyste Junior 1an(s)'),
  ('Business Analyste Sénior', 'Business Analyste Sénior 5ans');

  CREATE TABLE person (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail_adresses VARCHAR(250) DEFAULT NULL,
  birth_date DATE DEFAULT NULL,
  profile_id INT NOT NULL
);

INSERT INTO person (first_name, last_name, mail_adresses, birth_date,profile_id) VALUES
  ('Aliko', 'Dangote', 'adangote@sqli.com','1973-11-17',1),
  ('Amira', 'El ouardi', 'aelouardi@sqli.com','2015-09-26',1),
  ('Ibrahim', 'El ouardi', 'ielouardi@sqli.com','2016-10-23',2),
  ('Yassine', 'El ouardi', 'yelouardi@sqli.com','1986-09-14',2);