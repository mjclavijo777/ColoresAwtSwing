
package javaapplication13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaColores extends JFrame {

  
    private JPanel panelColor;
    private JLabel lblNombreColor;

 
    private JPanel panelBotonesColores;

    // Colores de cada categoría
    private ColorInfo[] primarios = {
        new ColorInfo("Rojo",     new Color(220, 0, 0)),
        new ColorInfo("Azul",     new Color(0, 0, 200)),
        new ColorInfo("Amarillo", new Color(255, 210, 0))
    };

    private ColorInfo[] secundarios = {
        new ColorInfo("Verde",   new Color(0, 160, 0)),
        new ColorInfo("Naranja", new Color(255, 120, 0)),
        new ColorInfo("Violeta", new Color(130, 0, 200))
    };

    private ColorInfo[] terciarios = {
        new ColorInfo("Rojo-Anaranjado",  new Color(220, 60, 0)),
        new ColorInfo("Amarillo-Naranja", new Color(255, 165, 0)),
        new ColorInfo("Amarillo-Verde",   new Color(150, 200, 0)),
        new ColorInfo("Azul-Verde",       new Color(0, 160, 140)),
        new ColorInfo("Azul-Violeta",     new Color(60, 60, 200)),
        new ColorInfo("Rojo-Violeta",     new Color(180, 0, 120))
    };

    public VentanaColores() {
        setTitle("Colores");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ── Panel superior: botones de categoría ──
        JPanel panelCategorias = new JPanel(new FlowLayout());
        panelCategorias.setBorder(BorderFactory.createTitledBorder("Categorías"));

        JButton btnPrimarios   = new JButton("Primarios");
        JButton btnSecundarios = new JButton("Secundarios");
        JButton btnTerciarios  = new JButton("Terciarios");

        panelCategorias.add(btnPrimarios);
        panelCategorias.add(btnSecundarios);
        panelCategorias.add(btnTerciarios);

        // ── Panel izquierdo: botones de colores ──
        panelBotonesColores = new JPanel();
        panelBotonesColores.setLayout(new BoxLayout(panelBotonesColores, BoxLayout.Y_AXIS));
        panelBotonesColores.setBorder(BorderFactory.createTitledBorder("Colores"));
        panelBotonesColores.setPreferredSize(new Dimension(160, 0));

        // ── Panel derecho: visualización del color ──
        JPanel panelDerecho = new JPanel(new BorderLayout(5, 5));

        panelColor = new JPanel();
        panelColor.setBackground(Color.LIGHT_GRAY);
        panelColor.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        lblNombreColor = new JLabel("Selecciona un color", SwingConstants.CENTER);
        lblNombreColor.setFont(new Font("Arial", Font.BOLD, 16));

        panelDerecho.setBorder(BorderFactory.createTitledBorder("Color seleccionado"));
        panelDerecho.add(panelColor, BorderLayout.CENTER);
        panelDerecho.add(lblNombreColor, BorderLayout.SOUTH);

        // ── Agregar todo al frame ──
        add(panelCategorias,     BorderLayout.NORTH);
        add(panelBotonesColores, BorderLayout.WEST);
        add(panelDerecho,        BorderLayout.CENTER);

        // ── Acciones de los botones de categoría ──
        btnPrimarios.addActionListener(e -> mostrarColores(primarios));
        btnSecundarios.addActionListener(e -> mostrarColores(secundarios));
        btnTerciarios.addActionListener(e -> mostrarColores(terciarios));

        setVisible(true);
    }

    // Muestra los botones de colores de la categoría elegida
    private void mostrarColores(ColorInfo[] colores) {
        panelBotonesColores.removeAll();

        for (ColorInfo c : colores) {
            JButton btn = new JButton(c.getNombre());
            btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            btn.addActionListener(e -> seleccionarColor(c));
            panelBotonesColores.add(btn);
            panelBotonesColores.add(Box.createVerticalStrut(5));
        }

        panelBotonesColores.revalidate();
        panelBotonesColores.repaint();

        // Limpiar visualización al cambiar categoría
        panelColor.setBackground(Color.LIGHT_GRAY);
        lblNombreColor.setText("Selecciona un color");
    }

    // Muestra el color seleccionado
    private void seleccionarColor(ColorInfo c) {
        panelColor.setBackground(c.getColor());
        lblNombreColor.setText(c.getNombre());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaColores::new);
    }
}

