package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Alumno;

public class TestAlumno {

	@Test
	public void queSePuedaCrearElAlumno() {
		String nombre = "Martu";
		String apellido = "Guaita";
		Integer dni = 12345;

		Alumno alumno = new Alumno(nombre, apellido, dni);

		assertEquals(alumno.getNombre(), nombre);
		assertEquals(alumno.getApellido(), apellido);
		assertEquals(alumno.getDni(), dni);

	}

}
