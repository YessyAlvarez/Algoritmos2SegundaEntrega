package Ejercicio5;

public class Lista {

	NodoLista inicio;
	
	
	
	
	public void insertarNodo(int dato, int nivel) {
		NodoLista nuevo = new NodoLista(dato, nivel);
		nuevo.sig = this.inicio;
		this.inicio = nuevo;
	}
	
	
}
