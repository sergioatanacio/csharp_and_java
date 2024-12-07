import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aae_MainFrame{
    public static void main(String[] args){
        JFrame frame = new JFrame("Ventana con JTextField y JButton");
        frame.setSize(400,300);
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Mostrar texto");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                JOptionPane.showMessageDialog(frame, "El texto ingresado es: "+text);            
            }
        });
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(textField);
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }    
}