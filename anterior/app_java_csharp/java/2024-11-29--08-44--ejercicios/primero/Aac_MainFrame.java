import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aac_MainFrame{
    public static void main(String[] args){
        JFrame frame = new JFrame("Ventana con JButton");
        frame.setSize(400,300);
        JLabel label = new JLabel("Haz click en este boton", SwingConstants.CENTER);
        JButton button = new JButton("Haz click aquí");
        button.addActionListener(new ActionListener(){
            // @Override
            public void actionPerformed(ActionEvent e){
                label.setText("¡Botón clickeado!");
            }
        });
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(label);
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}



