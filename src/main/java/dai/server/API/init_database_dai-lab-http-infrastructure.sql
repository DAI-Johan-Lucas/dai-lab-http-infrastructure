--
-- Database: family
-- Johan Mikami, Hussain Lucas
-- init_database_dai-lab-http-infrastructure.sql
--
CREATE SCHEMA family;
SET search_path TO family;

CREATE TABLE person (
    firstname VARCHAR(30),
    lastname VARCHAR(30) NOT NULL,
    birthdate DATE,
    phone VARCHAR(30),
    FK_address INTEGER,
    PRIMARY KEY (firstname)
);

CREATE TABLE address (
    id INTEGER,
    street VARCHAR(30) NOT NULL,
    npa VARCHAR(10) NOT NULL,
    city VARCHAR(30) NOT NULL,
    country VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE person
ADD CONSTRAINT fk_person_adresse
    FOREIGN KEY (FK_address) REFERENCES address(id);