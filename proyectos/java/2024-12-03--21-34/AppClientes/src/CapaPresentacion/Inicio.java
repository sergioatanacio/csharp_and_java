/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CapaPresentacion;

import CapaEntidad.EntidadUsuario;
import CapaNegocio.NegocioCategoria;
import Paneles.FrmCategoria;
import Paneles.FrmCategoria;
import Paneles.FrmIngresarProducto;
import Paneles.FrmProveedor;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;

public class Inicio extends javax.swing.JFrame {

    private EntidadUsuario usuario;
    
    public Inicio() {
        this(null);
    }

    public Inicio(EntidadUsuario usuario_login) {
        if (usuario_login == null) {
            SwingUtilities.invokeLater(() -> {
                Login formulario = new Login();
                formulario.setVisible(true);
                this.dispose();
            });
        } else {
            this.usuario = usuario_login;
            initComponents();
            this.setLocationRelativeTo(null);
            lbl_nombreusuario.setText(usuario.getNombre() + " " + usuario.getApellidoP()  );
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        content = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_nombreusuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        m_cerrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        m_categoriaproducto = new javax.swing.JMenuItem();
        m_proveedor = new javax.swing.JMenuItem();
        m_ingresarproductos = new javax.swing.JMenuItem();
        m_ingresarclientes = new javax.swing.JMenuItem();
        m_ventas = new javax.swing.JMenuItem();
        m_agendarmensajes = new javax.swing.JMenuItem();
        m_generarcomprobante = new javax.swing.JMenuItem();
        m_gestiondeinventario = new javax.swing.JMenuItem();
        m_agregarusuarios = new javax.swing.JMenuItem();
        m_verusuarios = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        content.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jLabel1.setText("Hola:");

        lbl_nombreusuario.setText("Usuario");

        jMenu1.setText("Archivo");

        m_cerrar.setText("Cerrar");
        m_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_cerrarActionPerformed(evt);
            }
        });
        jMenu1.add(m_cerrar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ventanas");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        m_categoriaproducto.setText("Categoría Producto");
        m_categoriaproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_categoriaproductoActionPerformed(evt);
            }
        });
        jMenu2.add(m_categoriaproducto);

        m_proveedor.setText("Proveedor");
        m_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_proveedorActionPerformed(evt);
            }
        });
        jMenu2.add(m_proveedor);

        m_ingresarproductos.setText("Ingresar Productos");
        m_ingresarproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_ingresarproductosActionPerformed(evt);
            }
        });
        jMenu2.add(m_ingresarproductos);

        m_ingresarclientes.setText("Ingresar Clientes");
        jMenu2.add(m_ingresarclientes);

        m_ventas.setText("Ventas");
        jMenu2.add(m_ventas);

        m_agendarmensajes.setText("Agendar Mensajes");
        jMenu2.add(m_agendarmensajes);

        m_generarcomprobante.setText("Generar Comprobante");
        jMenu2.add(m_generarcomprobante);

        m_gestiondeinventario.setText("Gestión de Inventario");
        jMenu2.add(m_gestiondeinventario);

        m_agregarusuarios.setText("Agregar Usuarios");
        jMenu2.add(m_agregarusuarios);

        m_verusuarios.setText("Ver Usuarios");
        jMenu2.add(m_verusuarios);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbl_nombreusuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_nombreusuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_ingresarproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_ingresarproductosActionPerformed
        FrmIngresarProducto formulario = new FrmIngresarProducto(this.usuario);
        formulario.setVisible(true);
    }//GEN-LAST:event_m_ingresarproductosActionPerformed

    private void m_categoriaproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_categoriaproductoActionPerformed
        FrmCategoria formulario = new FrmCategoria(this.usuario);
        formulario.setVisible(true);

    }//GEN-LAST:event_m_categoriaproductoActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void m_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_cerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_m_cerrarActionPerformed

    private void m_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_proveedorActionPerformed
        FrmProveedor formulario = new FrmProveedor(this.usuario);
        formulario.setVisible(true);
    }//GEN-LAST:event_m_proveedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JLabel lbl_nombreusuario;
    private javax.swing.JMenuItem m_agendarmensajes;
    private javax.swing.JMenuItem m_agregarusuarios;
    private javax.swing.JMenuItem m_categoriaproducto;
    private javax.swing.JMenuItem m_cerrar;
    private javax.swing.JMenuItem m_generarcomprobante;
    private javax.swing.JMenuItem m_gestiondeinventario;
    private javax.swing.JMenuItem m_ingresarclientes;
    private javax.swing.JMenuItem m_ingresarproductos;
    private javax.swing.JMenuItem m_proveedor;
    private javax.swing.JMenuItem m_ventas;
    private javax.swing.JMenuItem m_verusuarios;
    // End of variables declaration//GEN-END:variables
}
