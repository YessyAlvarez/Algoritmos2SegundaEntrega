package Ejercicio5;

public class NodoLista {

	public int dato;
	public int nivel;
	public NodoLista sig;
	
	
	
	public NodoLista(int dato, int nivel) {
		this.dato = dato;
		this.nivel = nivel;
	}
	
	
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public NodoLista getSig() {
		return sig;
	}
	public void setSig(NodoLista sig) {
		this.sig = sig;
	}
	
	
	
	
}
