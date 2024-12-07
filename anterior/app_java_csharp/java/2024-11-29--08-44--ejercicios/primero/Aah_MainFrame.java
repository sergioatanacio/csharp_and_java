import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainFrame {
    public static void main(String[] args) {
        // Crear el frame principal
        JFrame frame = new JFrame("Tabla con JTable");

        // Definir los encabezados de las columnas
        String[] columnNames = {"ID", "Nombre", "Edad"};

        // Definir los datos de la tabla (filas y columnas)
        Object[][] data = {
            {1, "Juan", 25},
            {2, "María", 30},
            {3, "Pedro", 22},
            {4, "Ana", 28}
        };

        // Crear un modelo de tabla con los datos y las columnas
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Crear la JTable con el modelo
        JTable table = new JTable(model);

        // Colocar la JTable dentro de un JScrollPane para que sea desplazable
        JScrollPane scrollPane = new JScrollPane(table);

        // Agregar el JScrollPane (que contiene la JTable) al frame
        frame.add(scrollPane);

        // Configurar el comportamiento de cierre del frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar el tamaño del frame
        frame.setSize(400, 300);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
