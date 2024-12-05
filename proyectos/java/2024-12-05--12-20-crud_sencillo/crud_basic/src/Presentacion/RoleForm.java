package Presentacion;

import Entidad.Role;
import Datos.RoleDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class RoleForm extends JFrame implements ActionListener {
    // Componentes de la interfaz
    private JLabel lRoleId, lRoleName;
    private JTextField tfRoleId, tfRoleName;
    private JButton btnSave, btnUpdate, btnDelete, btnView, btnClear;
    private JTable table;
    private JScrollPane scrollPane;
    private JPopupMenu popupMenu;
    private JMenuItem editMenuItem;

    public RoleForm() {
        // Configuración de la ventana
        setTitle("Gestión de Roles");
        setSize(600, 500);
        setLayout(null);

        // Inicialización de componentes
        lRoleId = new JLabel("ID:");
        lRoleId.setBounds(20, 20, 100, 30);
        tfRoleId = new JTextField();
        tfRoleId.setBounds(130, 20, 200, 30);
        tfRoleId.setEditable(false); // El ID no debe ser editable

        lRoleName = new JLabel("Nombre del Rol:");
        lRoleName.setBounds(20, 70, 100, 30);
        tfRoleName = new JTextField();
        tfRoleName.setBounds(130, 70, 200, 30);

        btnSave = new JButton("Guardar");
        btnSave.setBounds(20, 120, 100, 30);
        btnSave.addActionListener(this);

        btnUpdate = new JButton("Actualizar");
        btnUpdate.setBounds(130, 120, 100, 30);
        btnUpdate.addActionListener(this);

        btnDelete = new JButton("Eliminar");
        btnDelete.setBounds(240, 120, 100, 30);
        btnDelete.addActionListener(this);

        btnClear = new JButton("Limpiar");
        btnClear.setBounds(350, 120, 100, 30);
        btnClear.addActionListener(this);

        // Tabla para mostrar los roles
        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 170, 540, 250);

        // Configurar el modelo de la tabla
        String[] columnNames = { "ID", "Nombre del Rol" };
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
        add(lRoleId); add(tfRoleId);
        add(lRoleName); add(tfRoleName);
        add(btnSave); add(btnUpdate); add(btnDelete); add(btnClear);
        add(scrollPane);

        // Configuración final de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Solo cerrar este formulario
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);

        // Cargar los datos al iniciar la aplicación
        loadTableData();
    }

    // Método para limpiar los campos de texto
    private void clearFields() {
        tfRoleId.setText("");
        tfRoleName.setText("");
        table.clearSelection();
    }

    // Método para cargar los roles en la tabla
    private void loadTableData() {
        List<Role> list = new RoleDAO().getAllRoles();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar

        for (Role role : list) {
            Object[] rowData = {
                role.getRoleId(),
                role.getRoleName()
            };
            model.addRow(rowData);
        }

        System.out.println("Datos de roles cargados en la tabla. Total roles: " + list.size());
    }

    // Método para cargar los datos de la fila seleccionada en el formulario
    private void loadSelectedRowData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            try {
                // Obtener los datos de la fila seleccionada
                String roleId = table.getValueAt(selectedRow, 0).toString();
                String roleName = table.getValueAt(selectedRow, 1).toString();

                // Cargar los datos en los campos de texto
                tfRoleId.setText(roleId);
                tfRoleName.setText(roleName);

                System.out.println("Fila seleccionada: ID=" + roleId + ", Nombre del Rol=" + roleName);
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
            String roleName = tfRoleName.getText().trim();

            if (roleName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa el nombre del rol.");
            } else {
                Role role = new Role();
                role.setRoleName(roleName);

                int status = new RoleDAO().saveRole(role);
                if (status > 0) {
                    JOptionPane.showMessageDialog(this, "Rol guardado exitosamente.");
                    clearFields();
                    loadTableData();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar el rol.");
                }
            }
        }

        // Acción para el botón 'Actualizar'
        if (e.getSource() == btnUpdate) {
            String roleIdText = tfRoleId.getText().trim();
            String roleName = tfRoleName.getText().trim();

            if (roleIdText.isEmpty() || roleName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un rol de la tabla y completa todos los campos.");
            } else {
                try {
                    int roleId = Integer.parseInt(roleIdText);
                    Role role = new Role();
                    role.setRoleId(roleId);
                    role.setRoleName(roleName);

                    int status = new RoleDAO().updateRole(role);
                    if (status > 0) {
                        JOptionPane.showMessageDialog(this, "Rol actualizado exitosamente.");
                        clearFields();
                        loadTableData();
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al actualizar el rol.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "El ID del rol debe ser un número válido.");
                }
            }
        }

        // Acción para el botón 'Eliminar'
        if (e.getSource() == btnDelete) {
            String roleIdText = tfRoleId.getText().trim();

            if (roleIdText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un rol de la tabla para eliminar.");
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este rol?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        int roleId = Integer.parseInt(roleIdText);
                        int status = new RoleDAO().deleteRole(roleId);
                        if (status > 0) {
                            JOptionPane.showMessageDialog(this, "Rol eliminado exitosamente.");
                            clearFields();
                            loadTableData();
                        } else {
                            JOptionPane.showMessageDialog(this, "Error al eliminar el rol. Asegúrate de que no está asignado a ningún usuario.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "El ID del rol debe ser un número válido.");
                    }
                }
            }
        }

        // Acción para el botón 'Limpiar'
        if (e.getSource() == btnClear) {
            clearFields();
        }
    }

    public static void main(String[] args) {
        // Establecer el Look and Feel al de la plataforma para mejor apariencia
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        new RoleForm();
    }
}
