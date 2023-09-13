package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Alumno;
import dominio.Dias;
import dominio.Horario;
import dominio.Materia;
import dominio.Nota;
import dominio.Profesor;
import dominio.Universidad;

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
		Integer dni = 23456712;

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
		Dias dias = null;
		Horario horarios = null;

		Materia materia = new Materia("Programacion", 14302, dias.LUNES, horarios.TURNO_MANANA);
		materia.setNota(nota);
		Alumno alumno = new Alumno(nombre, apellido, dni);

		Universidad universidad = new Universidad();
		universidad.inscribirAlumnoAMateria(alumno, materia);

		Boolean seInscribió = materia.getAlumnos().contains(alumno);

		assertTrue(seInscribió);
	}
	
	
	@Test
	public void verificarQueNoRepitaHorarioYDiaAlInscribirseEnUnaMateria() {

		String nombre = "Nico";
		String apellido = "Guaita";
		Integer dni = 12345678;
		Nota nota = new Nota(5, 10);
		Dias dias = null;
		Horario horarios = null;

		Materia materia = new Materia("Programacion", 14302, dias.LUNES, horarios.TURNO_NOCHE);
		materia.setNota(nota);
		Materia materia2 = new Materia("Inglés", 14302, dias.LUNES, horarios.TURNO_MANANA);
		materia2.setNota(nota);
		Alumno alumno = new Alumno(nombre, apellido, dni);

		Universidad universidad = new Universidad();
		universidad.inscribirAlumnoAMateria(alumno, materia);
		
		if(universidad.verificarHorariosYDias(alumno, materia2) == true) {
			universidad.inscribirAlumnoAMateria(alumno, materia2);
		}
		
		Boolean seInscribió = alumno.getMaterias().contains(materia2);

		assertTrue(seInscribió);
	}
	
	

}
