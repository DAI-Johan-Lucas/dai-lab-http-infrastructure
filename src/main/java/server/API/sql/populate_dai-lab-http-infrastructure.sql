--
-- Database: family
-- Johan Mikami, Hussain Lucas
-- populate_dai-lab-http-infrastructure.sql
--

SET SEARCH_PATH TO family;

-- --------------------------------------------------------
--
-- Dumping data for table person
--
INSERT INTO address VALUES(1, 'Rue de la Gare 1', '1000', 'Lausanne', 'Switzerland');
INSERT INTO address VALUES(2, 'Avenue du chapiteau 5', '1400', 'Yverdon-les-Bains', 'Switzerland');
INSERT INTO address VALUES(3, 'Ruelle Rousseau 12', '2114', 'Fleurier', 'Switzerland');

INSERT INTO person VALUES(1, 'John', 'Doe', '1981-06-19', '+41 111 22 33', 1);
INSERT INTO person VALUES(2, 'Mark', 'Grayson', '2000-01-05', '+41 666 23 31', 2);
INSERT INTO person VALUES(3, 'Kalye', 'Huston', '1987-09-11', '+41 321 45 67', 3);
INSERT INTO person VALUES(4, 'Bob', 'Huston', '1988-11-09', '+41 123 54 76', 3);

UPDATE person SET firstname = 'slt', lastname = 'mec', birthdate = '1981-06-19', phone = '+41 666 66 66',
                  fk_address = '1'
              WHERE id = '22';