package uniandes.dpoo.taller7.interfaz3;
import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {
    private JComboBox<String> comboBoxTamanio;  // Agrega un campo para el JComboBox

    public PanelSuperior() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Tamaño
        add(new JLabel("Tamaño"));
        comboBoxTamanio = new JComboBox<>(new String[]{"5x5", "7x7", "10x10"}); // Inicializa el JComboBox aquí
        add(comboBoxTamanio);

        // Dificultad
        add(new JLabel("Dificultad"));
        JRadioButton facil = new JRadioButton("Fácil", true);
        JRadioButton medio = new JRadioButton("Medio", false);
        JRadioButton dificil = new JRadioButton("Difícil", false);
        ButtonGroup grupoDificultad = new ButtonGroup();
        grupoDificultad.add(facil);
        grupoDificultad.add(medio);
        grupoDificultad.add(dificil);
        add(facil);
        add(medio);
        add(dificil);
    }

    // Método para obtener el JComboBox
    public JComboBox<String> getComboBoxTamanio() {
        return comboBoxTamanio;
    }
}



