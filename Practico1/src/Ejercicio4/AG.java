package Ejercicio4;

public class AG {
	private NodoAG raiz;
	
	/**
	 *  Ejercicio 4 - a) INSERTAR
	 *  pre: padre pertenece al AG.
	 *  Pos: Inserta el dato pasado como parámetro en el árbol dependiendo directamente de padre.
	**/	
	 public void insertar(String padre, String dato) {
		 
		 
		 
		 
	 }
	
	 /**
	 *  Ejercicio 4 - b) CANTIDAD DE HOJAS
	 *  pre: 
	 *  Pos:  Retorna la cantidad de nodos hoja del AG. 
	 */	
	 public int cantHojasAG() {
		 return cantHojasAG(this.raiz);
	 }
	 
	 public int cantHojasAG(NodoAG nodo) {
		 if(nodo==null) {
			 return 0;
		 } else if(nodo.primerHijo == null){
			 return 1 + cantHojasAG(nodo.siguienteHermano);
		 } else {
			 return cantHojasAG(nodo.primerHijo) + cantHojasAG(nodo.siguienteHermano);
		 } 
	 }
	 
	 
	 /**
	 *  Ejercicio 4 - e) BUSCAR
	 *  pre: 
	 *  Pos:  Retorna un “puntero” al nodo que contiene el dato pasado como parámetro, si éste
	 *  pertenece al AG, sino retorna null.
	 */	
	 public NodoAG buscar(String dato) {
		 return buscar(this.raiz, dato);
	 }
	 
	 public NodoAG buscar(NodoAG nodo, String dato) {
		 if(nodo==null) {
			 return null;
		 } else if(nodo.info.equals(dato)) {
			 return nodo;
		 }
		 NodoAG retorno = buscar(nodo.primerHijo, dato);
		 if(retorno==null) {
			 retorno = buscar(nodo.siguienteHermano, dato);
		 }
		 return retorno;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public boolean esVacia() {
		 if(this.raiz==null) {
			 return false;
		 }else {
			 return true;
		 }
		 
		 
	 }
	 
	 
	 
	public boolean existeDato(String dato) {
		boolean existe = false;
		// Verifico que el arbol no sea nulo
		if(this.esVacia()) {
			return existe;
		}else if(this.raiz.getInfo()==dato) { //Verifico que el padre sea la raiz
			return true;
		}else {
			//Llamo recursivamente
			//existeDato(this.raiz.getSiguienteHermano());
		}
		
		return false;
	}
	
	
}
