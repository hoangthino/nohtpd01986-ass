CREATE DATABASE SHOPBU1;
USE SHOPBU1;

-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-01-30 13:54:34.069

-- tables
-- Table: bill
CREATE TABLE bill (
    total double(10,2) NOT NULL,
    payment varchar(50) NOT NULL,
    address varchar(70) NOT NULL,
    date date NOT NULL,
    khachhang_2_id int NOT NULL,
    bill_id int NOT NULL AUTO_INCREMENT,
    CONSTRAINT bill_pk PRIMARY KEY (bill_id)
);

-- Table: bill_detail
CREATE TABLE bill_detail (
    bill_detail_id int NOT NULL AUTO_INCREMENT,
    price double(10,2) NOT NULL,
    quantity int NOT NULL,
    product_product_id int NOT NULL,
    bill_bill_id int NOT NULL,
    CONSTRAINT bill_detail_pk PRIMARY KEY (bill_detail_id)
);

-- Table: category
CREATE TABLE category (
    category_id int NOT NULL AUTO_INCREMENT,
    category_name int NOT NULL,
    CONSTRAINT category_pk PRIMARY KEY (category_id)
);

-- Table: khachhang
CREATE TABLE khachhang (
    id int NOT NULL AUTO_INCREMENT,
    fname varchar(20) NOT NULL,
    lname varchar(20) NOT NULL,
    fullname varchar(100) NOT NULL,
    sex bigint NOT NULL,
    phone varchar(12) NOT NULL,
    email varchar(100) NOT NULL,
    adress varchar(100) NOT NULL,
    CONSTRAINT khachhang_pk PRIMARY KEY (id)
);

-- Table: product
CREATE TABLE product (
    product_id int NOT NULL AUTO_INCREMENT,
    product_name varchar(50) NOT NULL,
    product_price double(10,2) NOT NULL,
    product_description varchar(50) NOT NULL,
    product_image varchar(100) NOT NULL,
    category_category_id int NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (product_id)
);

-- foreign keys
-- Reference: bill_detail_bill (table: bill_detail)
ALTER TABLE bill_detail ADD CONSTRAINT bill_detail_bill FOREIGN KEY bill_detail_bill (bill_bill_id)
    REFERENCES bill (bill_id);

-- Reference: bill_detail_product (table: bill_detail)
ALTER TABLE bill_detail ADD CONSTRAINT bill_detail_product FOREIGN KEY bill_detail_product (product_product_id)
    REFERENCES product (product_id);

-- Reference: bill_khachhang (table: bill)
ALTER TABLE bill ADD CONSTRAINT bill_khachhang FOREIGN KEY bill_khachhang (khachhang_2_id)
    REFERENCES khachhang (id);

-- Reference: product_category (table: product)
ALTER TABLE product ADD CONSTRAINT product_category FOREIGN KEY product_category (category_category_id)
    REFERENCES category (category_id);

-- End of file.

