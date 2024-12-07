import javax.swing.*;

public class Aab_MainFrame {
    public static void main(String[] args){
        JFrame frame = new JFrame("Mi ventana con JLabel");
        frame.setSize(400,300);
        JLabel label = new JLabel("¡Hola, este es un JLabel!", SwingConstants.CENTER);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}