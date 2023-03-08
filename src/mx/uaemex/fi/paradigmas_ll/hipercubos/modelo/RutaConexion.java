package mx.uaemex.fi.paradigmas_ll.hipercubos.modelo;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class RutaConexion {

    private Nodo entrada;
    private Nodo destino;
    private String ruta;
    private List<Integer> listDimensiones;
    private List<Nodo> listNodos;
    public String descripcionDim;
    public String descripcionNodos;

    /**
     * Constructor de una ruta de conexion, se utiliza una tabla de verdad para
     * poder saber las ruta correspondiente, inicializa todos los atributos la
     * ruta de conexion
     *
     * @param entrada nodo en el que se iniciara el recorrido
     * @param destino nodo en el que finalizara el recorrido
     */
    public RutaConexion(Nodo entrada, Nodo destino) {
        this.entrada = entrada;
        this.destino = destino;

        TablaDeVerdad tabla = new TablaDeVerdad(this.entrada.getValor(), this.destino.getValor());
        this.ruta = tabla.orExclusivo();
        this.obtenerDimensiones();
        this.describirRuta();
    }

    /**
     * Metodo encargado de obtener las dimensiondes que usara la ruta para
     * llegar a su destino, esto mediante la verificacion de unos en el string
     * de la ruta.
     */
    public void obtenerDimensiones() {
        char[] ruta = this.ruta.toCharArray();
        List<Integer> dimensiones = new ArrayList<Integer>();
        int dim = 3;

        for (char d : ruta) {
            if (d == '1') {
                dimensiones.add(dim);
            }
            dim--;
        }
        this.randomDimensiones(dimensiones);
    }

    /**
     * Metodo que hace que las dimensiones utilizadas esten de forma aleatoria
     * para asi poder dar una ruta aleatoria posteriormente.
     *
     * @param dim recibe una lista de enteros que representan a las dimensiones
     * que tiene la ruta
     */
    private void randomDimensiones(List<Integer> dim) {
        Random rand = new Random();
        List<Integer> dimRandom = new ArrayList<>();

        while (!dim.isEmpty()) {
            dimRandom.add(dim.remove(rand.nextInt(dim.size())));
        }
        this.listDimensiones = dimRandom;
    }

    /**
     * Se encarga de generar los atributos descripcionDim, descripcionNodo y
     * listNodos, esto se hace mediante el recorrido de las lista de dimensiones
     * que posee la ruta de conexion, por cada dimension a recorrer se hace un
     * analisis de los requerimientos para saber a que nodo se dirige el
     * recorrido.
     */
    public void describirRuta() {
        String ruta = "";
        String nodos = "";
        List<Integer> listDim = this.listDimensiones;
        List<Nodo> rutaN = new ArrayList<>();

        Nodo currentNodo = this.entrada;
        Nodo nextNodo;

        rutaN.add(currentNodo);

        while (!listDim.isEmpty()) {
            switch (listDim.remove(0)) {
                case Dimension.HORIZONTAL:
                    ruta += "HORIZONTAL\n";
                    if (currentNodo.getValorEntero() % 2 == 0) {
                        nodos += " - " + (currentNodo.getValorEntero() + 1);
                        nextNodo = new Nodo(currentNodo.getValorEntero() + 1);
                        rutaN.add(nextNodo);
                        currentNodo = nextNodo;
                    } else {
                        nodos += " - " + (currentNodo.getValorEntero() - 1);
                        nextNodo = new Nodo(currentNodo.getValorEntero() - 1);
                        rutaN.add(nextNodo);
                        currentNodo = nextNodo;
                    }
                    break;

                case Dimension.VERTICAL:
                    ruta += "VERTICAL\n";
                    if (currentNodo.getValorEntero() < 4 || (currentNodo.getValorEntero() > 7 && currentNodo.getValorEntero() < 12)) {
                        nodos += " - " + (currentNodo.getValorEntero() + 4);
                        nextNodo = new Nodo(currentNodo.getValorEntero() + 4);
                        rutaN.add(nextNodo);
                        currentNodo = nextNodo;
                    } else {
                        nodos += " - " + (currentNodo.getValorEntero() - 4);
                        nextNodo = new Nodo(currentNodo.getValorEntero() - 4);
                        rutaN.add(nextNodo);
                        currentNodo = nextNodo;
                    }
                    break;

                case Dimension.CURVA:
                    ruta += "CURVA\n";
                    if (currentNodo.getValorEntero() < 8) {
                        nodos += " - " + (currentNodo.getValorEntero() + 8);
                        nextNodo = new Nodo(currentNodo.getValorEntero() + 8);
                        rutaN.add(nextNodo);
                        currentNodo = nextNodo;
                    } else {
                        nodos += " - " + (currentNodo.getValorEntero() - 8);
                        nextNodo = new Nodo(currentNodo.getValorEntero() - 8);
                        rutaN.add(nextNodo);
                        currentNodo = nextNodo;
                    }
                    break;

                case Dimension.DIAGONAL:
                    ruta += "DIAGONAL\n";
                    if (currentNodo.getValorEntero() == 0
                            || currentNodo.getValorEntero() == 1
                            || currentNodo.getValorEntero() == 4
                            || currentNodo.getValorEntero() == 5
                            || currentNodo.getValorEntero() == 8
                            || currentNodo.getValorEntero() == 9
                            || currentNodo.getValorEntero() == 12
                            || currentNodo.getValorEntero() == 13) {
                        nodos += " - " + (currentNodo.getValorEntero() + 2);
                        nextNodo = new Nodo(currentNodo.getValorEntero() + 2);
                        rutaN.add(nextNodo);
                        currentNodo = nextNodo;
                    } else {
                        nodos += " - " + (currentNodo.getValorEntero() - 2);
                        nextNodo = new Nodo(currentNodo.getValorEntero() - 2);
                        rutaN.add(nextNodo);
                        currentNodo = nextNodo;
                    }
                    break;
            }
        }
        this.descripcionNodos = nodos;
        this.descripcionDim = ruta;
        this.listNodos = rutaN;
    }

    public String getRutaDescripcion() {
        return this.descripcionDim;
    }

    public String getDescripcionNodos() {
        return this.descripcionNodos;
    }

    public List<Nodo> getRutaNodos() {
        return this.listNodos;
    }

    public List<Integer> getDimensiones() {
        return listDimensiones;
    }

    public String getRuta() {
        return ruta;
    }

    public Nodo getEntrada() {
        return entrada;
    }

    public Nodo getDestino() {
        return destino;
    }

}
