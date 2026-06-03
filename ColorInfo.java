
package javaapplication13;

import java.awt.Color;

public class ColorInfo {
    private String nombre;
    private Color color;

    public ColorInfo(String nombre, Color color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() { return nombre; }
    public Color getColor() { return color; }

    @Override
    public String toString() { return nombre; }
}
