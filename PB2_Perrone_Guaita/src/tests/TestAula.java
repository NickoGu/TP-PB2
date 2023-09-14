package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Aula;

public class TestAula {

	@Test
	public void queCadaVezQueSeCreeUnAulaSeLeAsigneUnNumeroCorrelativo() {
		
		
		Aula aula1 = new Aula();
		Aula aula2 = new Aula();
		Aula aula3 = new Aula();
		
		Integer numDeAulaEsperado = 3;
		Integer numDeAulaObtenido = aula3.getNumAula();
		
		assertEquals(numDeAulaEsperado, numDeAulaObtenido);
			
	}

}
