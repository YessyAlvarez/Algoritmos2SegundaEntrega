package uy.ort.test.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import uy.ort.ob20181.ISistema;
import uy.ort.ob20181.Retorno;
import uy.ort.ob20181.Retorno.Resultado;
import uy.ort.ob20181.Sistema;

class ISistemaJUnit {

	ISistema sis;
	Retorno res;
	
	@Before
	public void setUp() throws Exception {
		sis = new Sistema();
	}

	@Test
	public void testInicializarSistema() {
		sis = new Sistema();
		assertEquals(Resultado.ERROR_1, sis.inicializarSistema(-5).resultado);
		assertEquals(Resultado.ERROR_1, sis.inicializarSistema(-1).resultado);
		assertEquals(Resultado.ERROR_1, sis.inicializarSistema(0).resultado);
		assertEquals(Resultado.OK, sis.inicializarSistema(1).resultado);
	}

	@Test
	public void testDestruirSistema() {
		sis = new Sistema();
		sis.inicializarSistema(1);
		assertEquals(Resultado.OK, sis.destruirSistema().resultado);
		
	}

	@Test
	public void testAnalizarTexto() {
		sis = new Sistema();
		sis.inicializarSistema(20);
		String texto = "";
		assertEquals(Resultado.ERROR_1, sis.analizarTexto(texto).resultado);
		//texto = "hola hola.hola,hola:hola(hola)hola¡hola!hola¿hola?hola";
		texto = "Podemos eliminar el requisito requisito de la pila manteniendo punteros al padre en cada nodo, # 1 2 3 33 12 258 o hilvanando el árbol. En el caso de usar los hilos, esto permitirá un recorrido inorden grandemente mejorado, aunque recuperar el nodo padre requerido para el recorrido preorden postorden será más lento que un simple algoritmo basado en una pila Para recorrer un árbol hilvanado inorden, de puede hacer algo similar a lo siguiente";
		assertEquals(Resultado.OK, sis.analizarTexto(texto).resultado);
	}
	
	
	
	@Test
	public void testRankingPalabras() {
		sis = new Sistema();
		String texto;
		
		sis.inicializarSistema(20);
		assertEquals(Resultado.ERROR_1, sis.rankingPalabras(-5).resultado);
		assertEquals(Resultado.ERROR_1, sis.rankingPalabras(-1).resultado);
		assertEquals(Resultado.ERROR_1, sis.rankingPalabras(0).resultado);
		
		texto = "hola hola.hola,hola:hola(hola)hola¡hola!hola¿hola?hola";			
		sis.analizarTexto(texto);
		assertEquals(Resultado.ERROR_2, sis.rankingPalabras(2).resultado);
		res = sis.rankingPalabras(1);
		assertEquals(Resultado.OK, res.resultado);
		assertTrue(res.valorString.contains("hola;11"));
		
		sis = new Sistema();
		sis.inicializarSistema(20);
		texto = "aaa!ccc aaa ccc.aaa,ggg:ccc!ccc(ddd)eee¡eee!eee¿eee?fff fff fff eee eee fff fff bbb ggg";			
		sis.analizarTexto(texto);
		res = sis.rankingPalabras(5);
		assertEquals(Resultado.OK, res.resultado);
		assertEquals("eee;6|fff;5|ccc;4|aaa;3|ggg;2", res.valorString);
			
	}
/*
	@Test
	public void testAparicionesPalabra() {
		String texto;
		
		sis.inicializarSistema(20);
		
		texto = "aaa!ccc aaa ccc.aaa,ggg:ccc!ccc(ddd)eee¡eee!eee¿eee?fff fff fff eee eee fff fff bbb ggg";			
		sis.analizarTexto(texto);
		assertEquals(Resultado.ERROR_1, sis.aparicionesPalabra("hhh").resultado);
		assertEquals(Resultado.ERROR_1, sis.aparicionesPalabra("ff").resultado);
		assertEquals(Resultado.ERROR_1, sis.aparicionesPalabra("eeee").resultado);
		assertEquals(Resultado.ERROR_1, sis.aparicionesPalabra("").resultado);
		res = sis.aparicionesPalabra("fff");
		assertEquals(Resultado.OK, res.resultado);
		assertEquals(5, res.valorEntero);
		res = sis.aparicionesPalabra("eee");
		assertEquals(Resultado.OK, res.resultado);
		assertEquals(6, res.valorEntero);
		res = sis.aparicionesPalabra("ggg");
		assertEquals(Resultado.OK, res.resultado);
		assertEquals(2, res.valorEntero);
	}

	@Test
	public void testTodasPalabras() {
		String texto;
	
		sis.inicializarSistema(20);
		
		texto = "aaa!ccc aaa ccc.aaa,ggg:ccc!ccc(ddd)eee¡eee!eee¿eee?fff fff fff eee eee fff fff bbb ggg";			
		sis.analizarTexto(texto);
		res = sis.todasPalabras();
		assertEquals(Resultado.OK, res.resultado);
		assertEquals("aaa;3|bbb;1|ccc;4|ddd;1|eee;6|fff;5|ggg;2", res.valorString);
		
	}
*/
}
