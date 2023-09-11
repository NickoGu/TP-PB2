package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Alumno;
import dominio.Universidad;

public class TestUniversidad {

	@Test
	public void verificaQueSePuedaInscribirAlumnoEnUniversidad() {
		
			String nombre = "Martina";
			String apellido = "Perrone";
			Integer dni = 46119380;

			Alumno alumno = new Alumno(nombre, apellido, dni);
			Universidad universidad = new Universidad();
			universidad.inscribirAlumno(alumno);
			
			
			
		
	}

}
