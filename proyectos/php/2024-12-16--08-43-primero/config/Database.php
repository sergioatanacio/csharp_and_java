<?php
// config/Database.php

class Database {
    private $host = "localhost";
    private $db_name = "tienda_1733536181";
    private $username = "root";
    private $password = "";
    public $conn;

    // Obtener la conexión
    public function getConnection(){
        $this->conn = null;

        try{
            $this->conn = new PDO("mysql:host=" . $this->host . ";dbname=" . $this->db_name, 
                                  $this->username, 
                                  $this->password);
            // Configurar el modo de error de PDO a excepción
            $this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch(PDOException $exception){
            echo "Error de conexión: " . $exception->getMessage();
        }

        return $this->conn;
    }
}
?>
