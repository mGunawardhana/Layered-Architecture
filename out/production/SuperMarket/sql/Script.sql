DROP DATABASE IF EXISTS Supermarket;
CREATE DATABASE IF NOT EXISTS Supermarket;
SHOW DATABASES ;
USE Supermarket;


#---------------------------------------
--       CREATE TABLE CUSTOMER
#---------------------------------------
DROP TABLE IF EXISTS Customer;
CREATE TABLE IF NOT EXISTS Customer(
   CustId VARCHAR(6),
   CustTitle VARCHAR(5),
   CustName VARCHAR(30) NOT NULL DEFAULT 'Unknown',
   CustAddress VARCHAR(30),
   City VARCHAR(20),
   Province VARCHAR(20),
   PostalCode VARCHAR(9),
   CONSTRAINT PRIMARY KEY (CustId)
);
SHOW TABLES ;
DESCRIBE Customer;


#---------------------------------------
--         CREATE TABLE ORDER
#---------------------------------------
DROP TABLE IF EXISTS Orders;
CREATE TABLE IF NOT EXISTS Orders(
   OrderId VARCHAR(6),
   OrderDate DATE,
   CustId VARCHAR(6),
   Cost double,
   CONSTRAINT PRIMARY KEY (OrderId),
   CONSTRAINT FOREIGN KEY (CustId) REFERENCES Customer(CustId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE Orders;


#---------------------------------------
--         CREATE TABLE ITEM
#---------------------------------------
DROP TABLE IF EXISTS Item;
CREATE TABLE IF NOT EXISTS Item(
   ItemCode VARCHAR(6),
   Description VARCHAR(50),
   PackSize VARCHAR(20),
   UnitPrice Decimal(6,2),
   QtyOnHand INT(5),
   Discount Decimal(6,2) DEFAULT 0,
   CONSTRAINT PRIMARY KEY (ItemCode)
);
SHOW TABLES ;
DESCRIBE Item;


#---------------------------------------
--     CREATE TABLE ORDER_DETAILS
#---------------------------------------
DROP TABLE IF EXISTS OrderDetail;
CREATE TABLE IF NOT EXISTS OrderDetail(
   OrderId VARCHAR(6),
   ItemCode VARCHAR(6),
   OrderQty INT(11),
   Price DECIMAL,
   Discount DECIMAL(6,2) DEFAULT 0,
   CONSTRAINT PRIMARY KEY (ItemCode,OrderId),
   CONSTRAINT FOREIGN KEY (ItemCode) REFERENCES Item(ItemCode) ON DELETE CASCADE ON UPDATE CASCADE ,
   CONSTRAINT FOREIGN KEY (OrderId) REFERENCES Orders (OrderId) ON DELETE CASCADE ON UPDATE CASCADE
);
SHOW TABLES ;
DESCRIBE OrderDetail;
