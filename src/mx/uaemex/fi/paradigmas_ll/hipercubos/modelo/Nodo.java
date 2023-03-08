package mx.uaemex.fi.paradigmas_ll.hipercubos.modelo;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

    private String valor;

    public Nodo(int valor) {
        this.valor = obtenerBinario(valor);
    }

    /**
     * Metodo que obtiene el valor binario de un entero
     *
     * @param num Define el numero que sera tranformado a binario
     * @return numero binario al que corresponde el numero de entrada
     */
    private String obtenerBinario(int num) {
        String binario = "";
        while (num > 0 || binario.length() < 4) {
            binario = num % 2 + binario;
            num = (int) num / 2;
        }
        return binario;
    }

    /**
     * Metodo que obtiene numero de unos que tiene el valor binario del nodo
     *
     * @return numero de unos del que consta el valor del nodo
     */
    public int obtenerUnos() {
        char[] val = this.valor.toCharArray();
        int unos = 0;
        for (char e : val) {
            if (e == '1') {
                unos++;
            }
        }
        return unos;
    }

    /**
     * Metodo que verifica que un nodo esta conectado a otro nodo
     *
     * @param nodo Corresponde al nodo del cual se harala verificacion
     * @return retorna falso o verdadero segun el nodo dado este relacionado por
     * una arista
     */
    public boolean verificarNodoAdyacente(Nodo nodo) {
        int unosn1 = this.obtenerUnos();
        int unosn2 = nodo.obtenerUnos();
        List<Integer> dim1 = this.obtenerDimensiones();
        List<Integer> dim2 = nodo.obtenerDimensiones();

        if (unosn2 == unosn1 + 1) {
            int numDim = 0;
            switch (unosn1) {
                case 0:
                    return true;
                case 1:
                    for (Integer i : dim2) {
                        if (this.valor.indexOf(1) == i) {
                            return true;
                        }
                    }
                case 2:
                    for (Integer d1 : dim1) {
                        for (Integer d2 : dim2) {
                            if (d1 == d2) {
                                return true;
                            }
                        }
                    }
                case 3:
                    for (Integer i : dim1) {
                        for (Integer e : dim2) {
                            if (i == e) {
                                numDim++;
                            }
                        }
                    }
                    if (numDim == dim1.size()) {
                        return true;
                    }
                case 4:
                    for (Integer i : dim1) {
                        for (Integer e : dim2) {
                            if (i == e) {
                                numDim++;
                            }
                        }
                    }
                    if (numDim == dim1.size()) {
                        return true;
                    }
            }
        }
        return false;
    }

    /**
     * Metodo que obtiene las dimensiones(posiciones de los "1") en el valor del
     * nodo
     *
     * @return proporciona una lista con las dimensiones de los "1" del valor
     * del nodo
     */
    private List<Integer> obtenerDimensiones() {
        List<Integer> dim = new ArrayList<Integer>();
        int i = 0;
        for (char e : this.valor.toCharArray()) {
            if (e == '1') {
                dim.add(i);
            }
            i++;
        }
        return dim;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = this.obtenerBinario(valor);
    }

    public int getValorEntero() {
        int valor = 0;
        int marcador = this.valor.length() - 1;

        for (char i : this.valor.toCharArray()) {
            if (i == '1') {
                valor += Math.pow(2, marcador);
            }
            marcador--;
        }
        return valor;
    }
}
