package uniandes.dpoo.taller7.interfaz2;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelDerecho extends JPanel {
    public PanelDerecho() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JButton("NUEVO"));
        add(new JButton("REINICIAR"));
        add(new JButton("TOP-10"));
        add(new JButton("CAMBIAR JUGADOR"));
    }
}

