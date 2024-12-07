<?php
// dao/ProveedorDAO.php
require_once '../config/Database.php';
require_once '../entidades/Proveedor.php';

class ProveedorDAO {
    private $conn;

    public function __construct(){
        $database = new Database();
        $this->conn = $database->getConnection();
    }

    // Obtener todos los proveedores
    public function getAll(){
        $query = "SELECT * FROM proveedores";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();

        $proveedores = [];

        while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
            $proveedor = new Proveedor(
                $row['id_proveedor'],
                $row['nombre'],
                $row['direccion'],
                $row['telefono']
            );
            $proveedores[] = $proveedor;
        }

        return $proveedores;
    }

    // Agregar un nuevo proveedor
    public function add(Proveedor $proveedor){
        $query = "INSERT INTO proveedores (nombre, direccion, telefono) VALUES (:nombre, :direccion, :telefono)";
        $stmt = $this->conn->prepare($query);

        // Bind de parámetros
        $stmt->bindParam(':nombre', $proveedor->getNombre());
        $stmt->bindParam(':direccion', $proveedor->getDireccion());
        $stmt->bindParam(':telefono', $proveedor->getTelefono());

        if($stmt->execute()){
            return true;
        }

        return false;
    }
}
?>
