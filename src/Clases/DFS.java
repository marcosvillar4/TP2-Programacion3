package Clases;

import java.util.Stack;

public class DFS {
    public Stack caminoCorto(GrafoTDA g, int v1, Stack camino, int sumaPeso, int sumaTotalPeso) {

        if (v1 >= 50 && v1 <= 57)
            return camino;
        ConjuntoTDA visitados = g.Vertices();
        while(!visitados.ConjuntoVacio()){
            int x = visitados.Elegir();
            visitados.Sacar(x);
            if (g.ExisteArista(v1, x) && sumaPeso < sumaTotalPeso){
                sumaPeso += g.PesoArista(v1, x);
                camino.push(x);
                caminoCorto(g, x, camino, sumaPeso, sumaTotalPeso);
            }
        }
        return camino;
    }
}
