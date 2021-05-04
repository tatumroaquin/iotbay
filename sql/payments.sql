CREATE TABLE Payments(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   customer_id INT NOT NULL,
   firstName VARCHAR(255), 
   lastName VARCHAR(255),
   cardNumber VARCHAR(16) NOT NULL,
   expiryDate DATE,

   FOREIGN KEY (customer_id) REFERENCES Customers(id)
);
