CREATE TABLE Invoices(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   staff_id INT NOT NULL,
   supplier_id INT NOT NULL,
   orderDate DATE,
   deliveryDate DATE,

   FOREIGN KEY (staff_id) REFERENCES Staff(id),
   FOREIGN KEY (supplier_id) REFERENCES Suppliers(id)
);
