package practico2;

import java.util.ArrayList;
import java.util.LinkedList;

public class GrafoMatriz {

	int size;
	int cantNodos;
	Arco[][] matrizAdy;
	boolean[] nodosUsados;
	
	
	/** CONSTRUCTOR **/
	//CREO GRAFO VACIO SIN NODOS NI ARU=ISTAS CON CAPACIDAD
	//DE ALMACENAMIENTO CANTNODOS VERTICES
	public GrafoMatriz(int cantNodos) {
		this.size = 0;
		this.cantNodos = cantNodos;
		this.nodosUsados = new boolean[cantNodos+1]; //Lo creo con +1 porque no se utiiza la posicion 0
		this.matrizAdy = new Arco[cantNodos+1][cantNodos+1];
		for(int i=1; i<=cantNodos; i++) {
			for(int j=1; j<=cantNodos; j++) {
				matrizAdy[i][j] = new Arco();
			}
		}
		
	}
	
	
	//PRE: v <= cantNodos && v no pertenece al grafo
	//POS: 
	public void agregarVertice(int v) {
		this.nodosUsados[v] = true;
		this.size++;
	}
	
	//vo = vertice origen
	//vd = vertice destino
	public void agregarArista(int vo, int vd, int peso) {
		this.matrizAdy[vo][vd] = new Arco(peso);
		//si el grafo es NO DIRIGIDO agrego el espejo
		//this.matrizAdy[vd][vo] = new Arco(peso);
	}
	
	
	
	public void borrarArista(int vo, int vd) {
		this.matrizAdy[vo][vd] = new Arco();
		//SI EL GRAFO ES NO DIRIGIDO
		//this.matrizAdy[vd][vo] = new Arco();
	}
	
	
	//PRE: el vertice (int v) pertenece al grafo
	public void borrarVertice(int v) {
		this.nodosUsados[v] = false;
		this.size--;
		//Debo borrar TODAS las aristas donde v (int v) es miembro
		for(int i=1; i<=cantNodos; i++) {
			this.matrizAdy[v][i] = new Arco();
			this.matrizAdy[i][v] = new Arco();
		}
	}
	
	
	public boolean esVacio() {
		return this.size==0;
	}
	
	
	public Lista verticesAdyacentes(int v) {
		Lista lista = new Lista();
		for(int i=1; i<=cantNodos; i++) {
			if(sonAdyacentes(v,i)) {
				lista.agregarInicio(i+"");
			}
		}
		return lista;
	}
	
	
	
	public boolean sonAdyacentes(int vo, int vd) {
		return this.matrizAdy[vo][vd].existe;
	}
	
	
	public boolean existeVertice(int v) {
		return this.nodosUsados[v];
	}
	
	
	
	/***	EJERCICIO 3 - PACMAN 	***/
	public int MinMovimientos(GrafoMatriz g, int verticeFantasma, int verticePacMan) {
		if(g.esVacio()) {
			return -1; //el grafo esta vacio
		}else if(g.sonAdyacentes(verticeFantasma, verticePacMan)){ //Verifico si son adyacentes, en caso de cerlo el pacman esta al lado del fantasma
			return 1;
		}else{
			boolean[] marcados = new boolean[g.cantNodos+1];
			int cantMovimientos = 0;
			int nivel = 0;
			Queue colaVertices = new Queue();
			marcados[verticeFantasma] = true;
			colaVertices.Enqueue(verticeFantasma, nivel);
			boolean encontrePacman = false;
			while(!colaVertices.isEmpty() && !encontrePacman) {
				int u = colaVertices.front.vertice;
				nivel  = colaVertices.front.nivel;
				colaVertices.dequeue();
				int i = 1;
				while((i<=g.cantNodos) && (!encontrePacman)) {
					if(g.sonAdyacentes(u, i) && (!marcados[i])) {
						if(i==verticePacMan) {
							encontrePacman = true;
							cantMovimientos = nivel + 1;
						}else{
							marcados[i] = true;
							colaVertices.Enqueue(i, nivel+1);
						}
					}
					i++;
				}
			}
			return cantMovimientos;
		}	
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
