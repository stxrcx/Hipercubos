package mx.uaemex.fi.paradigmas_ll.hipercubos.modelo;

public class DosHipercubos {

    Hipercubo hipercubo1;
    Hipercubo hipercubo2;
    Arista[] conexion = new Arista[8];

    ;
	
	public DosHipercubos() {
        hipercubo1 = new Hipercubo();
        hipercubo2 = new Hipercubo(8);
        this.conectarCubos();
    }

    private void conectarCubos() {
        Nodo nodos1[] = hipercubo1.getNodos();
        Nodo nodos2[] = hipercubo2.getNodos();
        int numeroConexiones = 0;

        for (int i = 0; i < 8; i++) {
            if (nodos1[i].getValor().substring(1).equals(nodos2[i].getValor().substring(1))) {
                this.conexion[numeroConexiones] = new Arista(nodos1[i], nodos2[i]);
                numeroConexiones++;
            }
        }
    }

    public void verificarConexion() {
        for (Arista a : this.conexion) {
            a.describirArista();
        }
    }

}
