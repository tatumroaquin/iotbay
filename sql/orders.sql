CREATE TABLE Orders(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   customer_id INT NOT NULL,
   payment_id INT NOT NULL,
   orderDate DATE,
   deliveryDate DATE,
   street VARCHAR(128) NOT NULL,
   city VARCHAR(128) NOT NULL,
   statei VARCHAR(20) NOT NULL,
   postCode VARCHAR(5) NOT NULL,
   country VARCHAR(20) NOT NULL,

   FOREIGN KEY (customer_id) REFERENCES Customers(id),
   FOREIGN KEY (payment_id) REFERENCES Payments(id)
);
