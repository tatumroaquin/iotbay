CREATE TABLE Suppliers(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   companyName VARCHAR(255) NOT NULL,
   email VARCHAR(128) NOT NULL,
   firstName VARCHAR(255) NOT NULL,
   lastName VARCHAR(255) NOT NULL,
   mobile VARCHAR(20) NOT NULL
);
INSERT INTO Suppliers(companyName, email, firstName, lastName, mobile) VALUES
('Apple', 'green.mantis@apple.com', 'Green', 'Mantis', '0483998473'),
('Microsoft', 'blue.mantis@apple.com', 'Blue', 'Mantis', '0483998474'),
('Cisco', 'cyan.mantis@apple.com', 'Cyan', 'Mantis', '0483998475');

