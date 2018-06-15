package uy.ort.ob20182;

public class GrafoLista {
	int size;
	int cantNodos;
	Lista[] ListaAdy;
	boolean[] nodosUsados;
	
	
	public GrafoLista(int cantNodos) {
		this.size=0;
		this.cantNodos = cantNodos;
		this.nodosUsados = new boolean[cantNodos+1];
		this.ListaAdy = new Lista[cantNodos+1];
		for(int i=1; i<=cantNodos; i++) {
			this.ListaAdy[i]=new Lista();
		}
	}
	
	
	public void agregarVertice(int v) {
		this.nodosUsados[v] = true;
		this.size++;
	}
	
	
	public void agregarArista(int vo, int vd, int peso) {
		this.ListaAdy[vo].agregarInicio(vd, peso);
		//this.ListaAdy[vd].agregarInicio(vo, peso);
	}
	
	public void borrarArista(int vo, int vd) {
		this.ListaAdy[vo].eliminar(vd);
		//this.ListaAdy[vd].eliminar(vo);
	}
	
	public void borrarVertice(int v) {
		this.nodosUsados[v] = false;
		this.size--;
		this.ListaAdy[v] = new Lista();
		for(int i=1; i<=this.cantNodos; i++) {
			this.ListaAdy[i].eliminar(v);
		}
	}
	
	
	public boolean esVAcio() {
		return this.size==0;
	}
	
	
	public boolean sonAdyacentes(int vo, int vd) {
		return this.ListaAdy[vo].existe(vd);
	}
	
	
	public boolean existeVertice(int v) {
		return this.nodosUsados[v];
	}
	
	
	public Lista verticesAdyacentes(int v) {
		return this.ListaAdy[v];
	}
	
	
	
	
	
	
	
}
