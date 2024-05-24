package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import java.awt.*;

public class PanelTablero extends JPanel implements MouseListener {
    private boolean[][] estadoActual;
    private boolean[][] estadoInicial;  // Matriz para guardar el estado inicial
    private int tamano; // N�mero de celdas por lado
    private int jugadas;  // Contador de jugadas

    // Constructor de la clase
    public PanelTablero(int tamanoInicial) {
        this.tamano = tamanoInicial;
        inicializarEstado(tamanoInicial, "Facil");
        addMouseListener(this);
        setPreferredSize(new Dimension(300, 300));  // Ajusta el tama�o preferido del panel
    }

    // M�todo para establecer el tama�o del tablero
    public void setTamano(int nuevoTamano) {
        this.tamano = nuevoTamano;
        inicializarEstado(nuevoTamano, "Facil");  // Reinicializa el estado con el nuevo tama�o
        repaint();  // Repinta el panel con el nuevo tama�o
    }

    // M�todo para reiniciar el tablero con una dificultad espec�fica
    public void reiniciar(String dificultad) {
        inicializarEstado(tamano, dificultad	);  // Puede ajustar la configuraci�n inicial seg�n la dificultad
        jugadas = 0;  // Reinicia el contador de jugadas
        repaint();  // Redibuja el tablero con el estado inicial adecuado
    }

    // M�todo para inicializar el estado del tablero
    private void inicializarEstado(int tamano, String dificultad) {
        estadoActual = new boolean[tamano][tamano];
        estadoInicial = new boolean[tamano][tamano];
        Random random = new Random();
        double probabilidadEncendido;

        switch (dificultad) {
            case "F�cil":
                probabilidadEncendido = 0.6; // 60% de las casillas encendidas inicialmente
                break;
            case "Medio":
                probabilidadEncendido = 0.4; // 40% de las casillas encendidas inicialmente
                break;
            case "Dif�cil":
                probabilidadEncendido = 0.2; // 20% de las casillas encendidas inicialmente
                break;
            default:
                probabilidadEncendido = 0.5; // Default es F�cil si no se reconoce la dificultad
        }

        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                estadoInicial[i][j] = estadoActual[i][j] = random.nextDouble() < probabilidadEncendido;
            }
        }
        jugadas = 0;  // Inicializa el contador de jugadas
    }


    // M�todo para pintar el componente
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellWidth = getWidth() / tamano;
        int cellHeight = getHeight() / tamano;
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                if (estadoActual[i][j]) {
                    g.setColor(Color.YELLOW);  // Color para luces encendidas
                } else {
                    g.setColor(Color.GRAY);  // Color para luces apagadas
                }
                int x = j * cellWidth;
                int y = i * cellHeight;
                g.fillRect(x, y, cellWidth, cellHeight);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellWidth, cellHeight);
            }
        }
    }

    // M�todo para manejar clics del rat�n
    @Override
    public void mouseClicked(MouseEvent e) {
        int cellWidth = getWidth() / tamano;
        int cellHeight = getHeight() / tamano;
        int column = e.getX() / cellWidth;
        int row = e.getY() / cellHeight;

        toggleCellState(row, column);
        jugadas++;
        repaint();

        if (verificarVictoria()) {
            JOptionPane.showMessageDialog(this, "�Ganaste en " + jugadas + " jugadas!");
            reiniciar("dificultad");  // Reinicia el juego para comenzar de nuevo
        }
    }

    // M�todo para alternar el estado de la celda y sus adyacentes
    private void toggleCellState(int row, int column) {
        toggleLight(row, column);
        if (row > 0) toggleLight(row - 1, column);
        if (row < tamano - 1) toggleLight(row + 1, column);
        if (column > 0) toggleLight(row, column - 1);
        if (column < tamano - 1) toggleLight(row, column + 1);
    }

    // M�todo para alternar el estado de una sola luz
    private void toggleLight(int row, int col) {
        if (row >= 0 && row < tamano && col >= 0 && col < tamano) {
            estadoActual[row][col] = !estadoActual[row][col];
        }
    }

    // M�todo para verificar si todas las luces est�n encendidas
    private boolean verificarVictoria() {
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                if (!estadoActual[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void reiniciarTablero() {
        for (int i = 0; i < tamano; i++) {
            System.arraycopy(estadoInicial[i], 0, estadoActual[i], 0, tamano);
        }
        jugadas = 0; // Reinicia el contador de jugadas
        repaint(); // Redibuja el tablero con el estado inicial
    }
    
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}