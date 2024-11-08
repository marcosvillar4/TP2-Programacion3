import Clases.GrafoMA;
import Clases.GrafoTDA;
import Clases.dijkstra;

public class dijkstraTest {
    public static void main(String[] args) {
        GrafoTDA g = new GrafoMA();

        g.InicializarGrafo();

        g.AgregarVertice(1);
        g.AgregarVertice(2);
        g.AgregarVertice(3);
        g.AgregarVertice(4);
        g.AgregarVertice(5);
        g.AgregarVertice(6);

        g.AgregarArista(1,2,2);
        g.AgregarArista(1,4,15);
        g.AgregarArista(1,5,6);
        g.AgregarArista(1,6,3);
        g.AgregarArista(2,3,3);
        g.AgregarArista(2,5,2);
        g.AgregarArista(3,4,6);
        g.AgregarArista(5,4,3);
        g.AgregarArista(5,6,1);
        g.AgregarArista(6,4,1);

        System.out.println(g.Vecindario(1));

        GrafoTDA g2 = dijkstra.dijkstraFunc(g, 1);

        for (Integer vertex : g2.Vertices()) {

            if (g2.ExisteArista(1, vertex)) {
                System.out.println("1 -----> " + vertex + ": " + g2.PesoArista(1, vertex));
            }
        }

    }
}