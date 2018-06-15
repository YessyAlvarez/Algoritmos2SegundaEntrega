package Ejercicio5;

public class NodoABB {

	int dato;
	NodoABB izq;
	NodoABB der;
	
	public NodoABB(int n){
        dato = n;
        izq = null;
        der = null;
     }

    public NodoABB(int n, NodoABB i, NodoABB d){
        dato = n;
        izq = i;
        der = d;
     }
	
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public NodoABB getIzq() {
		return izq;
	}
	public void setIzq(NodoABB izq) {
		this.izq = izq;
	}
	public NodoABB getDer() {
		return der;
	}
	public void setDer(NodoABB der) {
		this.der = der;
	}
	
	
	
	
	
	
	
}
