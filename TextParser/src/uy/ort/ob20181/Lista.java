package uy.ort.ob20181;

public class Lista implements ILista {
    private NodoLista inicio;
    private NodoLista fin;

    //Constructor
    public Lista(){
        this.inicio=null;
        this.fin=null;
    }

    //Inicio
    public void setInicio(NodoLista i){
        inicio=i;
    }
    public NodoLista getInicio(){
        return inicio;
    }

    //Fin
    public void setFin(NodoLista f){
        fin=f;
    }
    public NodoLista getFin(){
        return fin;
    }


    /*****Métodos Básicos*****/

    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    public boolean esVacia(){
        if (this.inicio==null)
            return true;
        else
            return false;
      }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    public void agregarInicio(String n){
        NodoLista nuevo= new NodoLista(n);
        nuevo.setSig(inicio);
        this.inicio=nuevo;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=nuevo;
        }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public void agregarFinal(String n){
        //NodoLista nuevo= new NodoLista(n);
        if (this.esVacia())
            this.agregarInicio(n);
        else
        {
            NodoLista aux=this.inicio;
            while (aux.getSig() != null)
                aux=aux.getSig();
            NodoLista nuevo = new NodoLista(n);
            aux.setSig(nuevo);
            this.fin=nuevo;
        }
    }

    //PRE:
    //POS: Borra el primer nodo
    public void borrarInicio(){
        if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
        }
    }

    //PRE:
    //POS: Borra el último nodo
    public void borrarFin(){
        if (!this.esVacia()){
            if (this.inicio==this.fin)
                this.borrarInicio();
            else{
                NodoLista aux = this.inicio;
                while (aux.getSig().getSig() != null)
                    aux=aux.getSig();
                this.fin=aux;
                this.fin.setSig(null);
            }
        }
    }

 //PRE:
    //POS: elimina todos los nodos de una lista dada
    public void vaciar(){
        //en java alcanza con apuntar inicio y fin a null
        //inicio=fin=null;
        while (inicio!=null)
            borrarInicio();
    }

    //PRE:
    //POS: Recorre y muestra los datos de lista
    public void mostrar(){
        if (this.esVacia())
            System.out.println("Lista es vacía");
        else  {
            NodoLista aux=this.inicio;
            while (aux!=null)  {
                System.out.println(aux.getDato());
                aux=aux.getSig();
            }
        }
    }


/*****Otros Métodos (iterativos)*****/

    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public void agregarOrd(String n){
        //lista vacia o primer elemento es mayor o igual => agrego al ppio
        if (this.esVacia() || this.inicio.getDato().equals(n)){
        	//Inserto en la lista la letra
            this.agregarInicio(n);
            
            /*
            
            Arbol letra = new Arbol();
            Nodo nd = new Nodo(n);
            letra.raiz = nd;*/
           // this.inicio.setDato(letra);
        }
        //último elemento es menor o igual => agrego al final
        if (this.fin.getDato().equals(n)){
            this.agregarFinal(n);
            return;
        }
        NodoLista aux=this.inicio;
        while (aux.getSig()!=null && aux.getSig().getDato().equals(n))
            aux=aux.getSig();
        NodoLista nuevo=new NodoLista(n);
        nuevo.setSig(aux.getSig());
        aux.setSig(nuevo);
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(String n){
        if (this.esVacia())
            return;
        if (this.inicio.getDato()==n)
            this.borrarInicio();
        else
        {
            NodoLista aux=this.inicio;
            while (aux.getSig()!=null && aux.getSig().getDato() != n)
                aux=aux.getSig();
            //lo encontré o llegué al final de la lista
            if (aux.getSig()!=null){
                NodoLista borrar=aux.getSig();
                aux.setSig(borrar.getSig());
                borrar.setSig(null);
            }
        }
    }
    
    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos(){
        int cont=0;
        if (!this.esVacia()){
            NodoLista aux=this.inicio;
            while (aux!=null){
                 aux=aux.getSig();
                 cont ++;
            }
        }
        return cont;
    }

    //PRE: //POS:
    public NodoLista obtenerElemento(String n){
        NodoLista aux=this.inicio;
        while (aux!=null && aux.getDato()!=n)
            aux=aux.getSig();
        //encontré dato o llegué al final
        return aux;
    }

    
    /*****  Métodos RECURSIVOS  *****/

    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoLista l){
        if(l!=null){
            System.out.println(l.getDato());
            mostrarREC(l.getSig());
        }
    }

    //PRE:
    //POS: muestra los datos de la lista en orden inverso
    public void mostrarInversoREC(NodoLista l){
        if (l!=null){   
            mostrarInversoREC(l.getSig());
            System.out.println(l.getDato());
        }
    }

    
    //PRE:
    //POS: retorna true si el elemento pertenece a la lista
    public boolean existeDatoREC(NodoLista l, String n){
        if (l != null){
            if (l.getDato()==n)
                return true;
            else
                return existeDatoREC(l.getSig(),n);
        }
        else
             return false;
    }

	@Override
	//PRE:
    //POS: retorna 1 en caso de insertar el elemento y 0 en caso contrario
	public int insertarElemento(String dato) {
		//Elimino todos los espacios vacios que pueda tener adicionales
		dato = dato.replace(" ", "");
		//Consulto el largo del dato
		String empiezaCon = "";
		if(dato.length()>1) {
			empiezaCon = dato.substring(0, 1);
		}
		//1ro verifico si empiezaCon pertenece a la lista sino lo agrego
		NodoLista existeLetra = obtenerElemento(empiezaCon);
		if(existeLetra==null) {
			//Inserto la letra a la lista
			agregarOrd(empiezaCon);
		}
		
		
		
		
	/*	 //lista vacia o primer elemento es mayor o igual => agrego al ppio
        if (this.esVacia() || this.inicio.getDato().compareTo(empiezaCon)<= 0){
            this.agregarInicio(empiezaCon);
            return 0;
        }
        if (this.fin.getNombre().compareTo(n.getNombre())>= 0){   //ùltimo elemento es menor o igual => agrego al final
            this.agregarFinal(n);
            return;
        }
        NodoCrucero aux=this.inicio;
        while (aux.getSig()!=null && aux.getSig().getNombre().compareTo(n.getNombre())< 0){
            NodoCrucero nuevo = new NodoCrucero(n);
            nuevo.setSig(aux.getSig());
            aux.setSig(nuevo);
        }
		
		*/
		
		
		
		return 0;
	}




}