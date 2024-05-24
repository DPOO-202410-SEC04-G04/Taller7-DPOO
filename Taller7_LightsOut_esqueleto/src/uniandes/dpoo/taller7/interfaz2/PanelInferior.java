package uniandes.dpoo.taller7.interfaz2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelInferior extends JPanel {
    public PanelInferior() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JLabel("Jugadas:"));
        add(new JTextField(5));  // Text field para jugadas
        add(new JLabel("Jugador:"));
        add(new JTextField(10)); // Text field para jugador
    }
}

