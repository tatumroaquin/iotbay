CREATE TABLE Product_Categories(
   product_id INT NOT NULL,
   category_id INT NOT NULL,

   FOREIGN KEY (product_id) REFERENCES Products(id),
   FOREIGN KEY (category_id) REFERENCES Categories(id),
   PRIMARY KEY (product_id, category_id)
);
