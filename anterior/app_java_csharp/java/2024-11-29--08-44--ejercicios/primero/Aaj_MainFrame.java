import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter; // Importar TableRowSorter
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.RowFilter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame {
    public static void main(String[] args) {
        // Crear el frame principal
        JFrame frame = new JFrame("Tabla con Buscador y Llenado Dinámico");
        
        // Definir los encabezados de las columnas
        String[] columnNames = {"ID", "Nombre", "Edad"};
        
        // Crear una lista para simular datos provenientes de una base de datos
        List<Object[]> listaDatos = new ArrayList<>();
        
        // Llenar la lista con datos usando un bucle while
        // En un escenario real, estos datos vendrían de una base de datos
        int id = 1;
        String[] nombres = {"Juan", "María", "Pedro", "Ana", "Carlos", "Luis", "Sofia", "Isabel", "Martín", "Laura"};
        int[] edades = {25, 30, 22, 28, 35, 40, 27, 33, 20, 31};
        
        int index = 0;
        while (index < nombres.length) {
            Object[] fila = {id, nombres[index], edades[index]};
            listaDatos.add(fila);
            id++;
            index++;
        }
        
        // Convertir la lista a un array bidimensional para el modelo de la tabla
        Object[][] data = new Object[listaDatos.size()][3];
        int fila = 0;
        while (fila < listaDatos.size()) {
            data[fila] = listaDatos.get(fila);
            fila++;
        }
        
        // Crear un modelo de tabla con los datos y las columnas
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        
        // Crear la JTable con el modelo
        JTable table = new JTable(model);
        
        // Colocar la JTable dentro de un JScrollPane para que sea desplazable
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Crear un JTextField para el buscador
        JTextField searchField = new JTextField(20);
        JLabel searchLabel = new JLabel("Buscar:");
        
        // Agregar un DocumentListener al JTextField para actualizar la tabla cuando el texto cambie
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable(searchField.getText(), model, table);
            }
    
            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable(searchField.getText(), model, table);
            }
    
            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable(searchField.getText(), model, table);
            }
        });
        
        // Crear un panel para contener el buscador
        JPanel searchPanel = new JPanel();
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        
        // Agregar el panel de búsqueda y la tabla al frame
        frame.setLayout(new BorderLayout());
        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        // Configurar el comportamiento de cierre del frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Configurar el tamaño del frame
        frame.setSize(600, 400);
        
        // Hacer visible la ventana
        frame.setVisible(true);
    }
    
    // Función para filtrar los datos de la tabla según el texto del buscador
    private static void filterTable(String query, DefaultTableModel model, JTable table) {
        // Filtrar filas según el texto ingresado en el buscador
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query)); // Filtra sin distinción de mayúsculas y minúsculas
    }
}
