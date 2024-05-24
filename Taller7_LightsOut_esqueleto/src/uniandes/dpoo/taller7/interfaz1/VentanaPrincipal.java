package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        // Establece el t�tulo de la ventana
        setTitle("Juego de LightsOut");

        // Establece el tama�o de la ventana
        setSize(537, 344); // Ancho y alto en p�xeles

        // Configura la operaci�n de cierre por defecto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hace que la ventana sea visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crea una instancia de la ventana
        new VentanaPrincipal();
    }
}
