package Presentacion;

import Entidad.Role;
import Entidad.User;
import Datos.RoleDAO;
import Datos.UserDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class UserForm extends JFrame implements ActionListener {
    // Componentes de la interfaz
    private JLabel lId, lName, lEmail, lCountry, lRole;
    private JTextField tfId, tfName, tfEmail, tfCountry;
    private JComboBox<Role> cbRoles;
    private JButton btnSave, btnUpdate, btnDelete, btnView;
    private JTable table;
    private JScrollPane scrollPane;
    private JPopupMenu popupMenu;
    private JMenuItem editMenuItem;

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
        tfId.setEditable(false); // El ID no debe ser editable por el usuario

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

        lRole = new JLabel("Rol:");
        lRole.setBounds(20, 220, 100, 30);
        cbRoles = new JComboBox<>();
        cbRoles.setBounds(130, 220, 200, 30);

        // Cargar roles en el JComboBox
        loadRoles();

        btnSave = new JButton("Guardar");
        btnSave.setBounds(20, 270, 100, 30);
        btnSave.addActionListener(this);

        btnUpdate = new JButton("Actualizar");
        btnUpdate.setBounds(130, 270, 100, 30);
        btnUpdate.addActionListener(this);

        btnDelete = new JButton("Eliminar");
        btnDelete.setBounds(240, 270, 100, 30);
        btnDelete.addActionListener(this);

        btnView = new JButton("Ver Todos");
        btnView.setBounds(350, 270, 100, 30);
        btnView.addActionListener(this);

        // Tabla para mostrar los datos
        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 320, 740, 230);

        // Configurar el modelo de la tabla
        String[] columnNames = { "ID", "Nombre", "Email", "País", "Rol" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            // Hacer que las celdas no sean editables directamente
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Selección simple

        // Crear el menú contextual
        popupMenu = new JPopupMenu();
        editMenuItem = new JMenuItem("Editar");
        popupMenu.add(editMenuItem);

        // Añadir ActionListener al menú de editar
        editMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSelectedRowData();
            }
        });

        // Agregar un MouseListener para mostrar el menú contextual
        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) { // Verificar si es el disparador del popup
                    int row = table.rowAtPoint(e.getPoint());
                    if (row >= 0 && row < table.getRowCount()) {
                        table.setRowSelectionInterval(row, row);
                        popupMenu.show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });

        // Agregar componentes a la ventana
        add(lId); add(tfId);
        add(lName); add(tfName);
        add(lEmail); add(tfEmail);
        add(lCountry); add(tfCountry);
        add(lRole); add(cbRoles);
        add(btnSave); add(btnUpdate); add(btnDelete); add(btnView);
        add(scrollPane);

        // Configuración final de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);

        // Cargar los datos al iniciar la aplicación
        loadTableData();
    }

    // Método para limpiar los campos de texto
    private void clearFields() {
        tfId.setText("");
        tfName.setText("");
        tfEmail.setText("");
        tfCountry.setText("");
        cbRoles.setSelectedIndex(-1); // Deseleccionar el JComboBox
    }

    // Método para cargar los roles en el JComboBox
    private void loadRoles() {
        List<Role> roles = new RoleDAO().getAllRoles();
        cbRoles.removeAllItems(); // Limpiar antes de cargar
        for (Role role : roles) {
            cbRoles.addItem(role);
        }
        cbRoles.setSelectedIndex(-1); // Deseleccionar por defecto
    }

    // Método para cargar los datos en la tabla
    private void loadTableData() {
        List<User> list = new UserDAO().getAllUsers();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar

        for (User user : list) {
            Object[] rowData = {
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCountry(),
                user.getRoleName() // Agregar el nombre del rol
            };
            model.addRow(rowData);
        }

        System.out.println("Datos cargados en la tabla. Total usuarios: " + list.size());
    }

    // Método para cargar los datos de la fila seleccionada en el formulario
    private void loadSelectedRowData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            try {
                // Obtener los datos de la fila seleccionada
                String id = table.getValueAt(selectedRow, 0).toString();
                String name = table.getValueAt(selectedRow, 1).toString();
                String email = table.getValueAt(selectedRow, 2).toString();
                String country = table.getValueAt(selectedRow, 3).toString();
                String roleName = table.getValueAt(selectedRow, 4).toString();

                // Cargar los datos en los campos de texto
                tfId.setText(id);
                tfName.setText(name);
                tfEmail.setText(email);
                tfCountry.setText(country);

                // Seleccionar el rol en el JComboBox
                for (int i = 0; i < cbRoles.getItemCount(); i++) {
                    if (cbRoles.getItemAt(i).getRoleName().equals(roleName)) {
                        cbRoles.setSelectedIndex(i);
                        break;
                    }
                }

                System.out.println("Fila seleccionada: ID=" + id + ", Nombre=" + name);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al cargar los datos de la fila.");
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay ninguna fila seleccionada.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción para el botón 'Guardar'
        if (e.getSource() == btnSave) {
            String name = tfName.getText().trim();
            String email = tfEmail.getText().trim();
            String country = tfCountry.getText().trim();
            Role selectedRole = (Role) cbRoles.getSelectedItem();

            if (name.isEmpty() || email.isEmpty() || country.isEmpty() || selectedRole == null) {
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos y selecciona un rol.");
            } else {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setCountry(country);
                user.setRoleId(selectedRole.getRoleId());

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
            String idText = tfId.getText().trim();
            String name = tfName.getText().trim();
            String email = tfEmail.getText().trim();
            String country = tfCountry.getText().trim();
            Role selectedRole = (Role) cbRoles.getSelectedItem();

            if (idText.isEmpty() || name.isEmpty() || email.isEmpty() || country.isEmpty() || selectedRole == null) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario de la tabla y completa todos los campos.");
            } else {
                try {
                    int id = Integer.parseInt(idText);
                    User user = new User();
                    user.setId(id);
                    user.setName(name);
                    user.setEmail(email);
                    user.setCountry(country);
                    user.setRoleId(selectedRole.getRoleId());

                    int status = new UserDAO().updateUser(user);
                    if (status > 0) {
                        JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente.");
                        clearFields();
                        loadTableData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al actualizar el usuario.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.");
                }
            }
        }

        // Acción para el botón 'Eliminar'
        if (e.getSource() == btnDelete) {
            String idText = tfId.getText().trim();

            if (idText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un usuario de la tabla para eliminar.");
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este usuario?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        int id = Integer.parseInt(idText);
                        int status = new UserDAO().deleteUser(id);
                        if (status > 0) {
                            JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente.");
                            clearFields();
                            loadTableData();
                        } else {
                            JOptionPane.showMessageDialog(this, "Error al eliminar el usuario.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.");
                    }
                }
            }
        }

        // Acción para el botón 'Ver Todos'
        if (e.getSource() == btnView) {
            loadTableData();
        }
    }

    public static void main(String[] args) {
        // Establecer el Look and Feel al de la plataforma para mejor apariencia
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        new UserForm();
    }
}
