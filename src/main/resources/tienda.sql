CREATE DATABASE IF NOT EXISTS tienda;

CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'user_password';

GRANT SELECT ON tienda.* TO 'user'@'%';

FLUSH PRIVILEGES;

USE tienda;

CREATE TABLE IF NOT EXISTS productos(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    precio FLOAT NOT NULL,
    proveedorId INT NOT NULL,
    PRIMARY KEY(id)
);
    
CREATE TABLE IF NOT EXISTS proveedores(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(255),
    url TINYTEXT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS productos_sugeridos(
    productoId INT NOT NULL,
    productoSugeridoId INT NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT FOREIGN KEY producto_proveedor_fk(proveedorId) REFERENCES proveedores(id);
ALTER TABLE productos_sugeridos ADD CONSTRAINT FOREIGN KEY producto_productos_sugeridos_fk(productoId) REFERENCES productos(id);
ALTER TABLE productos_sugeridos ADD CONSTRAINT FOREIGN KEY productos_sugeridos_producto_fk(productoSugeridoId) REFERENCES productos(id);
