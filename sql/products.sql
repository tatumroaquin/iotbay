CREATE TABLE Products(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   supplier_id INT NOT NULL,
   name VARCHAR(255) NOT NULL,
   price VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   quantity INT NOT NULL,

   FOREIGN KEY (supplier_id) REFERENCES Suppliers(id)
);
INSERT INTO Products(supplier_id, name, price, description, quantity) VALUES
(1, 'P4 Switch', '777', 'an SDN middle box with P4 enabled API', 10),
(2, 'OpenFlow Switch', '888', 'an SDN middle box with OpenFLow enabled API', 20),
(3, 'Zodiac Fx Switch', '999', 'an SDN middle box with Zodiac enabled API', 30);
