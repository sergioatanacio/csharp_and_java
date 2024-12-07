<?php
// dao/ProductoDAO.php
require_once '../config/Database.php';
require_once '../entidades/Producto.php';
require_once '../entidades/Proveedor.php';

class ProductoDAO {
    private $conn;

    public function __construct(){
        $database = new Database();
        $this->conn = $database->getConnection();
    }

    // Obtener todos los productos
    public function getAll(){
        $query = "SELECT p.*, pr.nombre as proveedor_nombre FROM productos p
                  LEFT JOIN proveedores pr ON p.id_proveedor = pr.id_proveedor";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();

        $productos = [];

        while ($row = $stmt->fetch(PDO::FETCH_ASSOC)){
            $proveedor = new Proveedor(
                $row['id_proveedor'],
                $row['proveedor_nombre']
            );

            $producto = new Producto(
                $row['id_producto'],
                $row['nombre'],
                $row['descripcion'],
                $row['precio'],
                $proveedor
            );
            $productos[] = $producto;
        }

        return $productos;
    }

    // Agregar un nuevo producto
    public function add(Producto $producto){
        $query = "INSERT INTO productos (nombre, descripcion, precio, id_proveedor) 
                  VALUES (:nombre, :descripcion, :precio, :id_proveedor)";
        $stmt = $this->conn->prepare($query);

        // Bind de parámetros
        $stmt->bindParam(':nombre', $producto->getNombre());
        $stmt->bindParam(':descripcion', $producto->getDescripcion());
        $stmt->bindParam(':precio', $producto->getPrecio());
        $stmt->bindParam(':id_proveedor', $producto->getProveedor()->getId());

        if($stmt->execute()){
            return true;
        }

        return false;
    }
}
?>
