package uniandes.dpoo.taller7.interfaz2;
import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {
    public PanelSuperior() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Tama�o
        add(new JLabel("Tama�o"));
        JComboBox<String> comboBoxTamanio = new JComboBox<>(new String[]{"5x5", "7x7", "10x10"});
        add(comboBoxTamanio);

        // Dificultad
        add(new JLabel("Dificultad"));
        JRadioButton facil = new JRadioButton("F�cil", true);
        JRadioButton medio = new JRadioButton("Medio", false);
        JRadioButton dificil = new JRadioButton("Dif�cil", false);
        ButtonGroup grupoDificultad = new ButtonGroup();
        grupoDificultad.add(facil);
        grupoDificultad.add(medio);
        grupoDificultad.add(dificil);
        add(facil);
        add(medio);
        add(dificil);
    }
}


