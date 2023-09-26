package tests;

import static org.junit.Assert.*;

import dominio.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestCicloLectivo {

	@Test
	public void queSePuedaCrearUnCicloLectivo() {

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);

		CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		assertNotNull(cicloLectivo);

	}

	@Test
	public void queSePuedaRegistrarUnCicloLectivo() {

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);

		CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Universidad universidad = new Universidad();

		assertTrue(universidad.registrarCicloLectivo(cicloLectivo));

	}

	@Test
	public void queNoSePuedaRegistrarUnCicloLectivoSuperpuesto() {

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);

		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 8, 1);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 11, 20);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 3, 28);

		CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		CicloLectivo cicloLectivo2 = new CicloLectivo(fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);
		Universidad universidad = new Universidad();

		assertTrue(universidad.registrarCicloLectivo(cicloLectivo));
		assertFalse(universidad.registrarCicloLectivo(cicloLectivo2));

	}

}
