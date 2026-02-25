import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class VentanaEscurridiza extends JFrame {
    private JTextField cajaTexto;
    private String secuencia = "";

    public VentanaEscurridiza() {

        setSize(400, 200);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        JButton botonSalir = new JButton("Salir");
        cajaTexto = new JTextField(20);
        JLabel etiqueta = new JLabel("Konami te suena de algo? ");

        JPanel panel = new JPanel();
        panel.add(etiqueta);
        panel.add(cajaTexto);
        panel.add(botonSalir);

        add(panel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            }
        });

        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moverVentana();
            }
        });

        cajaTexto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                String tecla = "";

                if (e.getKeyCode() == KeyEvent.VK_UP) tecla = "arriba";
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) tecla = "abajo";
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) tecla = "izquierda";
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) tecla = "derecha";
                else if (e.getKeyCode() == KeyEvent.VK_A) tecla = "a";
                else if (e.getKeyCode() == KeyEvent.VK_B) tecla = "b";

                if (!tecla.equals("")) {
                    secuencia += tecla + " ";
                    cajaTexto.setText(secuencia);

                    if (secuencia.equals("arriba arriba abajo abajo izquierda derecha izquierda derecha a b ")) {
                        JOptionPane.showMessageDialog(null, "Codigo activado, ahora ya eres libre");
                        setDefaultCloseOperation(EXIT_ON_CLOSE);
                        botonSalir.setText("Salir");
                        botonSalir.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                System.exit(0);
                            }
                        });
                    }
                }
            }
        });
    }

    private void moverVentana() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int)(Math.random() * (pantalla.width - getWidth()));
        int y = (int)(Math.random() * (pantalla.height - getHeight()));
        setLocation(x, y);
    }

    public static void main(String[] args) {
        VentanaEscurridiza ventana = new VentanaEscurridiza();
        ventana.setVisible(true);
    }
}