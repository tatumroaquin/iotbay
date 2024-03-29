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
CREATE TABLE Cities(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(25) NOT NULL
);

INSERT INTO Cities(name) VALUES 
('Adelaide'),
('Albany'),
('Albury'),
('Alice Springs'),
('Armidale'),
('Ballarat'),
('Bathurst'),
('Bendigo'),
('Brisbane'),
('Broken Hill'),
('Bunbury'),
('Bundaberg Central'),
('Busselton'),
('Cairns'),
('Canberra'),
('Coffs Harbour'),
('Darwin'),
('Devonport'),
('Dubbo'),
('Geelong'),
('Geraldton'),
('Gladstone Central'),
('Gold Coast'),
('Goulburn'),
('Hervey Bay'),
('Hobart'),
('Kalgoorlie Boulder'),
('Launceston'),
('Lismore'),
('Mackay'),
('Melbourne'),
('Mildura'),
('Mount Gambier'),
('Newcastle'),
('Nowra'),
('Orange'),
('Perth'),
('Port Agusta'),
('Port Lincoln'),
('Queanbeyan'),
('Rockhampton'),
('Shepparton'),
('Sydney'),
('Tamworth'),
('Toowoomba'),
('Townsville'),
('Traralgon'),
('Wagga'),
('Warrnambool'),
('Whyalla'),
('Wollogong');
CREATE TABLE States(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   acronym VARCHAR(3) NOT NULL,
   fullName VARCHAR(20) NOT NULL
);

INSERT INTO States(acronym, fullName)
VALUES 
('NSW','New South Wales'),
('NT','North Territory'),
('QLD','Queensland'),
('SA','South Australia'),
('TAS','Tasmania'),
('VIC','Victoria'),
('WA','Western Australia');
CREATE TABLE Customers (
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   email VARCHAR(128) NOT NULL,
   password VARCHAR(128) NOT NULL,
   mobile VARCHAR(20),
   firstName VARCHAR(255) NOT NULL,
   lastName VARCHAR(255) NOT NULL,
   street VARCHAR(128) NOT NULL,
   city VARCHAR(128) NOT NULL,
   state VARCHAR(20) NOT NULL,
   postCode INTEGER NOT NULL,
   country VARCHAR(20) NOT NULL
);

INSERT INTO Customers (email, password, mobile, firstName, lastName, street, city, state, postCode, country) 
VALUES
('henry.seaborn@email.com', 'password1', '(02) 9025 6750', 'Henry', 'Seaborn', '1 street Avenue', 'GOROKAN', 'NSW', 1000, 'Australia'),
('michael.arnot@email.com', 'password2', '(02) 9025 6751', 'Michael', 'Arnot', '2 street', 'WAVERLEY', 'QLD', 1001, 'Australia'),
('john.doe@email.com', 'password3', '(02) 9025 6752', 'John', 'Doe', '3 street', 'ROCKDALE', 'NSW', 2216, 'Australia'),
('jane.doe@email.com', 'password4', '(02) 9025 6753', 'Jane', 'Doe', '4 street', 'MOSSIFACE', 'VIC', 3885, 'Australia'),
('jackie.chan@email.com', 'password5', '(02) 9025 6754', 'Henry', 'Seaborn', '5 street', 'GOLLAN', 'NSW', 2820, 'Australia'),
('asdf@iotbay.com', 'asdf1234', '(02) 9025 6754', 'Asdf', 'Macro', '7 Street', 'Laniakeia', 'NSW', 8338, 'Australia');
CREATE TABLE Staff(
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
INSERT INTO Staff (email, password, mobile, firstName, lastName, street, city, state, postCode, country) 
VALUES
('asdf@iotbay.com', 'asdf1234', '(02) 9025 6750', 'Asdf', 'Micro', '1 Avenue', 'GOROKAN', 'NSW', 1000, 'Australia');
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

CREATE TABLE Categories(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(255) NOT NULL,
   description VARCHAR(255)
);
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
CREATE TABLE Product_Categories(
   product_id INT NOT NULL,
   category_id INT NOT NULL,

   FOREIGN KEY (product_id) REFERENCES Products(id),
   FOREIGN KEY (category_id) REFERENCES Categories(id),
   PRIMARY KEY (product_id, category_id)
);
CREATE TABLE Payments(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   customer_id INT NOT NULL,
   firstName VARCHAR(255), 
   lastName VARCHAR(255),
   cardNumber VARCHAR(16) NOT NULL,
   expiryDate DATE,

   FOREIGN KEY (customer_id) REFERENCES Customers(id)
);
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
CREATE TABLE Order_Line(
   order_id INT NOT NULL,
   product_id INT NOT NULL,

   FOREIGN KEY (order_id) REFERENCES Orders(id),
   FOREIGN KEY (product_id) REFERENCES Products(id),
   PRIMARY KEY (order_id, product_id)
);
CREATE TABLE Invoices(
   id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   staff_id INT NOT NULL,
   supplier_id INT NOT NULL,
   orderDate DATE,
   deliveryDate DATE,

   FOREIGN KEY (staff_id) REFERENCES Staff(id),
   FOREIGN KEY (supplier_id) REFERENCES Suppliers(id)
);
CREATE TABLE SupplyList(
   invoice_id INT NOT NULL,
   product_id INT NOT NULL,
   FOREIGN KEY (invoice_id) REFERENCES Invoices(id),
   FOREIGN KEY (product_id) REFERENCES Products(id),
   PRIMARY KEY (invoice_id, product_id)
);
CREATE TABLE UALCustomer(
   customer_id INT NOT NULL,
   login_date DATE NOT NULL,
   login_time TIME NOT NULL,
   logout_date DATE,
   logout_time TIME
);

INSERT INTO UALCustomer(customer_id, login_date, login_time, logout_date, logout_time)
VALUES
(1, '2021-04-16', '16:08:00', '2021-06-16', '17:08:00'),
(1, '2021-04-16', '16:08:00', null, null);

INSERT INTO UALCustomer(customer_id, login_date, login_time)
VALUES
(1, '2021-04-16', '16:08:00');
CREATE TABLE UALStaff(
   staff_id INT NOT NULL,
   login_date DATE NOT NULL,
   login_time TIME NOT NULL,
   logout_date DATE,
   logout_time TIME
);
INSERT INTO UALStaff(staff_id, login_date, login_time, logout_date, logout_time)
VALUES
(1, '2021-04-16', '16:08:00', '2021-06-16', '17:08:00'),
(1, '2021-04-16', '16:08:00', null, null);

INSERT INTO UALStaff(staff_id, login_date, login_time)
VALUES
(1, '2021-04-16', '16:08:00');

CREATE TABLE UALAdmin(
   admin_id INT NOT NULL,
   login_date DATE NOT NULL,
   login_time TIME NOT NULL,
   logout_date DATE,
   logout_time TIME
);
INSERT INTO UALAdmin(admin_id, login_date, login_time, logout_date, logout_time)
VALUES
(1, '2021-04-16', '16:08:00', '2021-06-16', '17:08:00'),
(1, '2021-04-16', '16:08:00', null, null);

INSERT INTO UALAdmin(admin_id, login_date, login_time)
VALUES
(1, '2021-04-16', '16:08:00');
