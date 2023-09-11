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

		Boolean estaPromocionada = materia.estaPromocionada(nota.getPrimerParcial(), nota.getSegundoParcial());

		assertTrue(estaPromocionada);

	}

	@Test
	public void verificarSiUnaMateriaTieneCorrelativas() {

		Universidad universidad = new Universidad();
		Materia materia = new Materia("Programacion", 123345);
		Materia materia2 = new Materia("Taller Web", 1253);

		universidad.registrarMateria(materia);
		universidad.asignarCorrelativas(materia, materia2);

		Boolean pudoInscribirCorrelativa = universidad.inscribirCorrelativa(materia, materia2);
		assertTrue(pudoInscribirCorrelativa);

	}

	@Test
	public void verificarSiAdeudaCorrelativa() {

		Universidad universidad = new Universidad();
		Nota nota = new Nota(8, 9);
		Materia materia = new Materia("Programacion", 123345);
		Materia materia2 = new Materia("Taller Web", 1253);
		Alumno alumno = new Alumno("Martu", "Pe", 2134);

		universidad.registrarMateria(materia);
		universidad.asignarCorrelativas(materia, materia2);

		Boolean primeraMateriaPromocionada = materia.inscribirAlumno(alumno, nota.getPrimerParcial(),
				nota.getSegundoParcial());

		assertTrue(primeraMateriaPromocionada);

	}

}
