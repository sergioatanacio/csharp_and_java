/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Paneles;

import CapaEntidad.EntidadCategoria;
import CapaEntidad.EntidadUsuario;
import CapaNegocio.NegocioCategoria;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author ANGEL
 */
public class FrmCategoria extends javax.swing.JFrame implements PanelCrud {

    DefaultTableModel dtm = new DefaultTableModel();
    NegocioCategoria var_negocioCategoria;
    EntidadUsuario prop_usuario;
    
    private TableRowSorter<DefaultTableModel> sorter;

    /**
     * Creates new form Crud
     * @param usuario_login
     */
    public FrmCategoria(EntidadUsuario usuario_login) {
        initComponents();
        this.prop_usuario = usuario_login;
        this.setLocationRelativeTo(null);
        this.var_negocioCategoria = new NegocioCategoria(this.prop_usuario); // O pasar 'prop_usuario' si es necesario

        String[] titulo = new String[]{"Id", "Nombre", "Descripción", "Estado", "Fecha Registro"};
        dtm.setColumnIdentifiers(titulo);
        tbldatos.setModel(dtm); 

        sorter = new TableRowSorter<>(dtm);                                                                   
        tbldatos.setRowSorter(sorter);

        txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrar(txtBuscar.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrar(txtBuscar.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrar(txtBuscar.getText());
            }
        });

        cargarDatos(); // Ahora 'dao' está inicializado
    }

    
    @Override
    public void filtrar(String texto) {
        if (texto.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto, 1, 2)); // Filtrar por columnas "Nombre" y "Apellido"
        }
    }

    @Override
    public void cargarDatos(){
        limpiartabla();
        List<EntidadCategoria> lista = var_negocioCategoria.listar(this.prop_usuario);
        for (EntidadCategoria p : lista) {
            dtm.addRow(new Object[]{p.getId(), p.getNombre(), p.getDescripcion(), p.isEstado(), p.getFechaRegistro()});
        }
    }

    
    @Override
    public void agregar(){
        String nombre = txtnombre.getText().trim();
        String descripcion = txtdescripcion.getText().trim();
        boolean estado = cboestado.isSelected();

        if(nombre.isEmpty() || descripcion.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        EntidadCategoria p = new EntidadCategoria();
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setEstado(estado);
      

        
        
        if(var_negocioCategoria.insertar(p)){
            cargarDatos();
            limpiarCampos();
            javax.swing.JOptionPane.showMessageDialog(this, "Registro agregado exitosamente.");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al insertar en la base de datos.");
        }
    }


    
    
    
    

    
    @Override
    public void eliminar(){
        int fila = tbldatos.getSelectedRow();
        if (fila >= 0) {
            int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este registro?", "Confirmar Eliminación", javax.swing.JOptionPane.YES_NO_OPTION);
            if(confirm == javax.swing.JOptionPane.YES_OPTION){
                int id = Integer.parseInt(tbldatos.getValueAt(fila, 0).toString());
                EntidadCategoria entidadCat = new EntidadCategoria();
                entidadCat.setId(id);
                if(var_negocioCategoria.eliminar(entidadCat)){
                    cargarDatos();
                    limpiarCampos();
                    javax.swing.JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente.");
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error al eliminar el registro.");
                }
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.");
        }
    }
    
    
    @Override
    public void actualizar(){
        int fila = tbldatos.getSelectedRow();
        if (fila >= 0) {
            // Obtener el valor de la columna "id" de la fila seleccionada
            int columnaId = tbldatos.getColumnModel().getColumnIndex("Id"); // Busca el índice de la columna "id"
            Object valorId = tbldatos.getValueAt(fila, columnaId); // Obtiene el valor de la celda

            String nombre = txtnombre.getText().trim();
            String descripcion = txtdescripcion.getText().trim();
            boolean estado = cboestado.isSelected();

            if(nombre.isEmpty() || descripcion.isEmpty()){
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
                return;
            }

            int id = Integer.parseInt(valorId.toString()); // Convertir el valor de la columna "id" a entero

            EntidadCategoria p = new EntidadCategoria();
            p.setId(id);
            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setEstado(estado);
            p.setFechaRegistro(var_negocioCategoria.buscarPorId(id).getFechaRegistro());

            if(var_negocioCategoria.actualizar(p)){
                cargarDatos();
                limpiarCampos();
                javax.swing.JOptionPane.showMessageDialog(this, "Registro actualizado exitosamente.");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar el registro.");
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para actualizar.");
        } 
    }
    
    @Override
    public void limpiartabla(){
        int filas = dtm.getRowCount();
        for(int i= 0; i<filas; i++){
            dtm.removeRow(0);
        }
    }
  
    @Override
    public void limpiarCampos(){
        txtid.setText("");
        txtnombre.setText("");
        txtdescripcion.setText("");
        txtBuscar.setText(""); // Limpiar el campo de búsqueda
        cboestado.setSelected(false); // Restablecer el checkbox de estado
        tbldatos.clearSelection();
        txtfecha.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldatos = new javax.swing.JTable();
        btnagregar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboestado = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        btnCargar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Id:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Descripción:");

        txtid.setEditable(false);

        tbldatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbldatos.setName(""); // NOI18N
        tbldatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldatos);

        btnagregar.setText("Añadir");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnlimpiar.setText("LimpiarT");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado");

        cboestado.setText("Estado");

        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jLabel4.setText("Buscar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addComponent(btnCargar, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(txtBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtfecha.setEditable(false);

        jLabel6.setText("Fecha:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Categoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(cboestado)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(39, 39, 39)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(173, 173, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboestado))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar)
                    .addComponent(btneliminar)
                    .addComponent(btnactualizar)
                    .addComponent(btnlimpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        agregar();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiartabla();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btnCargarActionPerformed

    private void tbldatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldatosMouseClicked
        int fila = tbldatos.getSelectedRow();
        if(fila >= 0){
            txtid.setText(tbldatos.getValueAt(fila, 0).toString());
            txtnombre.setText(tbldatos.getValueAt(fila, 1).toString());
            txtdescripcion.setText(tbldatos.getValueAt(fila, 2).toString());
//            cboestado.setText(tbldatos.getValueAt(fila, 2).toString());
            String estado = tbldatos.getValueAt(fila, 3).toString();
                cboestado.setSelected(Boolean.parseBoolean(estado));
            txtfecha.setText(tbldatos.getValueAt(fila, 4).toString());
        }
    }//GEN-LAST:event_tbldatosMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmCategoria().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JCheckBox cboestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
