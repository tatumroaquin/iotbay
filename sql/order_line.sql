CREATE TABLE Order_Line(
   order_id INT NOT NULL,
   product_id INT NOT NULL,

   FOREIGN KEY (order_id) REFERENCES Orders(id),
   FOREIGN KEY (product_id) REFERENCES Products(id),
   PRIMARY KEY (order_id, product_id)
);
