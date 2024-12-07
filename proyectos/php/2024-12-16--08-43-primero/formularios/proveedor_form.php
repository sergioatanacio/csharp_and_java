<?php
// formularios/proveedor_form.php
require_once '../dao/ProveedorDAO.php';

$proveedorDAO = new ProveedorDAO();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $nombre = $_POST['nombre'] ?? '';
    $direccion = $_POST['direccion'] ?? '';
    $telefono = $_POST['telefono'] ?? '';

    $proveedor = new Proveedor(null, $nombre, $direccion, $telefono);

    if ($proveedorDAO->add($proveedor)) {
        echo "Proveedor agregado exitosamente.";
    } else {
        echo "Error al agregar el proveedor.";
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Formulario de Proveedores</title>
</head>
<body>
    <h2>Agregar Proveedor</h2>
    <form method="POST" action="">
        <label for="nombre">Nombre:</label><br>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="direccion">Dirección:</label><br>
        <input type="text" id="direccion" name="direccion"><br><br>

        <label for="telefono">Teléfono:</label><br>
        <input type="text" id="telefono" name="telefono"><br><br>

        <input type="submit" value="Agregar Proveedor">
    </form>
</body>
</html>
