import Clases.DFS;
import Clases.GrafoMA;
import Clases.GrafoTDA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        DFS dfs = new DFS();
        try (BufferedReader br = new BufferedReader(new FileReader("src/rutas.txt   "))) {
            String line = br.readLine();
            GrafoTDA g = new GrafoMA();
            g.InicializarGrafo();
            while (line != null) {

                if (!line.equals("156\t#Total de rutas ")) {
                    String[] datos = line.split(",");
                    g.AgregarVertice(Integer.parseInt(datos[0]));
                    g.AgregarArista(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),Integer.parseInt(datos[2]));
                    line = br.readLine();
                }
            }
            GrafoTDA g2 = g;
            Stack caminoCorto = new Stack();
            dfs.caminoCorto(g,42,caminoCorto,0,9999999);
            while(!g2.Vertices().ConjuntoVacio()){
                int v = g2.Vertices().Elegir();
                dfs.caminoCorto(g,v,caminoCorto,0,9999999);
                g2.Vertices().Sacar(v);
//                while(!caminoCorto.isEmpty()){
//                    System.out.println(caminoCorto.PilaVacia());
//                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}