package dominio;

import java.util.ArrayList;

public class Curso {


	private ArrayList<Alumno> alumnos;
	private Aula aula;
	private Profesor profesor;
	private Integer codigoComision;
	private CicloLectivo cicloLectivo;
	private static Integer CONTADOR_MATERIAS = 1;

	public Curso() {
		this.codigoComision = CONTADOR_MATERIAS++;
	}


	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Integer getCodigoComision() {
		return codigoComision;
	}

	public void setCodigoComision(Integer codigoComision) {
		this.codigoComision = codigoComision;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public static Integer getCONTADOR_MATERIAS() {
		return CONTADOR_MATERIAS;
	}

	public static void setCONTADOR_MATERIAS(Integer cONTADOR_MATERIAS) {
		CONTADOR_MATERIAS = cONTADOR_MATERIAS;
	}
	
	
	

}
