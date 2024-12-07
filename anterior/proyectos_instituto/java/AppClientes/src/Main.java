import CapaPresentacion.FormLogin;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormLogin gui = new FormLogin();
            gui.setVisible(true);
        });
    }
}
