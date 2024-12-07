package CapaPresentacion;

import javax.swing.JOptionPane;

/**
 * Formulario de prueba que se cierra a sí mismo al presionar el botón "Ingresar".
 */
public class FormLoginPrueba extends javax.swing.JFrame {

    /**
     * Crea un nuevo formulario de prueba.
     */
    public FormLoginPrueba() {
        initComponents();
        // Opcional: puedes establecer valores predeterminados para los campos
        txt_usuario.setText("usuario_prueba@example.com");
        txt_password.setText("password123");
    }

    /**
     * Método generado por el Form Editor para inicializar los componentes.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_usuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_ingresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulario de Prueba");

        jLabel1.setText("Usuario");

        jLabel2.setText("Password");

        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });

        jLabel3.setText("Abarrotes Hogar - Prueba");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txt_usuario)
                    .addComponent(btn_ingresar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txt_password))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 25, Short.MAX_VALUE)
                .addComponent(btn_ingresar)
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null); // Centra el formulario en la pantalla
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        // Obtener los textos de los campos de texto
        String usuario = txt_usuario.getText();
        String password = new String(txt_password.getPassword());

        // Opcional: Puedes mostrar los valores ingresados para verificar
        // JOptionPane.showMessageDialog(this, "Usuario: " + usuario + "\nPassword: " + password, "Información", JOptionPane.INFORMATION_MESSAGE);

        // Cerrar el formulario
        this.dispose();

        // Opcional: Mostrar un mensaje de confirmación antes de cerrar
        // JOptionPane.showMessageDialog(this, "El formulario se cerrará.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_ingresarActionPerformed

    /**
     * Método principal para ejecutar el formulario de prueba.
     */
    public static void main(String args[]) {
        /* Establece el aspecto Nimbus si está disponible */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormLoginPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLoginPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLoginPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLoginPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Crea y muestra el formulario */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLoginPrueba().setVisible(true);
            }
        });
    }

    // Variables de declaración - no modificar//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_usuario;
    // Fin de variables de declaración//GEN-END:variables
}
