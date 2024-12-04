
package CapaPresentacion;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

public class BotonesDinamicos extends JFrame {
    private JButton[] botones = new JButton[10];
    private JTextField campoNumeros;
    private JButton botonAplicar;

    public BotonesDinamicos() {
        setTitle("Mostrar/Ocultar Botones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        // Crear y agregar los 10 botones
        for (int i = 0; i < 10; i++) {
            botones[i] = new JButton("Botón " + (i + 1));
            panelBotones.add(botones[i]);
        }

        add(panelBotones, BorderLayout.CENTER);

        // Panel inferior para la entrada y el botón de aplicar
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());

        JLabel etiqueta = new JLabel("Ingresa números separados por comas:");
        campoNumeros = new JTextField(20);
        botonAplicar = new JButton("Aplicar");

        panelInferior.add(etiqueta);
        panelInferior.add(campoNumeros);
        panelInferior.add(botonAplicar);

        add(panelInferior, BorderLayout.SOUTH);

        // Acción del botón aplicar
        botonAplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplicarVisibilidad();
            }
        });

        setVisible(true);
    }

    private void aplicarVisibilidad() {
        String entrada = campoNumeros.getText().trim();
        if (entrada.isEmpty()) {
            // Si la entrada está vacía, ocultar todos los botones
            for (JButton boton : botones) {
                boton.setVisible(false);
            }
            return;
        }

        // Separar la entrada por comas y convertir a un conjunto de números
        String[] partes = entrada.split(",");
        Set<Integer> numeros = new HashSet<>();
        for (String parte : partes) {
            try {
                int num = Integer.parseInt(parte.trim());
                if (num >= 1 && num <= 10) {
                    numeros.add(num);
                } else {
                    JOptionPane.showMessageDialog(this, "Número fuera de rango (1-10): " + num);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Entrada inválida: " + parte);
            }
        }

        // Actualizar la visibilidad de los botones
        for (int i = 0; i < botones.length; i++) {
            if (numeros.contains(i + 1)) {
                botones[i].setVisible(true);
            } else {
                botones[i].setVisible(false);
            }
        }

        // Revalidar y repaint para actualizar la interfaz
        this.revalidate();
        this.repaint();
    }

    public static void main(String[] args) {
        // Ejecutar en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BotonesDinamicos();
            }
        });
    }
}
