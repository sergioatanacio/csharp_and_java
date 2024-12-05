import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class UserForm extends JFrame implements ActionListener {
    // Componentes de la interfaz
    JLabel lName, lEmail, lCountry, lId;
    JTextField tfName, tfEmail, tfCountry, tfId;
    JButton btnSave, btnUpdate, btnDelete, btnView;
    JTable table;
    JScrollPane scrollPane;

    public UserForm() {
        // Configuración de la ventana
        setTitle("Aplicación CRUD en Java Swing con MySQL");
        setSize(800, 600);
        setLayout(null);

        // Inicialización de componentes
        lId = new JLabel("ID:");
        lId.setBounds(20, 20, 100, 30);
        tfId = new JTextField();
        tfId.setBounds(130, 20, 200, 30);

        lName = new JLabel("Nombre:");
        lName.setBounds(20, 70, 100, 30);
        tfName = new JTextField();
        tfName.setBounds(130, 70, 200, 30);

        lEmail = new JLabel("Email:");
        lEmail.setBounds(20, 120, 100, 30);
        tfEmail = new JTextField();
        tfEmail.setBounds(130, 120, 200, 30);

        lCountry = new JLabel("País:");
        lCountry.setBounds(20, 170, 100, 30);
        tfCountry = new JTextField();
        tfCountry.setBounds(130, 170, 200, 30);

        btnSave = new JButton("Guardar");
        btnSave.setBounds(20, 220, 100, 30);
        btnSave.addActionListener(this);

        btnUpdate = new JButton("Actualizar");
        btnUpdate.setBounds(130, 220, 100, 30);
        btnUpdate.addActionListener(this);

        btnDelete = new JButton("Eliminar");
        btnDelete.setBounds(240, 220, 100, 30);
        btnDelete.addActionListener(this);

        btnView = new JButton("Ver Todos");
        btnView.setBounds(350, 220, 100, 30);
        btnView.addActionListener(this);

        // Tabla para mostrar los datos
        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 270, 740, 280);

        // Agregar componentes a la ventana
        add(lId); add(tfId);
        add(lName); add(tfName);
        add(lEmail); add(tfEmail);
        add(lCountry); add(tfCountry);
        add(btnSave); add(btnUpdate); add(btnDelete); add(btnView);
        add(scrollPane);

        // Configuración final de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Método para limpiar los campos de texto
    private void clearFields() {
        tfId.setText("");
        tfName.setText("");
        tfEmail.setText("");
        tfCountry.setText("");
    }

    // Método para cargar los datos en la tabla
    private void loadTableData() {
        List<User> list = new UserDAO().getAllUsers();
        String[] columnNames = { "ID", "Nombre", "Email", "País" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (User user : list) {
            Object[] rowData = {
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCountry()
            };
            model.addRow(rowData);
        }
        table.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción para el botón 'Guardar'
        if (e.getSource() == btnSave) {
            String name = tfName.getText();
            String email = tfEmail.getText();
            String country = tfCountry.getText();

            if (name.isEmpty() || email.isEmpty() || country.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            } else {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setCountry(country);

                int status = new UserDAO().saveUser(user);
                if (status > 0) {
                    JOptionPane.showMessageDialog(this, "Usuario guardado exitosamente.");
                    clearFields();
                    loadTableData();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar el usuario.");
                }
            }
        }

        // Acción para el botón 'Actualizar'
        if (e.getSource() == btnUpdate) {
            String idText = tfId.getText();
            String name = tfName.getText();
            String email = tfEmail.getText();
            String country = tfCountry.getText();

            if (idText.isEmpty() || name.isEmpty() || email.isEmpty() || country.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            } else {
                int id = Integer.parseInt(idText);
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                user.setCountry(country);

                int status = new UserDAO().updateUser(user);
                if (status > 0) {
                    JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente.");
                    clearFields();
                    loadTableData();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el usuario.");
                }
            }
        }

        // Acción para el botón 'Eliminar'
        if (e.getSource() == btnDelete) {
            String idText = tfId.getText();

            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa el ID del usuario a eliminar.");
            } else {
                int id = Integer.parseInt(idText);
                int status = new UserDAO().deleteUser(id);
                if (status > 0) {
                    JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente.");
                    clearFields();
                    loadTableData();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el usuario.");
                }
            }
        }

        // Acción para el botón 'Ver Todos'
        if (e.getSource() == btnView) {
            loadTableData();
        }
    }

    public static void main(String[] args) {
        new UserForm();
    }
}
