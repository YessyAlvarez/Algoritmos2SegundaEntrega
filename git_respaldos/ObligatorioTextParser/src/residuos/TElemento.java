package residuos;

@SuppressWarnings("rawtypes")
public class TElemento extends IElemento {
	
	private String dato;
	private TElemento sig;
	
	
	//Constructor
    public TElemento(String n){
        this.dato=n;
        this.sig=null;
    }

    //Dato
    public void setDato(String d){
        this.dato=d;
    }
    public String getDato(){
        return this.dato;
    }

    //Siguiente
    public void setSig(TElemento s){
        this.sig=s;
    }
    public TElemento getSig(){
        return this.sig;
    }
	

	public TElemento(Comparable unaEtiqueta, TVertice vertice) {
		// TODO Auto-generated constructor stub
	}

}
