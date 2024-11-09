package Clases;

import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.Integer.MAX_VALUE;

public class dijkstra {
    public static GrafoTDA dijkstraFunc(GrafoTDA g, int v){
        ArrayList<Integer> Visitados = new ArrayList();
        Visitados.add(v);
        GrafoTDA resp = new GrafoMA();

        resp.InicializarGrafo();
        for (Integer vertex : g.Vertices()) {
            resp.AgregarVertice(vertex);
        }
        for (Integer i : g.Vecindario(v)) {
            resp.AgregarArista(v, i, g.PesoArista(v, i));
        }

        ArrayList<Integer> Candidatos = new ArrayList<>();
        for (Integer vertex : g.Vertices()) {
            if (!Visitados.contains(vertex)){
                Candidatos.add(vertex);
            }
        }

        while (!Candidatos.isEmpty()){
            int min = MAX_VALUE;
            int w = 0;
            for (Integer candidato : Candidatos) {
                if (resp.ExisteArista(v, candidato) && resp.PesoArista(v, candidato) < min){
                    min = resp.PesoArista(v, candidato);
                    w = candidato;
                }
            }

            Visitados.add(w);
            Candidatos.remove(Candidatos.indexOf(w));

            ArrayList<Integer> auxCandidatos = (ArrayList<Integer>) Candidatos.clone();
            while (!auxCandidatos.isEmpty()){
                int p = auxCandidatos.getFirst();
                auxCandidatos.removeFirst();
                if (g.ExisteArista(w,p)){
                    if (resp.ExisteArista(v,p)){
                        if (resp.PesoArista(v,w) + g.PesoArista(w, p) < resp.PesoArista(v, p)){
                            resp.AgregarArista(v, p, resp.PesoArista(v,w) + g.PesoArista(w, p));
                        }
                    } else {
                        resp.AgregarArista(v,p, resp.PesoArista(v,w) + g.PesoArista(w, p));
                    }
                }
            }
        }

        return resp;
    }
}
