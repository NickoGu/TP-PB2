package tests;

import java.time.LocalDate;
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
		AsignacionCursoProfe asignarProfe = new AsignacionCursoProfe();	
		Materia pb1 = new Materia("Programacion 2", 14302, Dias.LUNES, Horario.TURNO_MANANA);
		Alumno alumno = new Alumno("Martu", "Pe", 12342);
		uni.inscribirAlumnoAMateria(alumno, pb1, LocalDate.of(2023, 2, 25));
		Alumno alumno2 = new Alumno("Martu", "Pe", 123344);
		Alumno alumno3= new Alumno("Martu", "Pe", 1235324);
		Alumno alumno4 = new Alumno("Martu", "Pe", 1235324);
		Alumno alumno5 = new Alumno("Martu", "Pe", 12325324);
		Alumno alumno6 = new Alumno("Martu", "Pe", 1278934);
		Alumno alumno7 = new Alumno("Martu", "Pe", 123445745);
		Alumno alumno8 = new Alumno("Martu", "Pe", 1236348684);
		Alumno alumno9 = new Alumno("Martu", "Pe", 129759534);
		Alumno alumno0 = new Alumno("Martu", "Pe", 12386574);
		Alumno alumno2432 = new Alumno("Martu", "Pe", 123969754);
		Alumno alumno332 = new Alumno("Martu", "Pe", 1286587934);
		Alumno alumno542 = new Alumno("Martu", "Pe", 197553234);
		Alumno alumno64 = new Alumno("Martu", "Pe", 12342222);
		Alumno alumno32 = new Alumno("Martu", "Pe", 12311114);
		Alumno alumno532 = new Alumno("Martu", "Pe", 123411111);
		Alumno alumno53253 = new Alumno("Martu", "Pe", 1234343434);
		Alumno alumno32532 = new Alumno("Martu", "Pe", 1253252634);
		Alumno alumno53252 = new Alumno("Martu", "Pe", 1253253234);
		Alumno alumno3522352 = new Alumno("Martu", "Pe", 100000234);
		Alumno alumno52352 = new Alumno("Martu", "Pe", 12999934);
		Alumno alumno2532 = new Alumno("Martu", "Pe", 12388884);
		Alumno alumno532523 = new Alumno("Martu", "Pe", 1237373734);
		uni.inscribirAlumnoAMateria(alumno2, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno3, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno4, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno5, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno6, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno7, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno8, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno9, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno0, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno2432, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno332, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno542, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno64, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno32, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno532, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno53253, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno32532, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno53252, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno53252, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno3522352, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno52352, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno2532, pb1, LocalDate.of(2023, 2, 25));
		uni.inscribirAlumnoAMateria(alumno532523, pb1, LocalDate.of(2023, 2, 25));
		
		
		ArrayList<Profesor> profesores = new ArrayList<Profesor>();
		profesores.add(profe);
		profesores.add(profe2);
		profesores.add(profe3);
		profesores.add(profe4);
		
		asignarProfe.asignarProfesor(profesores, pb1);

		assertTrue(pb1.getProfesores().contains(profe));
		assertTrue(pb1.getProfesores().contains(profe2));
		// assertTrue(pb1.getProfesores().contains(profe4));
	}

}
