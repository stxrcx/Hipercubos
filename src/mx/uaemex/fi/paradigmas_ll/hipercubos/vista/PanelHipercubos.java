package mx.uaemex.fi.paradigmas_ll.hipercubos.vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import java.util.List;
import javax.swing.JPanel;
import mx.uaemex.fi.paradigmas_ll.hipercubos.modelo.Nodo;
import mx.uaemex.fi.paradigmas_ll.hipercubos.modelo.RutaConexion;

public class PanelHipercubos extends JPanel {

    private static final int MEDIDA_CUBO_1 = 150;
    private static final int MEDIDA_CUBO_2 = 330;
    RutaConexion ruta;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color colorNodos = Color.decode("#87CEEB");
        Color colorRuta = Color.decode("#800080");

        // Dibuja el cubo uno
        g.setColor(Color.BLACK);
        g.drawRect(50, 50, MEDIDA_CUBO_1, MEDIDA_CUBO_1); // Cara frontal
        g.drawRect(100, 100, MEDIDA_CUBO_1, MEDIDA_CUBO_1); // Cara posterior
        g.drawLine(50, 50, 100, 100); // Línea superior
        g.drawString("0000", 20, 40);  // Nodo: 0
        g.drawLine(50 + MEDIDA_CUBO_1, 50, 100 + MEDIDA_CUBO_1, 100); // Línea superior
        g.drawString("0001", 50 + MEDIDA_CUBO_1, 40); // Nodo: 1
        g.drawLine(50 + MEDIDA_CUBO_1, 50 + MEDIDA_CUBO_1, 100 + MEDIDA_CUBO_1, 100 + MEDIDA_CUBO_1); // Línea izquierda
        g.drawString("0010", 105, 90); // Nodo: 2
        g.drawLine(50, 50, 50, 50 + MEDIDA_CUBO_1); // Línea lateral izquierda
        g.drawString("0011", 250, 90); // Nodo: 3
        g.drawLine(50, 50 + MEDIDA_CUBO_1, 100, 100 + MEDIDA_CUBO_1); // Línea izquierda - diagonal
        g.drawString("0100", 20, 40 + MEDIDA_CUBO_1); // Nodo: 4
        g.drawLine(100 + MEDIDA_CUBO_1, 100, 100 + MEDIDA_CUBO_1, 100 + MEDIDA_CUBO_1); // Línea lateral derecha
        g.drawString("0101", 170, 190); // Nodo: 5
        g.drawLine(100, 100, 100, 100 + MEDIDA_CUBO_1); // Línea lateral izquierda
        g.drawString("0110", 100, 270); // Nodo: 6
        g.drawLine(50 + MEDIDA_CUBO_1, 50, 50 + MEDIDA_CUBO_1, 50 + MEDIDA_CUBO_1); // Línea lateral derecha
        g.drawString("0111", 250, 270); // Nodo: 7

        // Dibuja nodos en cada arista del cubo 1
        g.setColor(colorNodos);
        g.fillOval(40, 40, 20, 20); // Nodo 0
        g.fillOval(190, 40, 20, 20); // Nodo 1
        g.fillOval(90, 90, 20, 20); // Nodo 2
        g.fillOval(240, 90, 20, 20); // Nodo 3
        g.fillOval(40, 190, 20, 20); // Nodo 4
        g.fillOval(190, 190, 20, 20); // Nodo 5
        g.fillOval(90, 240, 20, 20); // Nodo 6
        g.fillOval(240, 240, 20, 20); // Nodo 7

        g.setColor(Color.BLACK);
        g.drawString("0", 47, 55);  // Nodo: 0
        g.drawString("1", 197, 55);  // Nodo: 1
        g.drawString("2", 97, 105);  // Nodo: 2
        g.drawString("3", 247, 105);  // Nodo: 3
        g.drawString("4", 47, 205);  // Nodo: 4
        g.drawString("5", 197, 205);  // Nodo: 5
        g.drawString("6", 97, 255);  // Nodo: 6
        g.drawString("7", 247, 255);  // Nodo: 7

        // Dibuja el cubo dos
        g.setColor(Color.BLACK);
        g.drawRect(50 + MEDIDA_CUBO_2, 50, MEDIDA_CUBO_1, MEDIDA_CUBO_1); // Cara frontal
        g.drawRect(100 + MEDIDA_CUBO_2, 100, MEDIDA_CUBO_1, MEDIDA_CUBO_1); // Cara posterior
        g.drawLine(50 + MEDIDA_CUBO_2, 50, 100 + MEDIDA_CUBO_2, 100); // Línea superior
        g.drawString("1000", 350, 40); // Nodo: 0
        g.drawLine(50 + MEDIDA_CUBO_1 + MEDIDA_CUBO_2, 50, 100 + MEDIDA_CUBO_1 + MEDIDA_CUBO_2, 100); // Línea superior
        g.drawString("1001", 380 + MEDIDA_CUBO_1, 40); // Nodo: 1
        g.drawLine(50 + MEDIDA_CUBO_1 + MEDIDA_CUBO_2, 50 + MEDIDA_CUBO_1, 100 + MEDIDA_CUBO_1 + MEDIDA_CUBO_2, 100 + MEDIDA_CUBO_1); // Línea izquierda
        g.drawString("1010", 440, 90); // Nodo: 2
        g.drawLine(50 + MEDIDA_CUBO_2, 50, 50 + MEDIDA_CUBO_2, 50 + MEDIDA_CUBO_1); // Línea lateral izquierda
        g.drawString("1011", 580, 90); // Nodo: 3
        g.drawLine(50 + MEDIDA_CUBO_2, 50 + MEDIDA_CUBO_1, 100 + MEDIDA_CUBO_2, 100 + MEDIDA_CUBO_1); // Línea izquierda
        g.drawString("1100", 350, 40 + MEDIDA_CUBO_1); // Nodo: 4
        g.drawLine(100 + MEDIDA_CUBO_1 + MEDIDA_CUBO_2, 100, 100 + MEDIDA_CUBO_1 + MEDIDA_CUBO_2, 100 + MEDIDA_CUBO_1); // Línea lateral derecha
        g.drawString("1101", 500, 190); // Nodo: 5
        g.drawLine(100 + MEDIDA_CUBO_2, 100, 100 + MEDIDA_CUBO_2, 100 + MEDIDA_CUBO_1); // Línea lateral izquierda
        g.drawString("1110", 440, 270); // Nodo: 6
        g.drawLine(50 + MEDIDA_CUBO_1 + MEDIDA_CUBO_2, 50, 50 + MEDIDA_CUBO_1 + MEDIDA_CUBO_2, 50 + MEDIDA_CUBO_1); // Línea lateral derecha
        g.drawString("1111", 580, 270); // Nodo: 7

        // Dibuja nodos en cada arista del cubo 2
        g.setColor(colorNodos);
        g.fillOval(370, 40, 20, 20); // Nodo 8
        g.fillOval(520, 40, 20, 20); // Nodo 9
        g.fillOval(420, 90, 20, 20); // Nodo 10
        g.fillOval(570, 90, 20, 20); // Nodo 11
        g.fillOval(370, 190, 20, 20); // Nodo 12
        g.fillOval(520, 190, 20, 20); // Nodo 13
        g.fillOval(420, 240, 20, 20); // Nodo 14
        g.fillOval(570, 240, 20, 20); // Nodo 15

        g.setColor(Color.BLACK);
        g.drawString("8", 377, 55);  // Nodo: 8
        g.drawString("9", 527, 55);  // Nodo: 9
        g.drawString("10", 423, 105);  // Nodo: 10
        g.drawString("11", 573, 105);  // Nodo: 11
        g.drawString("12", 373, 205);  // Nodo: 12
        g.drawString("13", 523, 205);  // Nodo: 13
        g.drawString("14", 423, 255);  // Nodo: 14
        g.drawString("15", 573, 255);  // Nodo: 15

        if (ruta != null) {
            List<Nodo> rutaNodos = this.ruta.getRutaNodos();

            int[] posicionXY1;
            int[] posicionXY2;

            g.setColor(colorRuta);
            Graphics2D g2d = (Graphics2D) g;

            while (rutaNodos.size() != 1) {
                Nodo currentNodo = rutaNodos.get(0);
                Nodo nextNodo = rutaNodos.get(1);
                posicionXY1 = this.getCoordenadas(currentNodo.getValorEntero());
                posicionXY2 = this.getCoordenadas(nextNodo.getValorEntero());

                if ((currentNodo.getValorEntero() < 8 && nextNodo.getValorEntero() > 8) || (currentNodo.getValorEntero() > 8 && nextNodo.getValorEntero() < 8)) {
                    int x1 = posicionXY1[0] + 10;
                    int y1 = posicionXY1[1] + 10;
                    int x2 = posicionXY2[0] + 10;
                    int y2 = posicionXY2[1] + 10;
                    int xc = (x1 + x2) / 2; // Calcular la posición del punto
                    int yc = (y1 + y2) / 2;
                    QuadCurve2D curva = new QuadCurve2D.Float(x1, y1, xc, yc - 50, x2, y2); // Ajustar las coordenadas del punto
                    g2d.setStroke(new BasicStroke(3));
                    g2d.draw(curva);
                } else {
                    g2d.setStroke(new BasicStroke(3));
                    g.drawLine(posicionXY1[0] + 10, posicionXY1[1] + 10, posicionXY2[0] + 10, posicionXY2[1] + 10);
                }
                rutaNodos.remove(0);
            }
        }
    }

    public void mostrarRuta(RutaConexion ruta) {
        this.ruta = ruta;
        repaint();
    }

    private int[] getCoordenadas(int nodo) {

        int[] posicionNodo = {
            40, 40, // Nodo 0
            190, 40, // Nodo 1
            90, 90, // Nodo 2
            240, 90, // Nodo 3
            40, 190, // Nodo 4
            190, 190, // Nodo 5
            90, 240, // Nodo 6
            240, 240, // Nodo 7
            370, 40, // Nodo 8
            520, 40, // Nodo 9
            420, 90, // Nodo 10
            570, 90, // Nodo 11
            370, 190, // Nodo 12
            520, 190, // Nodo 13
            420, 240,// Nodo 14
            570, 240 // Nodo 15
        };

        int[] infoNodo = new int[2];

        for (int i = 0; i < infoNodo.length; i++) {
            infoNodo[i] = posicionNodo[(nodo * 2) + i];
        }

        return infoNodo;
    }
}
