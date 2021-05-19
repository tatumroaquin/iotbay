CREATE TABLE Customers (
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   email VARCHAR(128) NOT NULL,
   password VARCHAR(128) NOT NULL,
   mobile VARCHAR(20),
   firstName VARCHAR(255) NOT NULL,
   lastName VARCHAR(255) NOT NULL,
   street VARCHAR(128) NOT NULL,
   city VARCHAR(128) NOT NULL,
   state VARCHAR(20) NOT NULL,
   postCode INTEGER NOT NULL,
   country VARCHAR(20) NOT NULL
);

INSERT INTO Customers (email, password, mobile, firstName, lastName, street, city, state, postCode, country) 
VALUES
('henry.seaborn@email.com', 'password1', '(02) 9025 6750', 'Henry', 'Seaborn', '1 street Avenue', 'GOROKAN', 'NSW', 1000, 'Australia'),
('michael.arnot@email.com', 'password2', '(02) 9025 6751', 'Michael', 'Arnot', '2 street', 'WAVERLEY', 'QLD', 1001, 'Australia'),
('john.doe@email.com', 'password3', '(02) 9025 6752', 'John', 'Doe', '3 street', 'ROCKDALE', 'NSW', 2216, 'Australia'),
('jane.doe@email.com', 'password4', '(02) 9025 6753', 'Jane', 'Doe', '4 street', 'MOSSIFACE', 'VIC', 3885, 'Australia'),
('jackie.chan@email.com', 'password5', '(02) 9025 6754', 'Henry', 'Seaborn', '5 street', 'GOLLAN', 'NSW', 2820, 'Australia'),
('asdf@iotbay.com', 'asdf1234', '(02) 9025 6754', 'Asdf', 'Macro', '7 Street', 'Laniakeia', 'NSW', 8338, 'Australia');
