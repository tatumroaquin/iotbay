CREATE TABLE Admin(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   email VARCHAR(128) NOT NULL,
   password VARCHAR(128) NOT NULL,
   mobile VARCHAR(20),
   firstName VARCHAR(255) NOT NULL,
   lastName VARCHAR(255) NOT NULL,
   street VARCHAR(255) NOT NULL,
   city VARCHAR(15) NOT NULL,
   state VARCHAR(15) NOT NULL,
   postCode INT NOT NULL,
   country VARCHAR(15) NOT NULL
);
INSERT INTO Admin(email, password, mobile, firstName, lastName, street, city, state, postCode, country) 
VALUES
('admin@iotbay.com', 'adminpass', '0413448593', 'Gerald', 'Boltor', '1 Avenue', 'GOROKAN', 'NSW', 1000, 'Australia');
