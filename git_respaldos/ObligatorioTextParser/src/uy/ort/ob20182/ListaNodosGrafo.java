package uy.ort.ob20182;

@SuppressWarnings("rawtypes")
public class ListaNodosGrafo {
	public NodoGrafo primero;
	public NodoGrafo ultimo;
	public int cantElementos;
	
	/**
	 * Constructor de ListaNodosGrafo
	 */
	public ListaNodosGrafo (){
		this.primero = null;
		this.ultimo = null;
		this.cantElementos = 0;
	}
	
	
	
	public NodoGrafo existeNodoPalabra(Comparable unaPalabra) {
		NodoGrafo first = this.primero;
		return buscarRecursivo(first, unaPalabra);
	}
	
	
	public NodoGrafo buscarRecursivo(NodoGrafo first, Comparable unaPalabra){
		if (first == null)
			return null;
		else if (first.getPalabra().equals(unaPalabra))
			return first;
		else
			return (buscarRecursivo(first.getSiguiente(), unaPalabra));
	}
	
}