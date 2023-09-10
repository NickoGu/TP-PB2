package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Materia;
import dominio.Nota;

public class TestMateria {

	// Chequea las notas y verifica que este promocionada

	@Test
	public void queSePuedaCrearLaMateria() {
		
		String nombreMateria =  "Programacion 2";
		Integer codigoMateria = 123456;
		
		
		Materia materia = new Materia(nombreMateria, codigoMateria);
		
		assertEquals(materia.getNombre(), nombreMateria);
		assertEquals(materia.getCodigoMateria(), codigoMateria);
	}

	@Test
	public void verificarQueLaMateriaEstáAprobada() {
		
		
		Nota nota = new Nota(8, 8);
		Materia materia = new Materia("Programacion", 1243);
		
		
		Boolean estaPromocionada = materia.estaPromocionada(nota.getPrimerParcial(), nota.getSegundoParcial());
		
		assertTrue(estaPromocionada);
		
		
		
		
	}

	
	
}
