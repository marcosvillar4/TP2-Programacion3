import Clases.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/rutas.txt"))) {
            String line = br.readLine();

            ///////////////////////////////////////////////////////////////////////

            GrafoTDA g = new GrafoMA();
            g.InicializarGrafo();

            //Llena el grafo con los vertices
            for (int i = 0; i < 58; i++) {
                g.AgregarVertice(i);
            }

            //Llena el grafo con las aristas
            BufferedReader br2 = new BufferedReader(new FileReader("src/rutas.txt"));
            line = br2.readLine();
            while(line != null) {
                String[] datos = line.split(",");
                g.AgregarArista(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),Integer.parseInt(datos[2]));
                line = br2.readLine();
            }

            ////////////////////////////////////////////////////////////////////////////////

            int[][] m = new int[50][7];
            int[] costosConst = {2300, 1900, 1500, 2000, 2700, 2500, 3000, 500};
            int[] costoEnvioPuerto = {3, 3, 3, 2, 2, 2, 1, 1};

            int volumenEnvio = 10;

            for (int vertex = 0; vertex < 50; vertex++) {
                for (int i = 0; i < 7; i++) {
                    m[vertex][i] = dijkstra.dijkstraDirCost(g, vertex,50 + i) * volumenEnvio + costoEnvioPuerto[i] ;
                }
            }

            for (int[] ints : m) {
                System.out.println(Arrays.toString(ints));
            }

            int[] centros = {0,0,0,0,0,0,0,0};

            System.out.println(Arrays.toString(calc.calcMin(m, costosConst, centros, 0, Integer.MAX_VALUE)));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }




}