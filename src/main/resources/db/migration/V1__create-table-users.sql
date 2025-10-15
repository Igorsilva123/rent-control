CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    nick_name VARCHAR(255),
    phone VARCHAR(50),
    rented_at DATE,
    active BOOLEAN
);

