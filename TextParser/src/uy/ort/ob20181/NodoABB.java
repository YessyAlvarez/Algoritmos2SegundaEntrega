package uy.ort.ob20181;

public class NodoABB {

	int cantidad;
	String dato;
	NodoABB izq;
	NodoABB der;
	
	
	/**	CONSTRUCTOR **/
	public NodoABB(String nuevaPalabra){
        this.cantidad = 1;
        this.dato = nuevaPalabra;
        this.izq = null;
        this.der = null;
     }

	/**	SET & GET **/
	public String getDato() {
		return this.dato;
	}
	public void setDato(String nuevoDato) {
		this.dato = nuevoDato;
	}
	public int getCantidad() {
		return this.cantidad;
	}
	public void setCantidad() {
		this.cantidad++;
	}
	public NodoABB getIzq() {
		return this.izq;
	}
	public void setIzq(NodoABB izq) {
		this.izq = izq;
	}
	public NodoABB getDer() {
		return this.der;
	}
	public void setDer(NodoABB der) {
		this.der = der;
	}
	
	/**	METODOS **/
	public void InsertarOrdenado(NodoABB unaPalabra){
		if (this.dato.compareToIgnoreCase(unaPalabra.getDato())==0) { //Ya está en el árbol
			this.cantidad++;
		}else if (this.dato.compareToIgnoreCase(unaPalabra.getDato())<0){
        	if(this.der == null) {
            	this.setDer(unaPalabra);
            }else{
            	this.der.InsertarOrdenado(unaPalabra);
            }
        }else{
        	if(this.izq == null) {
            	this.setIzq(unaPalabra);
            }else{
            	this.izq.InsertarOrdenado(unaPalabra);
            }
        }
	}
	
	
	/**
	 * Método recursivo para retornar los elementos en inOrden.
	 */
	public String inOrden(){
		String inorden = "";
		
		if (this.izq != null)
			inorden += this.izq.inOrden();
		
		inorden += this.dato + " - ";
		
		if (this.der != null)
			inorden += this.der.inOrden();
		
		return inorden;
	}
	
	/**
	 * Método recursivo para retornar los elementos en preOrden.
	 */
	public String preOrden(){
		String preorden = "";
		
		preorden += this.dato + " - ";
		
		if (this.izq != null)
			preorden += this.izq.preOrden();
			
		if (this.der != null)
			preorden += this.der.preOrden();
		return preorden;
	}
	
	/**
	 * Método recursivo para retornar los elementos en postOrden.
	 */
	public String postOrden(){
		String postorden = "";
		
		if (this.izq != null)
			postorden += this.izq.postOrden();
		
		if (this.der != null)
			postorden += this.der.postOrden();
		
		postorden += this.dato + " - ";
		
		return postorden;
	}
	
	
}
