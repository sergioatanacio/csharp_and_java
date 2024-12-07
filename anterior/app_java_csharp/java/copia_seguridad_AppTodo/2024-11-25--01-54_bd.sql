-- Conéctate a MySQL como root (sin contraseña)
mysql -u root

-- Crear la base de datos
CREATE DATABASE bd_todolist;

-- Usar la base de datos recién creada
USE bd_todolist;

-- Crear la tabla 'todos'
CREATE TABLE todos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    completed BOOLEAN DEFAULT FALSE
);
