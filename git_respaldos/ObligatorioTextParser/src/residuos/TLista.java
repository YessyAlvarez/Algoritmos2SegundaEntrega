package residuos;

@SuppressWarnings("rawtypes")
public class TLista {
	
	private TElemento inicio;
    private TElemento fin;

    //Constructor
    public TLista(){
        this.inicio=null;
        this.fin=null;
    }

	public void insertarAlFinal(IElemento elemento) {
		// TODO Auto-generated method stub
		
	}

	public IElemento buscar(Comparable unaEtiqueta) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public TVertice buscarVertice(Comparable unaPalabra) {


		
		return null;
	}

	
	public int cantElementos(){
        int cont=0;
        if (!this.esVacia()){
        	TElemento aux=this.inicio;
            while (aux!=null){
                 aux=aux.getSig();
                 cont ++;
            }
        }
        return cont;
    }
	
	
	public boolean esVacia(){
        if (this.inicio==null)
            return true;
        else
            return false;
      }
	
	
}
