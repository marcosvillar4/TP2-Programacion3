import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Rutas"))) {
            String line = br.readLine();
            GrafoTDA g = new GrafoMA();
            g.InicializarGrafo();

            //Llena el grafo con los vertices
            while (line != null) {
                String[] datos = line.split(",");
                if(!g.Vertices().contains(datos[0])) {
                    g.AgregarVertice(Integer.parseInt(datos[0]));
                }
                line = br.readLine();
            }

            //Llena el grafo con las aristas
            BufferedReader br2 = new BufferedReader(new FileReader("src/Rutas"));
            line = br2.readLine();
            while(line != null) {
                String[] datos = line.split(",");
                g.AgregarArista(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),Integer.parseInt(datos[2]));
                line = br2.readLine();
            }

            //Matriz con el camino de los Clientes a los CD
            int [][] m = new int[7][50];
            GrafoTDA g2 = new GrafoMA();
            dijkstra d = new dijkstra();
            for(int i = 0; i < m.length; i++){
                g2 = d.dijkstraFunc(g, i + 50);
                for (int j = 0; j < m[i].length; j++){
                    m[i][j] = g2.PesoArista(i+50,j);
                }
            }

            for(int i = 0; i < m.length; i++){
                for(int j = 0; j < m[i].length; j++){
                    System.out.print(m[i][j] + " ");
                }
                System.out.println();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}