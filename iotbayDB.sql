/**
 * Author:  ormus
 * Created: 26/03/2021
 */

CREATE DATABASE iotbayDB;
USE iotbayDB;

CREATE TABLE Customers (
   id int NOT NULL AUTO_INCREMENT,
   email varchar(255) NOT NULL,
   password varchar(255) NOT NULL,
   firstName varchar(255) NOT NULL,
   lastName varchar(255) NOT NULL,
   PRIMARY KEY (id)
);

INSERT INTO Customers (email, password, firstName, lastName)
VALUES ('john.doe@email.com', 'password', 'John', 'Doe');
   
INSERT INTO Customers (email, password, firstName, lastName)
VALUES ('jane.doe@email.com', 'topsecret', 'Jane', 'Doe');