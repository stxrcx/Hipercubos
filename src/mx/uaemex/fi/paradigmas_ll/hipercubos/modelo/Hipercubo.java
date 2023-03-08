package mx.uaemex.fi.paradigmas_ll.hipercubos.modelo;

public class Hipercubo {

    private Nodo[] nodos = new Nodo[8];
    private Arista[] aristas = new Arista[12];

    public Hipercubo() {
        this.asignarNodos();
        this.establecerAristas();
    }

    public Hipercubo(int in) {
        this.asignarNodos();
        this.establecerAristas();
        this.renombrarNodos(in);
    }

    private void asignarNodos() {
        for (int i = 0; i < 8; i++) {
            this.nodos[i] = new Nodo(i);
        }
    }

    private void renombrarNodos(int valor) {
        for (int i = 0; i < 8; i++) {
            this.nodos[i].setValor(valor);
            valor++;
        }
    }

    private void establecerAristas() {
        int contador = 0;
        int contadorAristas = 0;

        for (Nodo n : nodos) {
            contador++;
            for (int i = contador; i < this.nodos.length; i++) {
                if (n.verificarNodoAdyacente(nodos[i]) == true) {
                    aristas[contadorAristas] = new Arista(n, nodos[i]);
                    contadorAristas++;
                }
            }
        }

    }

    public void verificarAristas() {
        for (Arista a : this.aristas) {
            a.describirArista();
        }
    }

    public void verificarNodos() {
        for (Nodo n : this.nodos) {
            System.out.println(n.getValor());
        }
    }

    public Nodo[] getNodos() {
        return nodos;
    }

}
