package Ejercicio1_y_3;

public class ABB {
	
	NodoABB raiz;
	
	
	public ABB() {
		this.raiz = null;
	}
		
	public NodoABB getRaiz() {
		return raiz;
	}

    public boolean esArbolVacio() {
		return (raiz == null) ;
	}

    public void mostrarPreOrder(){
    	mostrarPreOrder(this.raiz);
    }
    public void mostrarPreOrder(NodoABB a){
        if (a!=null){
            System.out.print(a.getDato()+"   ");
            mostrarPreOrder(a.getIzq());
            mostrarPreOrder(a.getDer());
        }
    }
    
    public int cantNodos1(NodoABB nodo) {
		int cont = 0;
		if(nodo != null)
        {
			cont += cantNodos1(nodo.getIzq()); 	//cuenta subarbol izquierdo
			cont++; 							// contabilizar el nodo visitado
			cont += cantNodos1(nodo.getDer());	//cuenta subarbol derecho
            
		}
		return cont;
	}

	
	
	
	public int cantNodos() {
		return cantNodos(this.raiz);
		
	}
	
	public int cantNodos(NodoABB nodo) {
		int cant=0;
		if(nodo!=null) {
			cant += cantNodos(nodo.izq);
			cant++;
			cant += cantNodos(nodo.der);
		}
		return cant;		
	}
	
	
	
	public int cantHojas() {
		return cantHojas();
	}
	
	
	public int cantHojas2(NodoABB nodo) {
		int cant = 0;
		if(nodo!=null) {
			cant += cantHojas2(nodo.izq);
			if(nodo.izq!= null && nodo.der!=null) {
				cant++;
			}
		}
		return cant;
	}
	
	
	int cantHojas(NodoABB nodo) {
		if(nodo==null) {
			return 0;
		} else if(nodo.izq==null && nodo.der==null) {
			return 1;
		} else {
			return cantHojas(nodo.izq) + cantHojas(nodo.der);
		}
	}
	
	
	
	/**
	 *  Ejercicio 1 - d) ALTURA
	 *  Pos: Retorna la altura del AB. 
	**/
	boolean altura() {
		
		
		
		
		
		
		return true;
	}
	
	
	
	
	
	/**
	 *  Ejercicio 1 - e) 
	 *  Pos: Retorna true sii todos los elementos del AB son pares.
	**/
	boolean todosPares() {
		return todosPares(this.raiz);
	}
	
	
	boolean todosPares(NodoABB nodo) {
		if(nodo==null) {
			return true;
		}else if(nodo.dato %2 ==0) {
			return (todosPares(nodo.izq) && todosPares(nodo.der));
		}else {
			return false;
		}
	}
	
	
	/**
	 *  Ejercicio 1 - f) 
	 *  POS: Retorna true sii el arbol binario a es igual al arbol binario b.
	 *  ! Dos arboles son iguales si son vacios o si tienen los mismos elementos y en el mismo orden.
	**/
	boolean iguales(ABB a, ABB b) {
		return iguales(a.raiz, b.raiz);		
	}
		
	
	boolean iguales(NodoABB a, NodoABB b) {
		if(a==null && b==null) {
			return true;
		} else if(a==null || b==null) {
				return false;
		} else if(a.dato == b.dato){
			return iguales(a.izq, b.izq) && iguales(a.der, b.der);
		} else {
			return false;	
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 *  Ejercicio 3 - a) INSERTAR
	 *  Pos: Inserta el dato pasado como parámetro en el árbol manteniéndolo ordenado.
	**/	
	public void insertar(int x) {
        this.raiz = insertar(x, this.raiz);
    }
	
    public NodoABB insertar(int x, NodoABB nodo) {
        if(nodo == null) {
            nodo = new NodoABB(x);
        }else if(nodo.dato > x) {
        	nodo.izq = insertar(x,nodo.izq);
        }else if(nodo.dato<x) {
        	nodo.der = insertar(x,nodo.der);
        }
        return nodo;
    }

	
    /**
	 *  Ejercicio 3 - b) BORRAR MINIMO
	 *  Pos: Elimina el menor elemento del ABB
	**/	
	public void borrarMinimo() {
		this.raiz = borrarMinimo(this.raiz);
	}
    
	/**	soluci[on recursiva **/
	public NodoABB borrarMinimo(NodoABB nodo) {
		if(nodo==null) {
			return null;
		}else if(nodo.izq !=null) {
			nodo.izq = borrarMinimo(nodo.izq);
			return nodo;
		}else {
			return nodo.der;
		}
		
	}
    
	/**	solucion NO recursiva **/
    public NodoABB borrarMinimoNoRecursivo(NodoABB nodo) {
    	while(nodo.izq.izq!=null) {
    		nodo = nodo.izq;
    	}
    	nodo.izq = nodo.izq.der;
    	return nodo;
    }
    
    
    
    /**
	 *  Ejercicio 3 - c) BORRAR ELEMENTO
	 *  pre: el elemento x pasado por parametro pertenece al ABB
	 *  Pos: Elimina el elemento x del ABB, manteniendolo ordenado
	**/	
    public void borrarElemento(int x) {
    	this.raiz = borrarElemento(x, this.raiz);
    }
	
	private NodoABB borrarElemento(int x, NodoABB nodo) {
		if(nodo==null) {
			return null;
		}else if(x < nodo.dato) {
			nodo.izq = borrarElemento(x, nodo.izq);
			return nodo.izq;
		}else if(x > nodo.dato) {
			nodo.der = borrarElemento(x, nodo.der);
			return nodo.der;
		}else{
			if(nodo.izq!=null && nodo.der!=null) {
				//Utilizamos el nodo de la rama derecha
				nodo.dato = retornarYborrarMinimo(nodo.der);
			}else if(nodo.izq==null) {
				nodo = nodo.der;
			}else {
				nodo = nodo.izq;
			}
			return nodo;
		}
	}
	
	
	public int retornarYborrarMinimo(NodoABB nodo) {
		int valorNodo = 0;
		if(nodo==null) {
			return valorNodo;
		}else if(nodo.izq !=null) {
			valorNodo = nodo.izq.dato;
			nodo.izq = borrarMinimo(nodo.izq);
			return valorNodo;
		}else {
			valorNodo = nodo.der.dato;
			return valorNodo;
		}
		
	}
	
	
	
	/**
	 *  Ejercicio 3 - d) PERTENECE
	 *  Pos: Retorna true sii el dato pasado como parámetro pertenece al ABB. 
	**/	
    public boolean pertenece(int x) {
    	return pertenece(x, this.raiz);
    }
	
    public boolean pertenece(int x, NodoABB nodo) {
    	if(nodo==null) {
    		return false;
    	}else if(nodo.dato==x) {
    		return true;
    	}else if(nodo.dato<x) {
    		return pertenece(x, nodo.der);
    	}else {
    		return pertenece(x, nodo.izq);
    	}
    }
	
	
	
	/**
	 *  Ejercicio 3 - e) LISTAR ASCENDENTE
	 *  Pos: Lista en pantalla los lelementos del ABB ordenados de menor a mayor
	**/	
	public void listarAscendente() {
		listaAscendente(this.raiz);
	}
	
	private void listaAscendente(NodoABB nodo) {
		if(nodo!=null) {
			listaAscendente(nodo.izq);
			System.out.println(nodo.dato);
		}
	}
	
	
	/**
	 *  Ejercicio 3 - f) LISTAR DESCENDENTE
	 *  Pos: Lista en pantalla los lelementos del ABB ordenados de mayor a menor
	**/	
	public void listarDescendente() {
		listarDescendente(this.raiz);
	}
	
	private void listarDescendente(NodoABB nodo) {
		if(nodo!=null) {
			System.out.println(nodo.dato);
			listarDescendente(nodo.izq);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}