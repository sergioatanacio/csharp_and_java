package CapaNegocio;

import javax.swing.JOptionPane;

public class NegocioAlerta {

    /**
     * Método para mostrar una alerta con un mensaje personalizado.
     * @param mensaje El mensaje a mostrar en la alerta.
     */
    public static void mostrar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Alerta", JOptionPane.INFORMATION_MESSAGE);
    }
}
