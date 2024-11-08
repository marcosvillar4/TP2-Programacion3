package Clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface GrafoTDA {
	public void InicializarGrafo();
	public void AgregarVertice(int v);
	public void EliminarVertice(int v);
	public void AgregarArista(int v1, int v2, int p);
	public void EliminarArista(int v1, int v2);
	public int PesoArista(int v1, int v2);
	public boolean ExisteArista (int v1, int v2);
	public ArrayList<Integer> Vertices();
	public ArrayList<Integer> Vecindario(int nodo);
}
