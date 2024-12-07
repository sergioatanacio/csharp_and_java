import presentacion.TodoListGUI;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TodoListGUI gui = new TodoListGUI();
            gui.setVisible(true);
        });
    }
}
