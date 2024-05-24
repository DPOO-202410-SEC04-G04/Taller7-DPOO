package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Top10;

import java.awt.*;
import java.util.List;
import java.util.Vector;
import java.util.ArrayList;

public class TopTenDialog extends JDialog {
	
    public TopTenDialog(JFrame parent, Top10 top10) {
        super(parent, "Top 10", true);
        setSize(300, 400);
        setLocationRelativeTo(parent);

        // Convertir los registros a una lista para el JList
        List<RegistroTop10> listaRegistros = new ArrayList<>(top10.darRegistros());
        JList<RegistroTop10> list = new JList<>(new Vector<>(listaRegistros));
        list.setCellRenderer(new PuntajeCellRenderer());
        add(new JScrollPane(list));

        setVisible(true);
    }

    private static class PuntajeCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            RegistroTop10 registro = (RegistroTop10) value;
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel labelIndex = new JLabel((index + 1) + ".");
            JLabel labelNombre = new JLabel(registro.darNombre());
            JLabel labelPuntaje = new JLabel(String.valueOf(registro.darPuntos()));

            labelIndex.setFont(new Font("Arial", Font.BOLD, 18));
            labelNombre.setFont(new Font("Arial", Font.PLAIN, 18));
            labelPuntaje.setFont(new Font("Arial", Font.BOLD, 18));

            // Cambiar el color de fondo y fuente según la posición
            if (index < 3) {
                labelIndex.setForeground(new Color[]{Color.RED, Color.BLUE, Color.GREEN}[index]);
                labelNombre.setForeground(new Color[]{Color.RED, Color.BLUE, Color.GREEN}[index]);
                labelPuntaje.setForeground(new Color[]{Color.RED, Color.BLUE, Color.GREEN}[index]);
            } else {
                labelIndex.setForeground(Color.BLACK);
                labelNombre.setForeground(Color.BLACK);
                labelPuntaje.setForeground(Color.BLACK);
            }

            panel.add(labelIndex);
            panel.add(labelNombre);
            panel.add(labelPuntaje);
            return panel;
        }
    }
}
