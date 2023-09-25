package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import dominio.Alumno;
import dominio.CicloLectivo;
import dominio.Curso;
import dominio.Dias;
import dominio.Horario;
import dominio.Materia;
import dominio.Nota;
import dominio.Universidad;

public class TestMateria {

	// Chequea las notas y verifica que este promocionada

	@Test
	public void queSePuedaCrearLaMateria() {

		String nombreMateria = "Programacion 2";
		Integer codigoMateria = 123456;

		Materia materia = new Materia(nombreMateria, codigoMateria, Dias.LUNES, Horario.TURNO_MANANA);
		assertEquals(materia.getNombre(), nombreMateria);
		assertEquals(materia.getCodigoMateria(), codigoMateria);
	}

	@Test
	public void verificarQueSePuedaInscribirUnaMateriaEnLaUniversidad() {

		String nombreMateria = "Programacion 2";
		Integer codigoMateria = 123456;

		Materia materia = new Materia(nombreMateria, codigoMateria, Dias.LUNES, Horario.TURNO_MANANA);
		Universidad universidad = new Universidad();
		universidad.registrarMateria(materia);

		Boolean seInscribió = universidad.getMateriasRegistradas().contains(materia);

		assertTrue(seInscribió);
	}

	@Test
	public void verificarQueLaMateriaEstáAprobada() {

		Nota nota = new Nota();
		nota.asignarValorAprimerParcial(10);
		nota.asignarValorAsegundoParcial(10);
		Materia materia = new Materia("Programacion", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		materia.setNota(nota);

		materia.estaPromocionada(nota);

		assertTrue(materia.getIsPromocionada());

	}

	@Test
	public void verificarSiUnaMateriaTieneCorrelativas() {

		Universidad universidad = new Universidad();

		Materia materia = new Materia("Programacion 2", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		Materia materia2 = new Materia("Programacion", 14302, Dias.SABADOS, Horario.TURNO_MANANA);

		universidad.registrarMateria(materia);
		universidad.registrarMateria(materia2);
		universidad.agregarUnaCorrelativaAunaMateria(materia, materia2);

		Boolean correlativaAsignada = materia.getCorrelativas().contains(materia2);

		assertTrue(correlativaAsignada);

	}

	@Test
	public void verificarSiSePuedeEliminarUnaCorrelativas() {

		Universidad universidad = new Universidad();

		Materia materia = new Materia("Programacion 2", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		Materia materia2 = new Materia("Programacion", 14302, Dias.SABADOS, Horario.TURNO_MANANA);

		universidad.registrarMateria(materia);
		universidad.registrarMateria(materia2);
		universidad.agregarUnaCorrelativaAunaMateria(materia, materia2);
		universidad.eliminarCorrelatividad(materia, materia2);

		Boolean correlativaAsignada = materia.getCorrelativas().contains(materia2);

		assertFalse(correlativaAsignada);

	}

	@Test
	public void queSePuedaAgregarUnaComisionAunaMateria() {

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);

		CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Materia materia = new Materia("Programacion", 14302, Dias.LUNES, Horario.TURNO_NOCHE);
		Curso comision = new Curso();

		Boolean sePudoAgregar = materia.agregarComision(cicloLectivo, comision, Horario.TURNO_MANANA);

		assertTrue(sePudoAgregar);

	}

	@Test
	public void queNoSePuedaAgregarUnaComisionAunaMateria() {

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);

		CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Materia materia = new Materia("Programacion", 14302, Dias.LUNES, Horario.TURNO_NOCHE);
		Curso comision = new Curso();

		materia.agregarComision(cicloLectivo, comision, Horario.TURNO_MANANA);
		Boolean noSePudoAgregar = materia.agregarComision(cicloLectivo, comision, Horario.TURNO_MANANA);

		assertFalse(noSePudoAgregar);

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
