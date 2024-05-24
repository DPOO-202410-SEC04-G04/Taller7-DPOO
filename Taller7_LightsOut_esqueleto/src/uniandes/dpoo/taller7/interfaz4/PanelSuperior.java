package uniandes.dpoo.taller7.interfaz4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelSuperior extends JPanel {
    private JComboBox<String> comboBoxTamanio;
    private JRadioButton facil, medio, dificil;
    private PanelTablero panelTablero; // Referencia al panel de tablero

    public PanelSuperior(PanelTablero panelTablero) {
        this.panelTablero = panelTablero; // Inicializa la referencia al panel de tablero
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(204, 229, 255)); // Un azul claro para el fondo

        JLabel labelTamano = new JLabel("Tamaño");
        labelTamano.setForeground(Color.BLACK); // Color del texto
        add(labelTamano);

        comboBoxTamanio = new JComboBox<>(new String[]{"5x5", "7x7", "10x10"});
        add(comboBoxTamanio);

        JLabel labelDificultad = new JLabel("Dificultad");
        labelDificultad.setForeground(Color.BLACK);
        add(labelDificultad);

        facil = new JRadioButton("Fácil", true);
        medio = new JRadioButton("Medio", false);
        dificil = new JRadioButton("Difícil", false);
        ButtonGroup grupoDificultad = new ButtonGroup();
        grupoDificultad.add(facil);
        grupoDificultad.add(medio);
        grupoDificultad.add(dificil);
        add(facil);
        add(medio);
        add(dificil);

        // Agregar action listeners para cambiar el tablero cuando cambia la dificultad
        ActionListener dificultadListener = e -> {
            String dificultadSeleccionada = getDificultadSeleccionada();
            panelTablero.reiniciar(dificultadSeleccionada);
        };

        facil.addActionListener(dificultadListener);
        medio.addActionListener(dificultadListener);
        dificil.addActionListener(dificultadListener);
    }

    public JComboBox<String> getComboBoxTamanio() {
        return comboBoxTamanio;
    }
    
    public int getTamanoSeleccionado() {
        String seleccion = (String) comboBoxTamanio.getSelectedItem();
        return Integer.parseInt(seleccion.split("x")[0]);
    }
    
    public String getDificultadSeleccionada() {
        if (facil.isSelected()) return "Fácil";
        if (medio.isSelected()) return "Medio";
        if (dificil.isSelected()) return "Difícil";
        return null;
    }
}
