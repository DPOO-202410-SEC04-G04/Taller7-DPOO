package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

public class PanelTablero extends JPanel {
    private int tamano; // número de celdas por lado

    public PanelTablero(int tamanoInicial) {
        this.tamano = tamanoInicial;
    }

    public void setTamano(int nuevoTamano) {
        this.tamano = nuevoTamano;
        repaint();  // Repinta el panel con el nuevo tamaño
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellWidth = getWidth() / tamano;
        int cellHeight = getHeight() / tamano;
        g.setColor(Color.YELLOW);
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                int x = i * cellWidth;
                int y = j * cellHeight;
                g.fillRect(x, y, cellWidth, cellHeight);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellWidth, cellHeight);
                g.setColor(Color.YELLOW); // Restablecer el color para el siguiente relleno
            }
        }
    }

}

