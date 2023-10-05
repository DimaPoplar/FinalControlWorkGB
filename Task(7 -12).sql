CREATE DATABASE humanfriend;
USE humanfriend;
-- DROP DATABASE humanfriend;

CREATE TABLE IF NOT EXISTS AnimalType 
(
    id_animalType INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	animalType VARCHAR(30)
);

INSERT INTO AnimalType(animalType)
VALUES
('Домашние животные'), -- 1
('Вьючные животные'); -- 2
 
CREATE TABLE IF NOT EXISTS Animal
 (
	id_Animal INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    AnimalClassName VARCHAR(15),
    AnimalClass_id INT NOT NULL,
    typeAnimal INT NOT NULL,
	FOREIGN KEY (typeAnimal) REFERENCES AnimalType(id_animalType)
 );
 
INSERT INTO Animal(AnimalClassName, AnimalClass_id, typeAnimal)
VALUES
('Dog', 1, 1),  -- 1
('Cat', 2, 1), -- 2 
('Hamster', 3, 1), -- 3
('Horse', 4, 2), -- 4
('Camel', 5, 2), -- 5
('Dunke', 6, 2); -- 6


CREATE TABLE IF NOT EXISTS AllAnimal
(
	id_Animal INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name VARCHAR(15) NOT NULL,
	command VARCHAR(45) NOT NULL,
	birthdate DATE NOT NULL,
    typeAnimal_id INT NOT NULL,
    AnimalClass_id INT NOT NULL,
	FOREIGN KEY (typeAnimal_id) REFERENCES AnimalType(id_animalType),
    FOREIGN KEY (AnimalClass_id) REFERENCES Animal(id_Animal)
); 

INSERT INTO AllAnimal(name, command, birthdate, typeAnimal_id, AnimalClass_id) 
VALUES
('Horny', 'Кувырок', '2015-05-20', 1, 1),
('Shorti', 'Голос', '2016-04-10', 1, 2),
('Sopi', 'Дать лапу', '2014-09-01', 1, 3),
('Koli','Бежать', '2021-02-04', 2, 1),
('Noji','Скакть', '2018-07-15', 2, 4),
('Void','Вычислять', '2017-03-08', 2, 5), 
('Bobi','Рисовать', '2020-08-24', 1, 1),
('Hurebi','Охранять', '2022-05-20',2 , 6),
('Kopati4','Учиться', '2022-07-12',1, 3);

DELETE FROM AllAnimal WHERE typeAnimal_id = 2 AND AnimalClass_id = 5;

CREATE TABLE HorseAndDonkey AS
   SELECT * from AllAnimal WHERE AnimalClass_id = 4
   UNION
   SELECT * from AllAnimal WHERE AnimalClass_id = 6;

CREATE TABLE YoungAnimals AS
  SELECT id_Animal, name,command, birthdate, 
  datediff(curdate(), birthdate) DIV 31 as ageInMounth, typeAnimal_id, AnimalClass_id
  from AllAnimal
  WHERE date_add(birthdate, INTERVAL 1 YEAR) < curdate() AND date_add(birthDate, INTERVAL 3 YEAR) > curdate();
  
CREATE TABLE IF NOT EXISTS animal_registry (
    id_Animal INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name VARCHAR(15) NOT NULL,
	command VARCHAR(45),
	birthdate DATE NOT NULL,
    typeAnimal_id INT NOT NULL,
    AnimalClass_id INT NOT NULL,
	ageInMounth INT,
	previousTable VARCHAR(30)
);

INSERT INTO animal_registry (id_Animal, name, command, birthdate, typeAnimal_id, AnimalClass_id, ageInMounth, previousTable)
SELECT aa.id_Animal, aa.name, aa.command, aa.birthdate, aa.typeAnimal_id, aa.AnimalClass_id, datediff(curdate(), birthdate) DIV 31 asageInMounth, 'AllAnimal' AS previousTable
FROM AllAnimal aa
WHERE date_add(aa.birthdate, INTERVAL 1 YEAR) > curdate() OR date_add(aa.birthDate, INTERVAL 3 YEAR) < curdate()
UNION ALL
SELECT ya.id_Animal, ya.name, ya.command, ya.birthdate, ya.ageInMounth, ya.typeAnimal_id, ya.AnimalClass_id, 'YoungAnimals' AS previousTable
FROM YoungAnimals ya




  