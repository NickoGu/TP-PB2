package tests;

import dominio.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestCurso {

	@Test
	public void queCuandoSeCreeUnCursoSeLeAsigneUnNumeroDeComision() {

		Curso curso = new Curso();
		Curso curso2 = new Curso();
		Curso curso3 = new Curso();
		Curso curso4 = new Curso();

		Integer ve = 4;
		Integer vo = curso4.getCodigoComision();

		assertEquals(ve, vo);

		// crear un curso donde

		// Hay aulas de 5, 10 y 15 alumnos

		// si el curso al que se le va asignar el aula tiene menos o igual alumnos se
		// puede asignar

		// alumnos(cursos, materias, dias, horarios, aulas) || materia (a la cual se
		// inscriben los alumnos) || curso(se le asigna a la materia y depende de la
		// capacidad
		// del aula) || aula(contiene curso, materia y alumnos)
		// No se le puede asignar 2 comisiones para la misma materia, el mismo ciclo
		// lectivo y el mismo turno

	}

	@Test
	public void queSeLeAsigneUnCursoAunaMateriaYalumnoCorrectmente() {

		Universidad uni = new Universidad();
		Curso curso = new Curso(), curso2 = new Curso(), curso3 = new Curso(), curso4 = new Curso();
		Materia pb1 = new Materia("PB2", 321, Dias.LUNES, Horario.TURNO_MANANA);
		CicloLectivo cicloLectivo = new CicloLectivo();
		Alumno alum1 = new Alumno("Martina", "Perrone", 1111), alum2 = new Alumno("Martina", "Perrone", 333),
				alum3 = new Alumno("Martina", "Perrone", 333);
		
		uni.inscribirAlumnoAMateria(alum1, pb1);
		uni.inscribirAlumnoAMateria(alum2, pb1);
		uni.inscribirAlumnoAMateria(alum3, pb1);

		assertTrue(uni.asignarCursoAmateriaYalumno(pb1, alum3,cicloLectivo));

	}

	@Test
	public void queNoSeLePuedaAsignarUnCursoAunaMateriaYalumnoCorrectmente() {

		Universidad uni = new Universidad();
		Curso curso = new Curso(), curso2 = new Curso(), curso3 = new Curso(), curso4 = new Curso();

		assertTrue(uni.asignarCursoAmateriaYalumno());

	}

}
