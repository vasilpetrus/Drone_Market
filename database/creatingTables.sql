DROP DATABASE droneMarket;

CREATE DATABASE IF NOT EXISTS droneMarket;

USE droneMarket;

-- -----------------------------------------------------
-- Table droneMarket.Roles
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Roles
(
    id           BIGINT UNSIGNED AUTO_INCREMENT,
    role         VARCHAR(15) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table droneMarket.UserInformation
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS UserInformation
(
    id           BIGINT UNSIGNED AUTO_INCREMENT,
    name         VARCHAR(35),
    surname      VARCHAR(35),
    patronymic   VARCHAR(35),
    phone        BIGINT(15) UNSIGNED,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table droneMarket.BankCards
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS BankCards
(
    id                   BIGINT UNSIGNED AUTO_INCREMENT,
    userInformation_id   BIGINT UNSIGNED,
    card_number          BIGINT(16) UNSIGNED NOT NULL UNIQUE,
    expiration_year      SMALLINT(4) UNSIGNED NOT NULL,
    expiration_month     TINYINT(2) UNSIGNED NOT NULL,
    card_owner           VARCHAR(70) NOT NULL,
    cvv                  SMALLINT(3) UNSIGNED NOT NULL,
    balance              DOUBLE UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userInformation_id) REFERENCES UserInformation (id)
);

-- -----------------------------------------------------
-- Table droneMarket.Users
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Users
(
    id                   BIGINT UNSIGNED AUTO_INCREMENT,
    userInformation_id   BIGINT UNSIGNED,
    role_id              BIGINT UNSIGNED NOT NULL,
    email                VARCHAR(50) NOT NULL UNIQUE,
    password             VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userInformation_id) REFERENCES UserInformation (id),
    FOREIGN KEY (role_id) REFERENCES Roles (id)
);

-- -----------------------------------------------------
-- Table droneMarket.UserOrders
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS UserOrders
(
    id              BIGINT UNSIGNED AUTO_INCREMENT,
    address         VARCHAR(100) NOT NULL,
    order_date      DATE NOT NULL,
    delivery_date   DATE NOT NULL,
    status          VARCHAR(15) NOT NULL DEFAULT 'expected',
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table droneMarket.Categories
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Categories
(
    id           BIGINT UNSIGNED AUTO_INCREMENT,
    category     VARCHAR(45) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table droneMarket.Products
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Products
(
    id             BIGINT UNSIGNED AUTO_INCREMENT,
    category_id    BIGINT UNSIGNED NOT NULL,
    name           VARCHAR(100) NOT NULL UNIQUE,
    description    TEXT(2048),
    price          DOUBLE UNSIGNED NOT NULL,
    status         TINYINT(1) UNSIGNED NOT NULL DEFAULT 0,
    photo          VARCHAR(150) NOT NULL,
    orders_number  INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES Categories (id)
);

-- -----------------------------------------------------
-- Table droneMarket.Orders
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Orders
(
    id             BIGINT UNSIGNED AUTO_INCREMENT,
    product_id     BIGINT UNSIGNED NOT NULL,
    user_id        BIGINT UNSIGNED NOT NULL,
    userOrder_id   BIGINT UNSIGNED,
    number         SMALLINT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES Products (id),
    FOREIGN KEY (userOrder_id) REFERENCES UserOrders (id),
    FOREIGN KEY (user_id) REFERENCES Users (id)
);