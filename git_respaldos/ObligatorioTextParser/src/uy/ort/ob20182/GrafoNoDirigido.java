package uy.ort.ob20182;


@SuppressWarnings("rawtypes")
public class GrafoNoDirigido {

	public ListaNodosGrafo nodosGrafo;
	public ListaNodosAristas aristasGrafo;
	
	public GrafoNoDirigido() {
		this.nodosGrafo = new ListaNodosGrafo();
		this.aristasGrafo = new ListaNodosAristas();
	}

	public void crearVertice(Comparable palabra) {
		NodoGrafo nodo = this.nodosGrafo.existeNodoPalabra(palabra);
		if(nodo!=null) {
			nodo.setApariciones();
		}else{
			NodoGrafo nuevoNodo = new NodoGrafo(palabra);
			
			
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
