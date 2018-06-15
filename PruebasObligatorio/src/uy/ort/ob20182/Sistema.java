package uy.ort.ob20182;

import uy.ort.ob20182.Retorno.Resultado;

public class Sistema implements ISistema {

	private GrafoLista ABCpalabras;

	public Retorno inicializarSistema (int maxPalabras) {
		Retorno retorno = new Retorno();
        if(maxPalabras>0){
        	ABCpalabras = new GrafoLista(maxPalabras);
            retorno.resultado = Resultado.OK;
        }else if(maxPalabras<1){
       	 	destruirSistema();
            retorno.resultado = Resultado.ERROR_1;
        }else{
       	 retorno.resultado = Resultado.NO_IMPLEMENTADA;
        }
        return retorno;
	}
	
	public Retorno destruirSistema() {
		Retorno retorno = new Retorno();
		ABCpalabras = null;
		retorno.resultado = Resultado.OK;
		return retorno;
	}

	public Retorno analizarTexto(String texto) {
		Retorno retorno = new Retorno();
		//Verifico que el sistema exista
		if(this.ABCpalabras==null) {
			retorno.resultado = Resultado.NO_IMPLEMENTADA;
		} else if(texto.length()==0) { 	//Verifico que el texto no sea vacio
			retorno.resultado = Resultado.ERROR_1;
		} else {
			//Convierto el texto en minuscula
			texto = texto.toLowerCase();
			//Parseo el texto
			String [] palabras = texto.split("[:.,()?�!� ]");
			int palabrasProcesar = palabras.length;
			for(int i=0; i<palabrasProcesar; i++) {
				//ABCpalabras.insertarElemento(palabras[i]);
			}
			retorno.resultado = Resultado.OK;
		}
		return retorno;
	}

	public Retorno aparicionesPalabra(String palabra) {
		// ToDo: Implementar aqui el metodo
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno predecirPalabra(String palabra) {
		// ToDo: Implementar aqui el metodo
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno repetirFrase(String palabraIni, String palabraFin) {
		// ToDo: Implementar aqui el metodo
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}
	
}
