public class ConjuntoLD implements ConjuntoTDA{

    public class Nodo{
        int info;
        Nodo sig;
    }

    private Nodo c;

    @Override
    public void InicializarConjunto() {
        c = null;
    }

    @Override
    public void Agregar(int x) {
        if(!this.Pertenece(x)){
            Nodo n = new Nodo();
            n.info = x;
            n.sig = c;
            c = n;
        }
    }

    @Override
    public int Elegir() {
        return c.info;
    }

    @Override
    public boolean ConjuntoVacio() {
        return (c == null);
    }

    @Override
    public void Sacar(int x) {
        if(c != null) {
            if(c.info == x) {
                c = c.sig;
            }else {
                Nodo aux = c;
                while(aux.sig != null && aux.sig.info != x)
                    aux = aux.sig;
                if(aux.sig != null)
                    aux.sig = aux.sig.sig;
            }
        }
    }

    @Override
    public boolean Pertenece(int x) {
        Nodo aux = c;
        while(aux != null && aux.info != x)
            aux = aux.sig;
        return (aux != null);
    }
}
