package uy.ort.ob20181;

public interface ILista {

	boolean esVacia();
	void agregarInicio(String n);
	void agregarFinal(String n);
	int insertarElemento(String dato);
	void borrarInicio();
	void borrarFin();
	void vaciar();
	void mostrar();
	void agregarOrd(String n);
	void borrarElemento(String n);
	int cantElementos();
	NodoLista obtenerElemento(String n);
	void mostrarREC(NodoLista l);
	void mostrarInversoREC(NodoLista l);
	boolean existeDatoREC(NodoLista l, String n);
	
	
}