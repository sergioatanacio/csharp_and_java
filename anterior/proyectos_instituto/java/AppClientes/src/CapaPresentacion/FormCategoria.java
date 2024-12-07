package CapaPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una categoría.
 */
class Categoria {
    private String idCategoria;
    private String nombre;
    private boolean estado;
    private String descripcion;

    public Categoria(String idCategoria, String nombre, boolean estado, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

/**
 * Formulario principal para la gestión de categorías.
 * Agrupa botones, tabla, buscador y campos de inserción en paneles separados con bordes.
 * 
 * @autor Usuario
 */
public class FormCategoria extends JFrame {

    // Paneles principales
    private JPanel panelBusqueda;
    private JPanel panelInputs;
    private JPanel panelBotones;
    private JPanel panelTabla;

    // Componentes de Buscador
    private JLabel lblBuscar;
    private JTextField txtBuscar;

    // Componentes de Inserción
    private JLabel lblIdCategoria;
    private JTextField txtIdCategoria;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblEstado;
    private JCheckBox chkEstado;
    private JLabel lblDescripcion;
    private JTextArea txtDescripcion;

    // Componentes de Botones
    private JButton btnCrear;
    private JButton btnModificar;
    private JButton btnNuevo;
    private JButton btnEliminar;

    // Componentes de Tabla
    private JTable tblCategorias;
    private JScrollPane scrollTabla;

    // Modelo de la tabla
    private DefaultTableModel modeloTabla;

    // Lista de categorías
    private List<Categoria> listaCategorias;

    /**
     * Constructor del formulario.
     */
    public FormCategoria() {
        initComponents();
        inicializarListaCategorias();
        llenarTabla("");
    }

    /**
     * Inicializa y configura los componentes del formulario.
     */
    private void initComponents() {
        // Configuración del JFrame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Categorías");
        setSize(1000, 700);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout(10, 10));

        // ========================================
        // Configuración del Panel de Buscador
        // ========================================
        panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelBusqueda.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Buscar",
                TitledBorder.LEFT, TitledBorder.TOP));

        lblBuscar = new JLabel("Buscar por Nombre:");
        txtBuscar = new JTextField(20);
        // Agregar DocumentListener para actualizar la tabla al escribir
        txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTabla();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTabla();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarTabla();
            }
        });

        panelBusqueda.add(lblBuscar);
        panelBusqueda.add(txtBuscar);

        // ========================================
        // Configuración del Panel de Inserción
        // ========================================
        panelInputs = new JPanel();
        panelInputs.setLayout(new GridBagLayout());
        panelInputs.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Insertar/Editar Categoría",
                TitledBorder.LEFT, TitledBorder.TOP));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // ID Categoría
        gbc.gridx = 0;
        gbc.gridy = 0;
        lblIdCategoria = new JLabel("ID Categoría:");
        panelInputs.add(lblIdCategoria, gbc);

        gbc.gridx = 1;
        txtIdCategoria = new JTextField(15);
        panelInputs.add(txtIdCategoria, gbc);

        // Nombre
        gbc.gridx = 0;
        gbc.gridy = 1;
        lblNombre = new JLabel("Nombre:");
        panelInputs.add(lblNombre, gbc);

        gbc.gridx = 1;
        txtNombre = new JTextField(15);
        panelInputs.add(txtNombre, gbc);

        // Estado
        gbc.gridx = 0;
        gbc.gridy = 2;
        lblEstado = new JLabel("Estado:");
        panelInputs.add(lblEstado, gbc);

        gbc.gridx = 1;
        chkEstado = new JCheckBox("Activo", true);
        panelInputs.add(chkEstado, gbc);

        // Descripción
        gbc.gridx = 0;
        gbc.gridy = 3;
        lblDescripcion = new JLabel("Descripción:");
        panelInputs.add(lblDescripcion, gbc);

        gbc.gridx = 1;
        txtDescripcion = new JTextArea(4, 15);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion);
        panelInputs.add(scrollDescripcion, gbc);

        // ========================================
        // Configuración del Panel de Botones
        // ========================================
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Acciones",
                TitledBorder.LEFT, TitledBorder.TOP));

        btnCrear = new JButton("Crear");
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCategoria.this.btnCrear_click();
            }
        });

        btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCategoria.this.btnModificar_click();
            }
        });

        btnNuevo = new JButton("Nuevo");
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCategoria.this.btnNuevo_click();
            }
        });

        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormCategoria.this.btnEliminar_click();
            }
        });

        panelBotones.add(btnCrear);
        panelBotones.add(btnModificar);
        panelBotones.add(btnNuevo);
        panelBotones.add(btnEliminar);

        // ========================================
        // Configuración del Panel de Tabla
        // ========================================
        panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Lista de Categorías",
                TitledBorder.LEFT, TitledBorder.TOP));

        tblCategorias = new JTable();
        modeloTabla = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID Categoría", "Nombre", "Estado", "Descripción"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que las celdas no sean editables
            }
        };
        tblCategorias.setModel(modeloTabla);
        scrollTabla = new JScrollPane(tblCategorias);
        panelTabla.add(scrollTabla, BorderLayout.CENTER);

        // ========================================
        // Organización de los Paneles
        // ========================================
        // Panel Izquierdo (Buscador y Inputs)
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BorderLayout(10, 10));
        panelIzquierdo.add(panelBusqueda, BorderLayout.NORTH);
        panelIzquierdo.add(panelInputs, BorderLayout.CENTER);

        // Panel Principal (Izquierdo y Botones)
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.add(panelIzquierdo, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.EAST);

        // Añadir al JFrame
        add(panelPrincipal, BorderLayout.NORTH);
        add(panelTabla, BorderLayout.CENTER);

        // Empaquetar componentes
        pack();
    }

    /**
     * Inicializa la lista de categorías con datos simulados.
     */
    private void inicializarListaCategorias() {
        listaCategorias = new ArrayList<>();
        listaCategorias.add(new Categoria("C001", "Electrónica", true, "Dispositivos electrónicos y gadgets."));
        listaCategorias.add(new Categoria("C002", "Ropa", true, "Ropa para todas las edades."));
        listaCategorias.add(new Categoria("C003", "Hogar", false, "Artículos para el hogar."));
        listaCategorias.add(new Categoria("C004", "Deportes", true, "Equipamiento deportivo."));
        listaCategorias.add(new Categoria("C005", "Libros", true, "Libros de diversas categorías."));
        // Puedes agregar más categorías según sea necesario
    }

    /**
     * Llena la tabla con la lista de categorías, aplicando un filtro de búsqueda.
     * @param filtro Texto de búsqueda para filtrar las categorías por nombre.
     */
    private void llenarTabla(String filtro) {
        // Limpiar la tabla
        modeloTabla.setRowCount(0);

        // Filtrar y agregar filas a la tabla
        for (Categoria cat : listaCategorias) {
            if (cat.getNombre().toLowerCase().contains(filtro.toLowerCase())) {
                String estadoStr = cat.isEstado() ? "Activo" : "Inactivo";
                modeloTabla.addRow(new Object[]{
                        cat.getIdCategoria(),
                        cat.getNombre(),
                        estadoStr,
                        cat.getDescripcion()
                });
            }
        }
    }

    /**
     * Actualiza la tabla según el texto de búsqueda.
     */
    private void actualizarTabla() {
        String textoBusqueda = txtBuscar.getText();
        llenarTabla(textoBusqueda);
    }

    /**
     * Acción al hacer clic en el botón Crear.
     */
    public void btnCrear_click(){
        // Obtener datos de los campos de inserción
        String id = txtIdCategoria.getText().trim();
        String nombre = txtNombre.getText().trim();
        boolean estado = chkEstado.isSelected();
        String descripcion = txtDescripcion.getText().trim();

        // Validar campos (simple validación)
        if(id.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                    "ID y Nombre son obligatorios.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear nueva categoría y agregar a la lista
        Categoria nuevaCategoria = new Categoria(id, nombre, estado, descripcion);
        listaCategorias.add(nuevaCategoria);

        // Actualizar tabla
        actualizarTabla();

        // Limpiar campos de inserción
        limpiarCampos();
    }

    /**
     * Acción al hacer clic en el botón Modificar.
     */
    public void btnModificar_click(){
        int filaSeleccionada = tblCategorias.getSelectedRow();
        if(filaSeleccionada == -1){
            JOptionPane.showMessageDialog(this, 
                    "Seleccione una categoría para modificar.", 
                    "Información", 
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Obtener ID de la categoría seleccionada
        String idSeleccionado = (String) modeloTabla.getValueAt(filaSeleccionada, 0);

        // Buscar la categoría en la lista
        Categoria categoriaModificar = null;
        for(Categoria cat : listaCategorias){
            if(cat.getIdCategoria().equals(idSeleccionado)){
                categoriaModificar = cat;
                break;
            }
        }

        if(categoriaModificar != null){
            // Obtener nuevos valores de los campos de inserción
            String nuevoNombre = txtNombre.getText().trim();
            boolean nuevoEstado = chkEstado.isSelected();
            String nuevaDescripcion = txtDescripcion.getText().trim();

            if(nuevoNombre.isEmpty()){
                JOptionPane.showMessageDialog(this, 
                        "El Nombre es obligatorio.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Actualizar los valores de la categoría
            categoriaModificar = new Categoria(
                    categoriaModificar.getIdCategoria(),
                    nuevoNombre,
                    nuevoEstado,
                    nuevaDescripcion
            );

            // Reemplazar la categoría en la lista
            for(int i = 0; i < listaCategorias.size(); i++){
                if(listaCategorias.get(i).getIdCategoria().equals(idSeleccionado)){
                    listaCategorias.set(i, categoriaModificar);
                    break;
                }
            }

            // Actualizar tabla
            actualizarTabla();

            // Limpiar campos de inserción
            limpiarCampos();
        }
    }

    /**
     * Acción al hacer clic en el botón Nuevo.
     */
    public void btnNuevo_click(){
        limpiarCampos();
    }

    /**
     * Acción al hacer clic en el botón Eliminar.
     */
    public void btnEliminar_click(){
        int filaSeleccionada = tblCategorias.getSelectedRow();
        if(filaSeleccionada == -1){
            JOptionPane.showMessageDialog(this, 
                    "Seleccione una categoría para eliminar.", 
                    "Información", 
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Confirmar eliminación
        int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de eliminar la categoría seleccionada?", 
                "Confirmar Eliminación", 
                JOptionPane.YES_NO_OPTION);

        if(confirm == JOptionPane.YES_OPTION){
            // Obtener ID de la categoría seleccionada
            String idSeleccionado = (String) modeloTabla.getValueAt(filaSeleccionada, 0);

            // Remover la categoría de la lista
            listaCategorias.removeIf(cat -> cat.getIdCategoria().equals(idSeleccionado));

            // Actualizar tabla
            actualizarTabla();

            // Limpiar campos de inserción
            limpiarCampos();
        }
    }

    /**
     * Limpia los campos de inserción.
     */
    private void limpiarCampos(){
        txtIdCategoria.setText("");
        txtNombre.setText("");
        chkEstado.setSelected(true);
        txtDescripcion.setText("");
    }

    /**
     * Método principal para ejecutar el formulario.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Establecer el look and feel de Nimbus si está disponible
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Si Nimbus no está disponible, se usará el look and feel predeterminado
            ex.printStackTrace();
        }

        // Crear y mostrar el formulario
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormCategoria().setVisible(true);
            }
        });
    }
}
