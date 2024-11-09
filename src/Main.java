import Clases.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

import static java.lang.Integer.MAX_VALUE;

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

            for (int vertex = 0; vertex < 50; vertex++) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(vertex+1 + " ----> " + (i + 50) + ": " + (dijkstra.dijkstraDirCost(g, vertex, 50+i) + costoEnvioPuerto[i]) * 10);
                    m[vertex][i] = dijkstra.dijkstraDirCost(g, vertex,50 + i) * 10 + costoEnvioPuerto[i] ;
                }
            }

            System.out.println(dijkstra.dijkstraDirCost(g, 0, 50));

            for (int[] ints : m) {
                System.out.println(Arrays.toString(ints));
            }

            int[] centros = {0,0,0,0,0,0,0,0};
            int minU = Integer.MAX_VALUE;

            System.out.println(Arrays.toString(calc.calcMin(m, costosConst, centros, 0, minU)));


            /*//Matriz con el camino de los Clientes a los CD
            int [][] m = new int[7][50];
            GrafoTDA g2 = new GrafoMA();



            for(int i = 0; i < m.length; i++){
                g2 = dijkstra.dijkstraFunc(g, i + 50);
                for (int j = 0; j < m[i].length; j++){
                    m[i][j] = g2.PesoArista(i+50,j);
                }
            }*/




            /*for(int i = 0; i < m.length; i++){
                for(int j = 0; j < m[i].length; j++){
                    System.out.print(m[i][j] + " ");
                }
                System.out.println();
            }*/
        } catch(IOException e) {
            e.printStackTrace();
        }
    }




}