package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import dominio.Alumno;
import dominio.Dias;
import dominio.Horario;
import dominio.Materia;
import dominio.Nota;
import dominio.Profesor;
import dominio.Universidad;
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

		String nombre = "Nico";
		String apellido = "Guaita";
		Integer dni = 12345678;
		Nota nota = new Nota(5, 10);
		CicloLectivo cicloLectivo = new CicloLectivo();

		Materia materia = new Materia("Programacion", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		materia.setNota(nota);
		Alumno alumno = new Alumno(nombre, apellido, dni);

		Universidad universidad = new Universidad();
		universidad.inscribirAlumnoAMateria(alumno, materia, LocalDate.of(2023, 2, 25));

		Boolean seInscribió = materia.getAlumnos().contains(alumno);

		assertTrue(seInscribió);
	}

	@Test
	public void verificarQueNoRepitaHorarioYDiaAlInscribirseEnUnaMateria() {

		String nombre = "Nico";
		String apellido = "Guaita";
		Integer dni = 12345678;
		Nota nota = new Nota(5, 10);

		Materia materia = new Materia("Programacion", 14302, Dias.LUNES, Horario.TURNO_NOCHE);
		materia.setNota(nota);
		Materia materia2 = new Materia("Inglés", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		materia2.setNota(nota);
		Alumno alumno = new Alumno(nombre, apellido, dni);

		Universidad universidad = new Universidad();
		universidad.inscribirAlumnoAMateria(alumno, materia, LocalDate.of(2023, 2, 25));

		if (universidad.verificarHorariosYDias(alumno, materia2) == true) {
			universidad.inscribirAlumnoAMateria(alumno, materia2, LocalDate.of(2023, 2, 25));
		}

		Boolean seInscribió = alumno.getMaterias().contains(materia2);

		assertTrue(seInscribió);
	}

	@Test
	public void obtenerMateriasAprobadasParaUnAlumno() {

		String nombre = "Nico";
		String apellido = "Guaita";
		Integer dni = 12345678;
		Nota nota = new Nota(5, 10);
		Nota nota2 = new Nota(10, 10);

		Materia materia = new Materia("Programacion", 14302, Dias.LUNES, Horario.TURNO_NOCHE);
		materia.setNota(nota);
		Materia materia2 = new Materia("Inglés", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		materia2.setNota(nota2);
		Alumno alumno = new Alumno(nombre, apellido, dni);

		Universidad universidad = new Universidad();
		universidad.inscribirAlumnoAuiversidad(alumno);
		
		Integer materiasAprobadas =	universidad.materiasAprobadas(alumno.getDni());
		Integer ve = 1;
		assertEquals(ve, materiasAprobadas);
		
	}

	
	
}
