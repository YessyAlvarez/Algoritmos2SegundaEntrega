package uy.ort.ob20181;

public class ejercicio_1_y_3 {

	public static void main(String[] args) {
		ISistema sis = new Sistema();
		sis.inicializarSistema(200);
		String texto = "Podemos eliminar el requisito requisito de la a ro"; // de la pila manteniendo punteros al padre en cada nodo, # 1 2 3 33 12 258 o hilvanando el árbol. En el caso de usar los hilos, esto permitirá un recorrido inorden grandemente mejorado, aunque recuperar el nodo padre requerido para el recorrido preorden postorden será más lento que un simple algoritmo basado en una pila Para recorrer un árbol hilvanado inorden, de puede hacer algo similar a lo siguiente";
		sis.analizarTexto(texto);
		ABB nuevo = sis.miARbol();
		System.out.println("== INORDER");
		System.out.println("=========================");
		System.out.println(nuevo.inOrden());
		System.out.println("== PREORDER");
		System.out.println("=========================");
		System.out.println(nuevo.preOrden());
		System.out.println("== POSORDER");
		System.out.println("=========================");
		System.out.println(nuevo.postOrden());
		System.out.println("=========================");
		System.out.println("mi raiz es: " + nuevo.raiz.dato);
		nuevo.iiinOrder(nuevo.raiz);
	}

}
