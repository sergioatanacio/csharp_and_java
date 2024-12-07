<?php
// formularios/producto_form.php
require_once '../dao/ProductoDAO.php';
require_once '../dao/ProveedorDAO.php';
require_once '../entidades/Proveedor.php';

$productoDAO = new ProductoDAO();
$proveedorDAO = new ProveedorDAO();
$proveedores = $proveedorDAO->getAll();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = $_POST['nombre'] ?? '';
    $descripcion = $_POST['descripcion'] ?? '';
    $precio = $_POST['precio'] ?? 0.0;
    $id_proveedor = $_POST['id_proveedor'] ?? null;

    // Obtener el proveedor seleccionado
    $proveedorSeleccionado = null;
    foreach ($proveedores as $prov) {
        if ($prov->getId() == $id_proveedor) {
            $proveedorSeleccionado = $prov;
            break;
        }
    }

    $producto = new Producto(null, $nombre, $descripcion, $precio, $proveedorSeleccionado);

    if ($productoDAO->add($producto)) {
        echo "Producto agregado exitosamente.";
    } else {
        echo "Error al agregar el producto.";
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Formulario de Productos</title>
</head>
<body>
    <h2>Agregar Producto</h2>
    <form method="POST" action="">
        <label for="nombre">Nombre:</label><br>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="descripcion">Descripción:</label><br>
        <textarea id="descripcion" name="descripcion"></textarea><br><br>

        <label for="precio">Precio:</label><br>
        <input type="number" step="0.01" id="precio" name="precio" required><br><br>

        <label for="id_proveedor">Proveedor:</label><br>
        <select id="id_proveedor" name="id_proveedor" required>
            <option value="">--Seleccione un Proveedor--</option>
            <?php foreach($proveedores as $proveedor): ?>
                <option value="<?php echo $proveedor->getId(); ?>">
                    <?php echo htmlspecialchars($proveedor->getNombre()); ?>
                </option>
            <?php endforeach; ?>
        </select><br><br>

        <input type="submit" value="Agregar Producto">
    </form>
</body>
</html>
