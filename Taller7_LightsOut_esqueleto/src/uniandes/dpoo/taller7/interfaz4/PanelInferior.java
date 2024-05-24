package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

public class PanelInferior extends JPanel {
    private JTextField nombreJugadorTextField;  // Campo de texto para el nombre del jugador
    private JTextField puntajeTextField;        // Campo de texto para mostrar el puntaje
    private JTextField jugadasTextField;  // Campo de texto para las jugadas



    public PanelInferior() {
        setLayout(new GridBagLayout());
        setBackground(new Color(255, 204, 204)); // Un rojo claro para el fondo

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(new JLabel("Jugadas:"), gbc);
        jugadasTextField = new JTextField("0", 5);  // Inicializar con 0 jugadas
        jugadasTextField.setEditable(false);  // El campo no debe ser editable
        add(jugadasTextField, gbc);

        add(new JLabel("Jugador:"), gbc);
        nombreJugadorTextField = new JTextField(10);
        nombreJugadorTextField.setEditable(false);
        add(nombreJugadorTextField, gbc);
    }
    
    public void registrarPuntaje(int puntaje) {
        puntajeTextField.setText(String.valueOf(puntaje));
        // Llama a la función para guardar en el archivo CSV
        guardarEnArchivoCSV(getNombreJugador(), puntaje);
    }
    
    private void guardarEnArchivoCSV(String nombre, int puntaje) {
        // Define la ruta del archivo CSV
        String path = ".\\data\\top10.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            // Escribe una nueva línea con el formato: nombre,puntaje
            bw.write(nombre + "," + puntaje + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al escribir en el archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setJugadas(int jugadas) {
        jugadasTextField.setText(String.valueOf(jugadas));
    }

    public int getJugadas() {
        return Integer.parseInt(jugadasTextField.getText());
    }


    public void setNombreJugador(String nombre) {
        nombreJugadorTextField.setText(nombre);
    }

    public String getNombreJugador() {
        return nombreJugadorTextField.getText().trim();
    }
}
