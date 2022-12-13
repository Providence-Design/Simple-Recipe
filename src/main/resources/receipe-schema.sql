CREATE DATABASE recipe_recommendation;

CREATE TABLE recipe (
    id INT PRIMARY KEY,
	cuisine VARCHAR ( 50 ) UNIQUE NOT NULL,
	ingredients VARCHAR [] NOT NULL,
	instructions VARCHAR [] NOT NULL
);


CREATE TABLE ingredient (
    id INT PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
);

-- insert into ingredient table
INSERT INTO ingredient(id, name) VALUES (1, "rice")
INSERT INTO ingredient(id, name) VALUES (2, "oil")
INSERT INTO ingredient(id, name) VALUES (3, "pepper")

-- insert into recipe table
INSERT INTO recipe (id, Cuisine, Ingredients, Instructions) VALUES(1,'Jollof', ARRAY ['1','2','3'], ARRAY['Wash Rice', 'Boil Rice']);
INSERT INTO recipe (id, Cuisine, Ingredients, Instructions) VALUES(5,'Plain Rice', '', '');
INSERT INTO recipe (id, Cuisine, Ingredients, Instructions) VALUES(2,'Banku', '', '');
INSERT INTO recipe (id, Cuisine, Ingredients, Instructions) VALUES(3,'Kotomire', '', '');
INSERT INTO recipe (id, Cuisine, Ingredients, Instructions) VALUES(4,'Red Red', '', '');
INSERT INTO recipe (id, Cuisine, Ingredients, Instructions) VALUES(6,'Kelewele', '', '');

-- A recipe has one id
-- A recipe has one cuisine
-- A recipe has many ingredients
-- A recipe has many instructions

-- ingredient table
