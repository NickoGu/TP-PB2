package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Alumno;
import dominio.Materia;
import dominio.Nota;
import dominio.Universidad;

public class TestMateria {

	// Chequea las notas y verifica que este promocionada

	@Test
	public void queSePuedaCrearLaMateria() {

		String nombreMateria = "Programacion 2";
		Integer codigoMateria = 123456;

		Materia materia = new Materia(nombreMateria, codigoMateria);

		assertEquals(materia.getNombre(), nombreMateria);
		assertEquals(materia.getCodigoMateria(), codigoMateria);
	}

	@Test
	public void verificarQueLaMateriaEstáAprobada() {

		Nota nota = new Nota(8, 8);
		Materia materia = new Materia("Programacion", 1243);
		materia.setNota(nota);

		materia.estaPromocionada(materia.getNota().getPrimerParcial(),
				materia.getNota().getSegundoParcial());

		assertTrue(materia.getIsPromocionada());

	}

	@Test
	public void verificarSiUnaMateriaTieneCorrelativas() {

		Universidad universidad = new Universidad();
		Materia materia = new Materia("Programacion", 123345);
		Materia materia2 = new Materia("Taller Web", 1253);

		universidad.registrarMateria(materia);
		universidad.registrarMateria(materia2);
		universidad.agregarUnaCoorrelativaAunaMateria(materia, materia2);

		Materia correlativaAsignada = materia.getCorrelativas().get(0);
		
		assertNotNull(correlativaAsignada);

	}

//	@Test
//	public void verificarSiAdeudaCorrelativa() {
//
//		Universidad universidad = new Universidad();
//		Nota nota = new Nota(8, 9);
//		Materia materia = new Materia("Programacion", 123345);
//		Materia materia2 = new Materia("Taller Web", 1253);
//		Alumno alumno = new Alumno("Martu", "Pe", 2134);
//
//		universidad.registrarMateria(materia);
//		universidad.agregarUnaCoorrelativaAunaMateria(materia, materia2);
//		materia.setNota(nota);
//
//		Boolean primeraMateriaPromocionada = materia.inscribirAlumno(alumno, materia.getNota().getPrimerParcial(),
//				materia.getNota().getSegundoParcial());
//
//		assertTrue(primeraMateriaPromocionada);
//
//	}

}
