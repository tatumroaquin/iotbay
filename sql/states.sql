CREATE TABLE States(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   acronym VARCHAR(3) NOT NULL,
   fullName VARCHAR(20) NOT NULL
);

INSERT INTO States(acronym, fullName)
VALUES 
('NSW','New South Wales'),
('NT','North Territory'),
('QLD','Queensland'),
('SA','South Australia'),
('TAS','Tasmania'),
('VIC','Victoria'),
('WA','Western Australia');
