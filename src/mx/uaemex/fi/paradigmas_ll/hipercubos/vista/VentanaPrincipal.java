package mx.uaemex.fi.paradigmas_ll.hipercubos.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import mx.uaemex.fi.paradigmas_ll.hipercubos.modelo.Nodo;
import mx.uaemex.fi.paradigmas_ll.hipercubos.modelo.RutaConexion;

public class VentanaPrincipal extends JFrame {

    private PanelHipercubos panel;

    public VentanaPrincipal() {
        super("Hipercubos");
        Font font = new Font("Arial Bold", Font.ITALIC, 18);

        Color borderColor = Color.decode("#800080");
        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor, 1),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(3, 3, 3, 3),
                        BorderFactory.createLineBorder(Color.WHITE, 1)
                )
        );

        JButton btnGenerarRuta = new JButton("Mostrar ruta");
        Color colorGR = Color.decode("#87CEFA");
        btnGenerarRuta.setBackground(colorGR);
        btnGenerarRuta.setForeground(Color.BLACK);
        btnGenerarRuta.setFont(new Font("Arial", Font.BOLD, 14));
        btnGenerarRuta.setPreferredSize(new Dimension(150, 50));
        btnGenerarRuta.setBounds(340, 570, 150, 30);
        btnGenerarRuta.setBorderPainted(false);
        btnGenerarRuta.setEnabled(false);

        JButton btnLimpiar = new JButton("Borrar");
        Color colorLim = Color.decode("#B2FFB2");
        btnLimpiar.setBackground(colorLim);
        btnLimpiar.setForeground(Color.BLACK);
        btnLimpiar.setFont(new Font("Arial", Font.BOLD, 14));
        btnLimpiar.setPreferredSize(new Dimension(150, 50));
        btnLimpiar.setBounds(140, 570, 150, 30);
        btnLimpiar.setBorderPainted(false);

        this.panel = new PanelHipercubos();
        this.add(panel);
        Color colorPanel = Color.decode("#E6CCFF"); // Establece el color de fondo del panel
        panel.setBackground(colorPanel); // Establece el color de fondo del panel
        panel.setLayout(null);
        panel.add(btnGenerarRuta); // Agrega el botón en el centro inferior del panel
        panel.add(btnLimpiar);

        this.setSize(650, 670);
        this.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar ventana deja de ejecutarse
        this.setVisible(true);
        this.setResizable(false); // Deshabilita el btnGenerarRuta de maximizar ventana

        JLabel lbl1 = new JLabel("Emisor:");
        lbl1.setBounds(215, 300, 100, 100);
        lbl1.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lbl1);

        JLabel lbl2 = new JLabel("Destino:");
        lbl2.setBounds(215, 350, 100, 100);
        lbl2.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lbl2);

        JLabel lbl3 = new JLabel("Ruta:");
        lbl3.setBounds(215, 400, 100, 100);
        lbl3.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lbl3);

        JLabel lbl4 = new JLabel("Elige un nodo emisor y uno receptor:");
        lbl4.setBounds(160, 250, 400, 100);
        lbl4.setFont(font);
        panel.add(lbl4);

        JTextField txtEmisor = new JTextField();
        txtEmisor.setBounds(300, 340, 130, 30);
        txtEmisor.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmisor.setEnabled(false);
        txtEmisor.setBorder(border);
        txtEmisor.setBackground(borderColor);
        txtEmisor.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(txtEmisor);

        JTextField txtDestino = new JTextField();
        txtDestino.setBounds(300, 390, 130, 30);
        txtDestino.setHorizontalAlignment(SwingConstants.CENTER);
        txtDestino.setEnabled(false);
        txtDestino.setBorder(border);
        txtDestino.setBackground(borderColor);
        txtDestino.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(txtDestino);

        JTextArea txtRuta = new JTextArea();
        txtRuta.setBounds(300, 440, 130, 90);
        txtRuta.setEnabled(false);
        txtRuta.setFont(new Font("Arial", Font.BOLD, 14));
        txtRuta.setBorder(border);
        txtRuta.setBackground(borderColor);
        panel.add(txtRuta);

        panel.addMouseListener(new MouseAdapter() {
            private int nodoInicial = -1;
            private int nodoFinal = -1;

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if (nodoInicial == -1) {
                    nodoInicial = getNodo(x, y);
                    if (nodoInicial != -1) {
                        //System.out.println("Emisor (E): " + nodoInicial);
                        txtEmisor.setText(String.valueOf(nodoInicial));
                    }
                } else if (nodoFinal == -1) {
                    nodoFinal = getNodo(x, y);
                    if (nodoFinal != -1) {
                        //System.out.println("Destino (D): " + nodoFinal);
                        txtDestino.setText(String.valueOf(nodoFinal));
                    }
                }

                if (nodoInicial != -1 && nodoFinal != -1) { // verifica si ambos nodos fueron seleccionados
                    btnGenerarRuta.setEnabled(true);
                    btnGenerarRuta.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            RutaConexion ruta = new RutaConexion(new Nodo(nodoInicial), new Nodo(nodoFinal));

                            panel.mostrarRuta(ruta);
                            panel.repaint();
                            txtRuta.setText(ruta.getRutaDescripcion());

                        }
                    });
                } else {
                    btnGenerarRuta.setEnabled(false);
                }

                btnLimpiar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Component[] components = panel.getComponents();
                        for (Component component : components) {
                            if (component instanceof JTextField) {
                                ((JTextField) component).setText("");
                            } else if (component instanceof JTextArea) {
                                ((JTextArea) component).setText("");
                            }
                        }
                        nodoInicial = -1;
                        nodoFinal = -1;
                        panel.ruta = null;
                        panel.repaint();
                        btnGenerarRuta.setEnabled(false);
                    }
                });
            }

            private int getNodo(int x, int y) {
                int[] posicionNodo = {
                    40, 40, 20, 20, // Nodo 0
                    190, 40, 20, 20, // Nodo 1
                    90, 90, 20, 20, // Nodo 2
                    240, 90, 20, 20, // Nodo 3
                    40, 190, 20, 20, // Nodo 4
                    190, 190, 20, 20, // Nodo 5
                    90, 240, 20, 20, // Nodo 6
                    240, 240, 20, 20, // Nodo 7
                    370, 40, 20, 20, // Nodo 8
                    520, 40, 20, 20, // Nodo 9
                    420, 90, 20, 20, // Nodo 10
                    570, 90, 20, 20, // Nodo 11
                    370, 190, 20, 20, // Nodo 12
                    520, 190, 20, 20, // Nodo 13
                    420, 240, 20, 20, // Nodo 14
                    570, 240, 20, 20 // Nodo 15
                };

                for (int i = 0; i < posicionNodo.length; i += 4) {
                    int nodoX = posicionNodo[i];
                    int nodoY = posicionNodo[i + 1];
                    int nodeWidth = posicionNodo[i + 2];
                    int nodeHeight = posicionNodo[i + 3];

                    if (x >= nodoX && x <= nodoX + nodeWidth && y >= nodoY && y <= nodoY + nodeHeight) {
                        return i / 4;
                    }
                }
                return -1;
            }
        });
    }
}
