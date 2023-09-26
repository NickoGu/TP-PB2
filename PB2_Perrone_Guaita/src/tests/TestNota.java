package tests;

import static org.junit.Assert.*;
import dominio.*;

import org.junit.Test;

public class TestNota {

	@Test
	public void queSePuedaAsignarUnValorAlPrimerParcial() {
		Nota nota = new Nota();

		Integer valorNota = 2;

		nota.asignarValorAprimerParcial(valorNota);
		Integer ve = 2, vo = nota.getPrimerParcial();

		assertEquals(ve, vo);

	}

	@Test
	public void queSePuedaAsignarUnValorAlSegundoParcial() {
		Nota nota = new Nota();

		Integer valorNota = 8;

		nota.asignarValorAsegundoParcial(valorNota);
		Integer ve = 8, vo = nota.getSegundoParcial();

		assertEquals(ve, vo);

	}

	@Test
	public void determinarSiUnParcialSePuedeRecuperar() {
		Nota nota = new Nota();

		Integer valorPrimerParcial = 5;
		Integer valorSegundoParcial = 7;

		nota.asignarValorAprimerParcial(valorPrimerParcial);
		nota.asignarValorAsegundoParcial(valorSegundoParcial);

		assertTrue(nota.estadoRecuperatorio());

	}

	@Test
	public void determinarSiDebeRecuperarPrimerOsegundoParcialLuegoDeChequearSiPuedeIrArecuperatorio() {
		Nota nota = new Nota();

		Integer valorPrimerParcial = 5;
		Integer valorSegundoParcial = 8;

		nota.asignarValorAprimerParcial(valorPrimerParcial);
		nota.asignarValorAsegundoParcial(valorSegundoParcial);

		assertTrue(nota.estadoRecuperatorio());
		assertTrue(nota.recuperarPrimerParcial());
		assertFalse(nota.recuperarSegundoParcial());

	}

	@Test
	public void determinaQueParcialSeRecuperaYleReasignaLaNota() {
		Nota nota = new Nota();

		Integer valorPrimerParcial = 5;
		Integer valorSegundoParcial = 8;
		Integer notaRecuperatorio = 8;

		nota.asignarValorAprimerParcial(valorPrimerParcial);
		nota.asignarValorAsegundoParcial(valorSegundoParcial);

		nota.recuperarParcial(notaRecuperatorio);
		Integer veParcialRecuperado = 8;
		Integer voParcialRecuperado = nota.getPrimerParcial();

		assertEquals(veParcialRecuperado, voParcialRecuperado);

	}

}
