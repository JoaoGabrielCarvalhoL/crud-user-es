CREATE TABLE users(
    userid  BIGINT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    cellphone VARCHAR(15) NOT NULL,
    college VARCHAR(50),
    profession VARCHAR(50),
    height DECIMAL(3,2),
    weight DECIMAL(5,2),
    haircolor VARCHAR(20),
    street VARCHAR(20),
    district VARCHAR(20),
    numberhouse VARCHAR(20),
    city VARCHAR(20));