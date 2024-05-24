package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;

public class PanelDerecho extends JPanel {
    private JButton nuevo, reiniciar, top10, cambiarJugador;

	
    public PanelDerecho(ActionListener nuevoListener, ActionListener reiniciarListener, ActionListener top10Listener, ActionListener cambiarJugadorListener, VentanaPrincipal ventanaPrincipal) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(229, 255, 204)); // Un verde claro para el fondo

        JButton nuevo = createButton("NUEVO");
        nuevo.addActionListener(nuevoListener);
        add(nuevo);

        JButton reiniciar = createButton("REINICIAR");
        reiniciar.addActionListener(reiniciarListener);
        add(reiniciar);

        JButton top10 = createButton("TOP-10");
        top10.addActionListener(top10Listener);
        add(top10);
        
        JButton cambiarJugador = createButton("CAMBIAR JUGADOR");
        cambiarJugador.addActionListener(e -> {
            ventanaPrincipal.cambiarNombreJugador();
        });
        add(cambiarJugador);
    }
    

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }
    
    
}

