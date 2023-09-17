package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dominio.Aula;

public class TestAula {

	@Before
	public void setUp() {
		Aula.setCONTADOR_AULAS(1); // Lo que hace es reiniciar el contador para que cada vez que se ejecute un test
									// comience de 1
	}

	@Test
	public void queCadaVezQueSeCreeUnAulaSeLeAsigneUnNumeroCorrelativo() {

		Aula aula1 = new Aula();
		Aula aula2 = new Aula();
		Aula aula3 = new Aula();

		Integer numDeAulaEsperado = 3;
		Integer numDeAulaObtenido = aula3.getNumAula();

		assertEquals(numDeAulaEsperado, numDeAulaObtenido);

	}

	@Test
	public void queCadaVezQueSeCreeUnAulaSeAgregueAutomaticamenteAlaListaYseLeAsigneUnaCapacidad() {
		Aula aula1 = new Aula();
		Aula aula2 = new Aula();
		Aula aula3 = new Aula();

		assertTrue(Aula.getAulas().contains(aula1));
		assertTrue(Aula.getAulas().contains(aula2));
		assertTrue(Aula.getAulas().contains(aula3));

	}

	@Test
	public void queCadaVezQueSeCreeUnAulaSeAsigneUnaCapacidadaRandomMayorQue50YmenorQue250() {
		Aula aula1 = new Aula();
		Aula aula2 = new Aula();
		Aula aula3 = new Aula();
		
		Integer capacidadAula1 = aula1.getCapacidad();
		Integer capacidadAula2 = aula2.getCapacidad();
		Integer capacidadAula3 = aula3.getCapacidad();
		
		assertTrue(capacidadAula1 >= 50 && capacidadAula1 < 250);
		assertTrue(capacidadAula2 >= 50 && capacidadAula2 < 250);
		assertTrue(capacidadAula3 >= 50 && capacidadAula3 < 250);
		
	}

}
