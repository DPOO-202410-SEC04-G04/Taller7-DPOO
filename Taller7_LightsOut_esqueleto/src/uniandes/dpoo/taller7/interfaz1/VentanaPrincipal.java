package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        // Establece el título de la ventana
        setTitle("Juego de LightsOut");

        // Establece el tamaño de la ventana
        setSize(537, 344); // Ancho y alto en píxeles

        // Configura la operación de cierre por defecto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hace que la ventana sea visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crea una instancia de la ventana
        new VentanaPrincipal();
    }
}
