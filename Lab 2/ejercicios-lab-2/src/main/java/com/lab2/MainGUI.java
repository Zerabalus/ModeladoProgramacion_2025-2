package com.lab2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatDarkLaf;

public class MainGUI extends JFrame {

    private Ejercicio1 ejercicio1 = new Ejercicio1();
    private Ejercicio2 ejercicio2 = new Ejercicio2();
    private Ejercicio3 ejercicio3 = new Ejercicio3();
    private Ejercicio4 ejercicio4 = new Ejercicio4();

    private JTextArea resultadoArea;

    public MainGUI() {
        // Para que se pueda ver el tema oscuro
        FlatDarkLaf.setup();

        // Configuración de la ventana
        setTitle("Laboratorio 2 - Interfaz Gráfica");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cargar el icono desde una URL
        ImageIcon icono = null;
        try {
            URL url = new URL(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Escudo-facultad-ciencias-unam-escalable.svg/210px-Escudo-facultad-ciencias-unam-escalable.svg.png");
            icono = new ImageIcon(url);
            if (icono.getImage() == null) {
                throw new Exception("No se pudo cargar el icono desde la URL.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el icono: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            icono = new ImageIcon(); // Icono vacío si no se puede cargar
        }

        setIconImage(icono.getImage()); // Establece el icono de la ventana

        // Panel principal con BorderLayout
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel de botones con GridLayout
        JPanel botonesPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        botonesPanel.setBorder(BorderFactory.createTitledBorder("Ejercicios"));

        // Botones con estilo e iconos
        JButton ejercicio1Button = crearBoton("Ejercicio 1: Generar cadena", icono);
        JButton ejercicio2Button = crearBoton("Ejercicio 2: Índices distintos", icono);
        JButton ejercicio3Button = crearBoton("Ejercicio 3: Número feliz", icono);
        JButton ejercicio4Button = crearBoton("Ejercicio 4: Ocurrencia de subcadena", icono);

        // Agregar botones al panel de botones
        botonesPanel.add(ejercicio1Button);
        botonesPanel.add(ejercicio2Button);
        botonesPanel.add(ejercicio3Button);
        botonesPanel.add(ejercicio4Button);

        // Área de resultado con scroll
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultados"));

        // Agregar componentes al panel principal
        panel.add(botonesPanel, BorderLayout.WEST);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Agregar panel principal a la ventana
        add(panel);

        // Manejar eventos de los botones
        ejercicio1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nota = JOptionPane.showInputDialog("Ingresa la nota:");
                String texto = JOptionPane.showInputDialog("Ingresa el texto:");
                boolean resultado = ejercicio1.puedeGenerarse(nota, texto);
                resultadoArea.append("Ejercicio 1 - Resultado: " + resultado + "\n");
            }
        });

        ejercicio2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String arregloInput = JOptionPane
                        .showInputDialog("Ingresa el arreglo de números (ejemplo: [1, 2, 3, 1]):");
                String kInput = JOptionPane.showInputDialog("Ingresa el valor de k:");
                try {
                    String arregloStr = arregloInput.replace("[", "").replace("]", "").replace(" ", "");
                    String[] numerosStr = arregloStr.split(",");
                    int[] arreglo = new int[numerosStr.length];
                    for (int i = 0; i < numerosStr.length; i++) {
                        arreglo[i] = Integer.parseInt(numerosStr[i]);
                    }
                    int k = Integer.parseInt(kInput);
                    boolean resultado = ejercicio2.indicesDistintos(arreglo, k);
                    resultadoArea.append("Ejercicio 2 - Resultado: " + resultado + "\n");
                } catch (NumberFormatException ex) {
                    resultadoArea.append("Formato de entrada incorrecto en Ejercicio 2.\n");
                }
            }
        });

        ejercicio3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroInput = JOptionPane.showInputDialog("Ingresa un número:");
                try {
                    int numero = Integer.parseInt(numeroInput);
                    boolean resultado = ejercicio3.esFeliz(numero);
                    resultadoArea.append("Ejercicio 3 - Resultado: " + resultado + "\n");
                } catch (NumberFormatException ex) {
                    resultadoArea.append("Formato de entrada incorrecto en Ejercicio 3.\n");
                }
            }
        });

        ejercicio4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena1 = JOptionPane.showInputDialog("Ingresa la cadena 1:");
                String cadena2 = JOptionPane.showInputDialog("Ingresa la cadena 2:");
                int resultado = ejercicio4.indiceOcurrencia(cadena1, cadena2);
                resultadoArea.append("Ejercicio 4 - Resultado: " + resultado + "\n");
            }
        });

        // Mostrar la ventana
        setVisible(true);
    }

    private JButton crearBoton(String texto, ImageIcon icono) {
        JButton boton = new JButton(texto, icono);
        boton.setFont(new Font("SansSerif", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setBackground(new Color(0, 123, 255)); // Color azul
        boton.setForeground(Color.WHITE); // Texto blanco
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return boton;
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(MainGUI::new);
    }
}