package definicion.grafos.de.lista.adyacencia;

public class Adyacente {
	int destino;
	double peso;
	
	public Adyacente(int codAdy, double p){ 
		destino=codAdy; 
		peso = p; 
	}
	
	public Adyacente() {
		destino = 0; 
		peso = 0; 
	}

	public String toString(){ 
		return destino + "("+ peso + ")"; 
	}
}
