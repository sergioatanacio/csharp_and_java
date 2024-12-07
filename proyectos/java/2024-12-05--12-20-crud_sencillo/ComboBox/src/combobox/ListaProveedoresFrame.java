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

public class ListaProveedoresFrame extends JFrame {
    private JTable tablaProveedores;
    private ProveedorDAO proveedorDAO;

    public ListaProveedoresFrame() {
        proveedorDAO = new ProveedorDAO();
        initComponents();
        cargarProveedores();
    }

    private void initComponents() {
        setTitle("Lista de Proveedores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tablaProveedores = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaProveedores);
        add(scrollPane);

        // Configurar el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Email");
        modelo.addColumn("Dirección");
        tablaProveedores.setModel(modelo);
    }

    private void cargarProveedores() {
        try {
            List<Proveedor> proveedores = proveedorDAO.obtenerTodosProveedores();
            DefaultTableModel modelo = (DefaultTableModel) tablaProveedores.getModel();
            modelo.setRowCount(0); // Limpiar la tabla

            for (Proveedor p : proveedores) {
                Object[] fila = new Object[5];
                fila[0] = p.getIdProveedor();
                fila[1] = p.getNombre();
                fila[2] = p.getTelefono();
                fila[3] = p.getEmail();
                fila[4] = p.getDireccion();
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar proveedores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
