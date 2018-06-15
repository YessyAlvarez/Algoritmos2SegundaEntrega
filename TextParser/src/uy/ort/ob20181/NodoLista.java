package uy.ort.ob20181;

/**
 *
 * @author RC
 */
public class NodoLista{
	private String dato;
	private NodoLista sig;

    //Constructor
    public NodoLista(String n){
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
    public void setSig(NodoLista s){
        this.sig=s;
    }
    public NodoLista getSig(){
        return this.sig;
    }
}
