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

        // Agrega botones al panel de botones
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

        // Agrega componentes al panel principal
        panel.add(botonesPanel, BorderLayout.WEST);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Agrega panel principal a la ventana
        add(panel);

        // Maneja eventos de los botones
        ejercicio1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Solicita la entrada al usuario
                String entrada = JOptionPane
                        .showInputDialog("Ingresa la nota y el texto en el formato: 'nota', 'texto'");

                // Valida que la entrada no sea nula o vacía
                if (entrada == null || entrada.trim().isEmpty()) {
                    resultadoArea.append("Entrada vacía. Intenta de nuevo.\n");
                    return;
                }

                // Extrae los valores de nota y texto
                String[] partes = entrada.split("'");
                if (partes.length < 3) {
                    resultadoArea.append("Formato de entrada incorrecto. Usa: 'nota', 'texto'\n");
                    return;
                }

                // La primera cadena entre comillas es nota, la segunda es texto
                String nota = partes[1].trim();
                String texto = partes[3].trim();

                // Valida que nota y texto no contengan números ni símbolos no permitidos
                if (!nota.matches("[a-zA-Z]+") || !texto.matches("[a-zA-Z]+")) {
                    resultadoArea.append("La nota y el texto solo deben contener letras. Intenta de nuevo.\n");
                    return;
                }

                // Llamar al método puedeGenerarse de Ejercicio1 y nos da el resultado
                boolean resultado = ejercicio1.puedeGenerarse(nota, texto);
                resultadoArea.append("Ejercicio 1 - Resultado: " + resultado + "\n");
            }
        });

        ejercicio2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Solicita la entrada del arreglo
                String arregloInput = JOptionPane
                        .showInputDialog("Ingresa el arreglo de números (ejemplo: [números separados por comas]):");

                // Valida que la entrada no sea nula o vacía
                if (arregloInput == null || arregloInput.trim().isEmpty()) {
                    resultadoArea.append("Entrada vacía. Intenta de nuevo.\n");
                    return;
                }

                // Valida que la entrada esté entre corchetes
                if (!arregloInput.startsWith("[") || !arregloInput.endsWith("]")) {
                    resultadoArea.append("Formato de entrada incorrecto. Usa: [números separados por comas]\n");
                    return;
                }

                // Extrae los números del arreglo
                String arregloStr = arregloInput.substring(1, arregloInput.length() - 1).replace(" ", "");
                String[] numerosStr = arregloStr.split(",");

                // Valida que todos los elementos sean números
                int[] arreglo = new int[numerosStr.length];
                try {
                    for (int i = 0; i < numerosStr.length; i++) {
                        arreglo[i] = Integer.parseInt(numerosStr[i]);
                    }
                } catch (NumberFormatException ex) {
                    resultadoArea.append("El arreglo debe contener solo números separados por comas.\n");
                    return;
                }

                // Solicita la entrada de k
                String kInput = JOptionPane.showInputDialog("Ingresa el valor de k:");

                // Valida que k sea un número entero válido
                int k;
                try {
                    k = Integer.parseInt(kInput.trim());
                } catch (NumberFormatException ex) {
                    resultadoArea.append("El valor de k debe ser un número entero.\n");
                    return;
                }

                // Llama al método indicesDistintos de Ejercicio2 y nos da el resultado
                boolean resultado = ejercicio2.indicesDistintos(arreglo, k);
                resultadoArea.append("Ejercicio 2 - Resultado: " + resultado + "\n");
            }
        });

        ejercicio3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroInput = JOptionPane.showInputDialog("Ingresa un número:");
                try {
                    int numero = Integer.parseInt(numeroInput);
                    // Llama al método esFeliz de Ejercicio3 y nos da el resultado
                    boolean resultado = ejercicio3.esFeliz(numero);
                    resultadoArea.append("Ejercicio 3 - Resultado: " + resultado + "\n");
                } catch (NumberFormatException ex) {
                    resultadoArea.append(
                            "Formato de entrada incorrecto para el número. Usa un número entero sin simbolos, etc.\n");
                }
            }
        });

        ejercicio4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Solicita la entrada de las cadenas
                String cadena1 = JOptionPane.showInputDialog("Ingresa la cadena 1(t):");
                String cadena2 = JOptionPane.showInputDialog("Ingresa la cadena 2(s):");

                // Valida que las cadenas no sean nulas o vacías
                if (cadena1 == null || cadena1.trim().isEmpty() || cadena2 == null || cadena2.trim().isEmpty()) {
                    resultadoArea.append("Entrada vacía. Intenta de nuevo.\n");
                    return;
                }

                // Valida que las cadenas solo contengan letras
                if (!cadena1.matches("[a-zA-Z]+") || !cadena2.matches("[a-zA-Z]+")) {
                    resultadoArea
                            .append("Error de formato: Las cadenas solo deben contener letras. Intenta de nuevo.\n");
                    return;
                }

                // Llama al método indiceOcurrencia del Ejercicio4 y nos da el resultado
                int resultado = ejercicio4.indiceOcurrencia(cadena1, cadena2);
                resultadoArea.append("Ejercicio 4 - Resultado: " + resultado + "\n");
            }
        });

        // Muestra la ventana
        setVisible(true);
    }

    private JButton crearBoton(String texto, ImageIcon icono) {
        JButton boton = new JButton(texto, icono);
        boton.setFont(new Font("SansSerif", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setBackground(new Color(71, 137, 146)); // Color de botoncitos
        boton.setForeground(Color.WHITE); // Texto blanco
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return boton;
    }

    public static void main(String[] args) {
        // Ejecuta la interfaz gráfica
        SwingUtilities.invokeLater(MainGUI::new);
    }
}