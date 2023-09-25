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
	public void queSeAsigneUnAulaAunaComision() {
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);
		String nombre = "Nico";
		String apellido = "Guaita";
		Integer dni = 12345678;
		Aula aula1 = new Aula();
		Aula aula2 = new Aula();
		Aula aula3 = new Aula();
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

		comision.asignarAulaAcomision(comision.getCodigoComision());

		assertNotNull(comision.getAula());

	}

//	@Test
//	public void queSeLeAsigneUnCursoAunaMateriaYalumnoCorrectmente() {
//		
//		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 4, 1);
//		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 31);
//		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
//		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 3, 28);
//
//		CicloLectivo cicloLectivo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
//				fechaInicioInscripcion, fechaFinalizacionInscripcion);
//		
//		Curso curso = new Curso(), curso2 = new Curso(), curso3 = new Curso(), curso4 = new Curso();
//		Materia pb1 = new Materia("PB2", 321, Dias.LUNES, Horario.TURNO_MANANA);
//		Aula aula1 = new Aula(), aula2 = new Aula(), aula3 = new Aula(), aula4 = new Aula();
//		Alumno alum1 = new Alumno("Martina", "Perrone", 1111), alum2 = new Alumno("Martina", "Perrone", 333),
//				alum3 = new Alumno("Martina", "Perrone", 333);
//
//		// Primero creo la universidad
//		Universidad uni = new Universidad();
//		// Luego inscribo alumnos en la uni
//		uni.inscribirAlumnoAuiversidad(alum1);
//		uni.inscribirAlumnoAuiversidad(alum2);
//		uni.inscribirAlumnoAuiversidad(alum3);
//		// Luego resgistro materias
//		uni.registrarMateria(pb1);
//		// Luego inscribo alumnos en materias
//		uni.inscribirAlumnoAMateria(alum1, pb1,cicloLectivo, LocalDate.of(2023, 1, 25));
//		uni.inscribirAlumnoAMateria(alum2, pb1,cicloLectivo, LocalDate.of(2023, 1, 25));
//		uni.inscribirAlumnoAMateria(alum3, pb1,cicloLectivo, LocalDate.of(2023, 1, 25));
//		
//
//		assertTrue(uni.asignarCursoAmateriaYalumno(pb1, alum3, curso2, Horario.TURNO_MANANA));
//
//	}

}
