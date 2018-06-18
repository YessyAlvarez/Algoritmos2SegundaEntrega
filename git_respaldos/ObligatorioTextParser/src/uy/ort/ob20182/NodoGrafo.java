package uy.ort.ob20182;


@SuppressWarnings("rawtypes")
public class NodoGrafo {
	
	
	public NodoGrafo siguiente;
	public Comparable palabra;
	public int apariciones;
	
	
	
	
	public NodoGrafo(Comparable palabra) {
		this.siguiente = null;
		this.palabra = palabra;
		this.apariciones = 1;
	}
	
	
	
	
	
	public void setApariciones() {
		this.apariciones++;
	}
	
	
	public Comparable getPalabra() {
		return this.palabra;
	}

	
	public NodoGrafo getSiguiente() {
		return this.siguiente;
	}
	
	
	
}
