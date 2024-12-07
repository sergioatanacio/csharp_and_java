/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combobox;

/**
 *
 * @author ANGEL
 */


import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class ListaProductosFrame extends JFrame {
    private JTable tablaProductos;
    private ProductoDAO productoDAO;

    public ListaProductosFrame() {
        productoDAO = new ProductoDAO();
        initComponents();
        cargarProductos();
    }

    private void initComponents() {
        setTitle("Lista de Productos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tablaProductos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        add(scrollPane);

        // Configurar el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Proveedor");
        tablaProductos.setModel(modelo);
    }

    private void cargarProductos() {
        try {
            List<Producto> productos = productoDAO.obtenerTodosProductos();
            DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
            modelo.setRowCount(0); // Limpiar la tabla

            for (Producto p : productos) {
                Object[] fila = new Object[6];
                fila[0] = p.getIdProducto();
                fila[1] = p.getNombre();
                fila[2] = p.getDescripcion();
                fila[3] = p.getPrecio();
                fila[4] = p.getStock();
                fila[5] = p.getProveedor() != null ? p.getProveedor().getNombre() : "N/A";
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
