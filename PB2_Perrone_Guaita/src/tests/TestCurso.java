package tests;

import dominio.*;
import static org.junit.Assert.*;

import java.time.LocalDate;

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
		Curso curso = new Curso(), curso2 = new Curso(), curso3 = new Curso(), curso4 = new Curso();
		Materia pb1 = new Materia("PB2", 321, Dias.LUNES, Horario.TURNO_MANANA);
		CicloLectivo cicloLectivo = new CicloLectivo();
		Aula aula1 = new Aula(), aula2 = new Aula(), aula3 = new Aula(), aula4 = new Aula();
		Alumno alum1 = new Alumno("Martina", "Perrone", 1111), alum2 = new Alumno("Martina", "Perrone", 333),
				alum3 = new Alumno("Martina", "Perrone", 333);

		// Primero creo la universidad
		Universidad uni = new Universidad();
		// Luego inscribo alumnos en la uni
		uni.inscribirAlumnoAuiversidad(alum1);
		uni.inscribirAlumnoAuiversidad(alum2);
		uni.inscribirAlumnoAuiversidad(alum3);
		// Luego resgistro materias
		uni.registrarMateria(pb1);
		// Luego inscribo alumnos en materias
		uni.inscribirAlumnoAMateria(alum1, pb1, LocalDate.of(2023, 1, 25));
		uni.inscribirAlumnoAMateria(alum2, pb1, LocalDate.of(2023, 1, 25));
		uni.inscribirAlumnoAMateria(alum3, pb1, LocalDate.of(2023, 1, 25));
		

		assertTrue(uni.asignarCursoAmateriaYalumno(pb1, alum3, curso2, Horario.TURNO_MANANA));

	}



}
