package mx.uaemex.fi.paradigmas_ll.hipercubos.modelo;

public class TablaDeVerdad {

    String p;
    String q;

    public TablaDeVerdad(String p, String q) {
        super();
        this.p = p;
        this.q = q;
    }

    public String orExclusivo() {
        String resultado = "";
        for (int i = 0; i < this.p.length(); i++) {
            if (this.p.substring(i, i + 1).equals(this.q.substring(i, i + 1))) {
                resultado += 0;
            } else {
                resultado += 1;
            }
        }
        return resultado;
    }
}
