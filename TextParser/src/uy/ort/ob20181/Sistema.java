package uy.ort.ob20181;

import static org.junit.jupiter.api.Assertions.assertEquals;

import uy.ort.ob20181.Retorno.Resultado;


public class Sistema implements ISistema {

	private ABB ABCpalabras;

	public Retorno inicializarSistema (int maxPalabras) {
		Retorno retorno = new Retorno();
        if(maxPalabras>0){
        	ABCpalabras = new ABB();
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
			String [] palabras = texto.split("[:.,()?¿!¡ ]");
			int palabrasProcesar = palabras.length;
			for(int i=0; i<palabrasProcesar; i++) {
				ABCpalabras.insertarElemento(palabras[i]);
			}
			retorno.resultado = Resultado.OK;
		}
		return retorno;
	}

	public Retorno rankingPalabras(int n) {
		Retorno retorno = new Retorno();
		if(this.ABCpalabras==null) {
			retorno.resultado = Resultado.NO_IMPLEMENTADA;
		} else {
			if(n<1) { 	//Verifico que el listado sea al menos de 1
				retorno.resultado = Resultado.ERROR_1;
			} else {
				Lista ranking = ABCpalabras.ObtenerRankingPalabras(n);
				retorno.resultado = Resultado.OK;
				//retorno.valorString = ranking.ObtenerListaRanking();
			}
		}
		return retorno;
	}

	public Retorno aparicionesPalabra(String palabra) {
		// ToDo: Implementar aqui el metodo
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	public Retorno todasPalabras() {
		// ToDo: Implementar aqui el metodo
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}
	
	public ABB miARbol() {
		return ABCpalabras;
	}
	
	
}
