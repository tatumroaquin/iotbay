CREATE TABLE Products(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   supplier_id INT NOT NULL,
   name VARCHAR(255) NOT NULL,
   price VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   quantity INT NOT NULL,

   FOREIGN KEY (supplier_id) REFERENCES Suppliers(id)
);
