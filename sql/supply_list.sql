CREATE TABLE SupplyList(
   invoice_id INT NOT NULL,
   product_id INT NOT NULL,
   FOREIGN KEY (invoice_id) REFERENCES Invoices(id),
   FOREIGN KEY (product_id) REFERENCES Products(id),
   PRIMARY KEY (invoice_id, product_id)
);
