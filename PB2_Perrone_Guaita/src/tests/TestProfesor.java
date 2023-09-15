package tests;

import java.util.ArrayList;
import dominio.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestProfesor {

	@Test
	public void queSeAsigne1ProfesorCada20Alumnos() {
		Profesor profe = new Profesor("Nico", 1111), profe2 = new Profesor("Nico", 1111),
				profe3 = new Profesor("Nico", 1111), profe4 = new Profesor("Nico", 1111);
		Universidad uni = new Universidad();
		Materia pb1 = new Materia("Programacion 2", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		for (int i = 0; i < 41; i++) {
			Alumno alum = new Alumno("Martu", "Perrone", 1111);
			uni.inscribirAlumnoAMateria(alum, pb1);
		}

		ArrayList<Profesor> profesores = new ArrayList<Profesor>();
		profesores.add(profe);
		profesores.add(profe2);
		profesores.add(profe3);
		profesores.add(profe4);

		uni.asignarProfesor(profesores, pb1);

		assertTrue(pb1.getProfesores().contains(profe));
		assertTrue(pb1.getProfesores().contains(profe2));

	}

}
