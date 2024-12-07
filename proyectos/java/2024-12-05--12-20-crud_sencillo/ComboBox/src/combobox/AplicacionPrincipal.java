/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combobox;

/**
 *
 * @author ANGEL
 */


import javax.swing.*;

public class AplicacionPrincipal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame("Aplicación de Gestión");
            mainFrame.setSize(400, 200);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLayout(null);

            JButton btnProveedores = new JButton("Ver Proveedores");
            btnProveedores.setBounds(50, 50, 150, 30);
            btnProveedores.addActionListener(e -> {
                ListaProveedoresFrame proveedoresFrame = new ListaProveedoresFrame();
                proveedoresFrame.setVisible(true);
            });

            JButton btnProductos = new JButton("Ver Productos");
            btnProductos.setBounds(220, 50, 150, 30);
            btnProductos.addActionListener(e -> {
                ListaProductosFrame productosFrame = new ListaProductosFrame();
                productosFrame.setVisible(true);
            });

            mainFrame.add(btnProveedores);
            mainFrame.add(btnProductos);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
        });
    }
}
