import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame{
    public static void main(String[] args){
        JFrame frame = new JFrame("Ventana con JButton  y Mensaje");
        frame.setSize(400,300);
        JButton button = new JButton("Mostrar mensaje");

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, "¡Hola! Este es un mensaje.");
            }
        });
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


