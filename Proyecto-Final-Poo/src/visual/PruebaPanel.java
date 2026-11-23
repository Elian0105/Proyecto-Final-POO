package visual;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PruebaPanel {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Prueba");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1050, 700);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            frame.setContentPane(new PanelPlanesServicios());

            frame.setVisible(true);
        });
    }
}