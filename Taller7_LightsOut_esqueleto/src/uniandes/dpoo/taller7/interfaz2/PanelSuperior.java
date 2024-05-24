package uniandes.dpoo.taller7.interfaz2;
import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {
    public PanelSuperior() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Tamaño
        add(new JLabel("Tamaño"));
        JComboBox<String> comboBoxTamanio = new JComboBox<>(new String[]{"5x5", "7x7", "10x10"});
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
}


