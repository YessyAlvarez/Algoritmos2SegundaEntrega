package Ejercicio4;

public class NodoAG {
	public Object info;
	public NodoAG primerHijo;
	public NodoAG siguienteHermano;
	
	
	
	// Constructor
	public NodoAG() {
		this.info = null;
		this.primerHijo = null;
		this.siguienteHermano = null;
	}
	
	// Get & Set
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	public NodoAG getPrimerHijo() {
		return this.primerHijo;
	}
	public void setPrimerHijo(NodoAG izq) {
		this.primerHijo = izq;
	}
	public NodoAG getSiguienteHermano() {
		return siguienteHermano;
	}
	public void serSiguienteHermano(NodoAG der) {
		this.siguienteHermano = der;
	}
	
	
	
	
	
}
