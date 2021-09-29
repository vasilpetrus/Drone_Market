USE droneMarket;

/* todo --------------filling in the table "Roles"---------------------*/
INSERT INTO Roles (role)
VALUES ('user');

INSERT INTO Roles (role)
VALUES ('admin');

/* todo --------------filling in the table "UserInformation"---------------------*/
INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Василь', 'Петрус', 'Юрійович', 380958641797);

INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Любомир', 'Геревич', 'Богданович', 380951111111);

INSERT INTO UserInformation (name, surname, patronymic, phone)
VALUES ('Едіта', 'Сливка', 'Юріївна', 380952222222);

/* todo --------------filling in the table "BankCards"---------------------*/
INSERT INTO BankCards (card_number, expiration_year, expiration_month, card_owner, cvv, balance)
VALUES (4149499323651245, 2024, 08, 'LUBOMIR HEREVYCH', 993, 10523.11);

INSERT INTO BankCards (card_number, expiration_year, expiration_month, card_owner, cvv, balance)
VALUES (4149499325684512, 2022, 12, 'LUBOMIR HEREVYCH', 115, 345002.52);

INSERT INTO BankCards (card_number, expiration_year, expiration_month, card_owner, cvv, balance)
VALUES (4149499325621478, 2023, 05, 'SLIVKA EDITA', 348, 18014.87);

/* todo --------------filling in the table "Users"---------------------*/
INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (1, 2, 'petrus.vasil@gmail.com', SHA1('Petrus123'));

INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (2, 1, 'herevych.lubomir@gmail.com', SHA1('Herevych123'));

INSERT INTO Users (userInformation_id, role_id, email, password)
VALUES (3, 1, 'slivka.edita@mail.ru', SHA1('Slivka123'));

/* todo --------------filling in the table "UserOrders"---------------------*/
INSERT INTO UserOrders (address, order_date, delivery_date, status)
VALUES ('м. Свалява, вул. Головна, 91', '2021-09-18', '2021-09-21', 'очікується');

INSERT INTO UserOrders (address, order_date, delivery_date, status)
VALUES ('м. Мукачево, вул. Миру, 31Б', '2021-09-16', '2021-09-24','очікується');

INSERT INTO UserOrders (address, order_date, delivery_date, status)
VALUES ('м. Ужгород, вул. Корзо, 15', '2021-09-18', '2021-09-27', 'очікується');

/* todo --------------filling in the table "Categories"---------------------*/
INSERT INTO Categories (category)
VALUES ('Consumer');

INSERT INTO Categories (category)
VALUES ('Enterprise');

INSERT INTO Categories (category)
VALUES ('Professional');

/* todo --------------filling in the table "Products"---------------------*/
INSERT INTO Products (category_id, name, price, status, photo, orders_number, description)
VALUES (1, 'DJI Mavic Mini Fly More Combo', 15595.00, 1, 'consumer/mavic-mini-combo.jpg', 2,
        'Дрон з 12 Мп камерою, GPS, 3 акумулятори, дальність: 2 км, до 30 хв. польоту, пульт, кейс, захист лопастей');

INSERT INTO Products (category_id, name, price, status, photo, orders_number, description)
VALUES (1, 'DJI Mavic Mini 2 Fly More Combo', 16800.00, 1, 'consumer/mavic-mini-2-flymore-combo.jpg', 10,
        'Дрон з 12 Мп камерою, GPS, 3 акумулятори, дальність: 6 км, до 31 хв. польоту, пульт, сумка, захист лопастей');

INSERT INTO Products (category_id, name, price, status, photo, orders_number, description)
VALUES (1, 'DJI Air 2S Fly More Combo', 47499.00, 1, 'consumer/Mavic-Air-2S-Fly-More-Combo.jpeg', 3,
        'Дрон з 5,4K камерою на 20 Мп, FPV, GPS, БК мотори, дальність: 18.5 км, 2 АКБ, до 31 хвилин польоту, пульт, сумка');

INSERT INTO Products (category_id, name, price, status, photo, orders_number, description)
VALUES (2, 'DJI Mavic 2 Zoom', 56920.00, 1, 'professional/DJI-Mavic2-Zoom.jpg', 4,
        'Дрон з 12 Мп камерою, GPS, БК двигуни, дальність: 6 км, 3 АКБ, 31 хв. польоту, пульт, сумка');

INSERT INTO Products (category_id, name, price, status, photo, orders_number, description)
VALUES (2, 'DJI Mavic 2 Pro', 58520.00, 1, 'professional/mavic2-pro.jpeg', 6,
        'Дрон з 12 Мп камерою, GPS, БК двигуни, дальність: 6 км, 2 АКБ, 31 хв. польоту, пульт, сумка');

INSERT INTO Products (category_id, name, price, status, photo, orders_number, description)
VALUES (3, 'DJI Matrice 300 RTK', 259000.00, 1, 'enterprise/m300-premium.jpg', 10,
        'Комерційна політна платформа, дальність: 15 км, 8 АКБ, 51 хв. польоту, захист рівня IP45');

INSERT INTO Products (category_id, name, price, status, photo, orders_number, description)
VALUES (3, 'DJI Matrice 600 Pro', 295500.00, 0, 'enterprise/dji-matrice-600-pro.png', 10,
        'Комерційна політна платформа, дальність: 15 км, 6 АКБ, 51 хв. польоту, захист рівня IP45');

/* todo --------------filling in the table "Orders"---------------------*/
INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (1, 3, 1, 1);

INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (4, 3, 1, 1);

INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (2, 3, 2, 1);

INSERT INTO Orders (product_id, user_id, userOrder_id, number)
VALUES (5, 2, 3, 2);