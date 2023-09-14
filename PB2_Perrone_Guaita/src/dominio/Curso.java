package dominio;

import java.util.ArrayList;

public class Curso {

	private ArrayList<Materia> materias;
	private ArrayList<Alumno> alumnos;
	private Aula aula;
	private Profesor profesor;
	private Integer codigoComision;
	private CicloLectivo cicloLectivo;
	private static Integer CONTADOR_MATERIAS = 1;

	public Curso() {
		this.codigoComision = CONTADOR_MATERIAS++;
	}

}
