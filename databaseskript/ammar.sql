CREATE DATABASE IF NOT EXISTS Ammar;
USE Ammar;
DROP TABLE IF EXISTS Users;


CREATE TABLE Users
(
    FirstName   VARCHAR(255) NOT NULL,
    LastName    VARCHAR(255) NOT NULL,
    Email       VARCHAR(255) UNIQUE NOT NULL,
    Password    VARCHAR(255) NOT NULL
);

/*
INSERT INTO Users (FirstName, LastName, Email, Password, Admin)
VALUES ('Viktor', 'Hokland', 'viktor@gmail.com', '123456', true);

INSERT INTO Users (FirstName, LastName, Email, Password, Admin)
VALUES ('Eivind', 'Halsnes', 'eivind@gmail.com', '123456', false);

INSERT INTO Users (FirstName, LastName, Email, Password, Admin)
VALUES ('Sebastian', 'Larsen', 'sebastian@gmail.com', '123456', false);

INSERT INTO Users (FirstName, LastName, Email, Password, Admin)
VALUES ('Ammar', 'Haddad', 'ammar@gmail.com', '123456', false);


 */