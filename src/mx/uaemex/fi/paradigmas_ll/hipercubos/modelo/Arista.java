package mx.uaemex.fi.paradigmas_ll.hipercubos.modelo;

public class Arista {

    private int dimension;
    private Nodo nodo1, nodo2;

    public Arista(Nodo n1, Nodo n2) {
        this.nodo1 = n1;
        this.nodo2 = n2;
        this.establecerDimension();
    }

    private void establecerDimension() {
        char[] valor1 = nodo1.getValor().toCharArray();
        char[] valor2 = nodo1.getValor().toCharArray();
        int dimension = Dimension.CURVA;

        while (valor1[dimension] != valor2[dimension] || dimension == 0) {
            dimension--;
        }
        this.dimension = dimension;
    }

    public void describirArista() {
        System.out.println(nodo1.getValor() + " --- " + nodo2.getValor());
    }

    public int getDimension() {
        return dimension;
    }

}
