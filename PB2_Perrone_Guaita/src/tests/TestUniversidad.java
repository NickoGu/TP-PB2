package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import dominio.*;

public class TestUniversidad {

	@Test
	public void verificarQueSePuedaInscribirAlumnoEnUniversidad() {

		String nombre = "Martina";
		String apellido = "Perrone";
		Integer dni = 46119380;

		Alumno alumno = new Alumno(nombre, apellido, dni);
		Universidad universidad = new Universidad();
		universidad.inscribirAlumnoAuiversidad(alumno);

		Boolean seInscribió = universidad.getAlumnosInscriptos().contains(alumno);

		assertTrue(seInscribió);
	}

	@Test
	public void verificarQueSePuedaInscribirProfesorEnUniversidad() {

		String nombre = "Andres";
		Integer dni = 46119380;

		Profesor profesor = new Profesor(nombre, dni);
		Universidad universidad = new Universidad();
		universidad.inscribirProfesor(profesor);

		Boolean seInscribió = universidad.getProfesores().contains(profesor);

		assertTrue(seInscribió);
	}

	@Test
	public void verificarQueSePuedaInscribirAlumnoEnMateria() {

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);

		CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		String nombre = "Nico";
		String apellido = "Guaita";
		Integer dni = 12345678;
		Nota nota = new Nota();

		Materia materia = new Materia("Programacion", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		materia.setNota(nota);
		Alumno alumno = new Alumno(nombre, apellido, dni);

		Universidad universidad = new Universidad();
		universidad.inscribirAlumnoAMateria(alumno, materia, cicloLectivo, LocalDate.of(2023, 2, 25));

		Boolean seInscribió = materia.getAlumnos().contains(alumno);

		assertTrue(seInscribió);
	}

	@Test
	public void verificarQueNoRepitaHorarioYDiaAlInscribirseEnUnaMateria() {

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);

		CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		String nombre = "Nico";
		String apellido = "Guaita";
		Integer dni = 12345678;
		Nota nota = new Nota();

		Materia materia = new Materia("Programacion", 14302, Dias.LUNES, Horario.TURNO_NOCHE);
		materia.setNota(nota);
		Materia materia2 = new Materia("Inglés", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		materia2.setNota(nota);
		Alumno alumno = new Alumno(nombre, apellido, dni);

		Universidad universidad = new Universidad();
		universidad.inscribirAlumnoAMateria(alumno, materia, cicloLectivo, LocalDate.of(2023, 2, 25));

		if (universidad.verificarHorariosYDias(alumno, materia2) == true) {

			universidad.inscribirAlumnoAMateria(alumno, materia2, cicloLectivo, LocalDate.of(2023, 2, 25));
		}

		Boolean seInscribió = alumno.getMaterias().contains(materia2);

		assertTrue(seInscribió);
	}

//TODO: FALTA HACER ESTE METODO:

	@Test
	public void queSePuedaInscribirAlumnoAlaComision() {
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);
		String nombre = "Nico";
		String apellido = "Guaita";
		Integer dni = 12345;

		Universidad universidad = new Universidad();
		Materia materia = new Materia("Programacion 2", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		Materia materia2 = new Materia("Programacion", 14302, Dias.SABADOS, Horario.TURNO_MANANA);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Curso comision = new Curso(materia);
		Alumno alumno = new Alumno(nombre, apellido, dni);

		materia.agregarComision(cicloLectivo, comision, Horario.TURNO_MANANA);
		universidad.registrarMateria(materia);
		universidad.registrarMateria(materia2);
		universidad.agregarUnaCorrelativaAunaMateria(materia, materia2);
	}

	@Test
	public void queSePuedaRegistrarUnaNota() {

		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);
		String nombre = "Nico";
		String apellido = "Guaita";
		Integer dni = 12345;
		Universidad universidad = new Universidad();
		Materia materia = new Materia("Programacion 2", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		Curso comision = new Curso(materia);
		CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Alumno alumno = new Alumno(nombre, apellido, dni);
		Nota nota = new Nota();
		
		
		universidad.inscribirAlumnoAuiversidad(alumno);
		universidad.registrarMateria(materia);
		materia.agregarComision(cicloLectivo, comision, Horario.TURNO_MANANA);
		universidad.inscribirAlumnoAMateria(alumno, materia, cicloLectivo, LocalDate.of(2023, 3, 20));
		universidad.inscribirAlumnoAComision(alumno, materia, comision, cicloLectivo, LocalDate.of(2023, 3, 20));
		nota.asignarValorAprimerParcial(2);
		nota.asignarValorAsegundoParcial(2);
		universidad.registrarNota(alumno.getDni(), comision.getCodigoComision(), nota);
		
	
		Integer ve = 2;
		Curso comisionEncontrada = null;
		for (int i = 0; i < alumno.getComisiones().size(); i++) {
			if (alumno.getComisiones().get(i).equals(comision)) {
				comisionEncontrada = alumno.getComisiones().get(i);
				break;
			}
		}

		Integer notaEncontrada = comisionEncontrada.getMateria().getNota().getPrimerParcial();

		assertEquals(ve, notaEncontrada);
	}

	@Test
	public void obtenerMateriasAprobadasParaUnAlumno() {
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);

		String nombre = "Nico";
		String apellido = "Guaita";
		Integer dni = 12345678;
		Nota nota = new Nota();

		nota.asignarValorAprimerParcial(8);
		nota.asignarValorAsegundoParcial(9);

		Materia materia = new Materia("Programacion", 14302, Dias.LUNES, Horario.TURNO_NOCHE);

		Materia materia2 = new Materia("Inglés", 14302, Dias.LUNES, Horario.TURNO_MANANA);

		Alumno alumno = new Alumno(nombre, apellido, dni);
		Curso comision = new Curso(materia);

		CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Universidad universidad = new Universidad();
		universidad.inscribirAlumnoAuiversidad(alumno);
		universidad.inscribirAlumnoAMateria(alumno, materia, cicloLectivo, LocalDate.of(2023, 2, 25));
		universidad.inscribirAlumnoAMateria(alumno, materia2, cicloLectivo, LocalDate.of(2023, 2, 25));
		materia.agregarComision(cicloLectivo, comision, Horario.TURNO_NOCHE);
		universidad.inscribirAlumnoAComision(alumno, materia, comision, cicloLectivo, LocalDate.of(2023, 1, 2));
		universidad.registrarNota(alumno.getDni(), comision.getCodigoComision(), nota);
		

		

		
		
		ArrayList<Materia> materiasAprobadas = universidad.materiasAprobadas(alumno.getDni());
		assertEquals(1, materiasAprobadas.size());

	}

}
