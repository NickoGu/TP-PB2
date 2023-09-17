package tests;

import dominio.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCurso {

	@Before
	public void setUp() {
		Curso.setCONTADOR_MATERIAS(1);
		// Lo que hace es reiniciar el contador para que cada vez que se ejecute un test
		// comience de 1
	}

	@Test
	public void queCuandoSeCreeUnCursoSeLeAsigneUnNumeroDeComision() {

		Curso curso = new Curso();
		Curso curso2 = new Curso();
		Curso curso3 = new Curso();
		Curso curso4 = new Curso();

		Integer ve = 4;
		Integer vo = curso4.getCodigoComision();

		assertEquals(ve, vo);

	}

	@Test
	public void queSeLeAsigneUnCursoAunaMateriaYalumnoCorrectmente() {

		// Primero creo la universidad
		Universidad uni = new Universidad();
		// Luego inscribo alumnos en la uni
		// Luego resgistro materias
		// Luego inscribo alumnos en materias
		// Luego creo las aulas
		//

		Curso curso = new Curso(), curso2 = new Curso(), curso3 = new Curso(), curso4 = new Curso();
		Materia pb1 = new Materia("PB2", 321, Dias.LUNES, Horario.TURNO_MANANA);
		CicloLectivo cicloLectivo = new CicloLectivo();
		Alumno alum1 = new Alumno("Martina", "Perrone", 1111), alum2 = new Alumno("Martina", "Perrone", 333),
				alum3 = new Alumno("Martina", "Perrone", 333);

		uni.inscribirAlumnoAMateria(alum1, pb1);
		uni.inscribirAlumnoAMateria(alum2, pb1);
		uni.inscribirAlumnoAMateria(alum3, pb1);

		assertTrue(uni.asignarCursoAmateriaYalumno(pb1, alum3, curso2));

	}

//	@Test
//	public void queNoSeLePuedaAsignarUnCursoAunaMateriaYalumnoCorrectmente() {
//
//		Universidad uni = new Universidad();
//		Curso curso = new Curso(), curso2 = new Curso(), curso3 = new Curso(), curso4 = new Curso();
//
//		assertTrue(uni.asignarCursoAmateriaYalumno());
//
//	}

}
