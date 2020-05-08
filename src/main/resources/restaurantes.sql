CREATE DATABASE IF NOT EXISTS restaurante;

USE restaurante;

CREATE TABLE IF NOT EXISTS menus(
    id INT AUTO_INCREMENT NOT NULL,
    platillo VARCHAR(255) NOT NULL,
    ingredientes TEXT NOT NULL,
    precio FLOAT NOT NULL,
    idRestaurante INT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS restaurantes(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE menus ADD CONSTRAINT FOREIGN KEY restaurantes_menus_fk(idRestaurante) REFERENCES restaurantes(id);

CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'user_password';

GRANT SELECT ON restaurante.* TO 'user'@'%';

FLUSH PRIVILEGES;
