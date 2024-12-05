-- Crear la base de datos
CREATE DATABASE crud_db;

-- Usar la base de datos
USE crud_db;

-- Crear la tabla 'users'
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL
);





-- Crear la tabla 'roles'
CREATE TABLE roles (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

-- Insertar datos en la tabla 'roles'
INSERT INTO roles (role_name) VALUES
('Administrador'),
('Editor'),
('Usuario');




-- Agregar la columna 'role_id' a la tabla 'users'
ALTER TABLE users	
ADD COLUMN role_id INT;

-- Establecer la clave foránea con la tabla 'roles'
ALTER TABLE users
ADD FOREIGN KEY (role_id) REFERENCES roles(role_id);

INSERT INTO roles (role_name) VALUES ('Usuario');

SELECT role_id FROM roles WHERE role_name = 'Usuario';

delete FROM roles WHERE role_id = 4;

UPDATE users SET role_id = 3 WHERE role_id IS NULL;


SELECT * FROM users;
