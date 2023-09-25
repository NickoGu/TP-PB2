package dominio;

import java.util.ArrayList;

public class Curso {

	private ArrayList<Alumno> alumnos;
	private Aula aula;
	private Profesor profesor;
	private Integer codigoComision;
	private static Integer CONTADOR_MATERIAS = 1;
	private Materia materia;
	private CicloLectivo cicloLectivo;
	private Horario turno;
	private Curso comision;

	
	public Curso() {
		
	}
	
	public Curso(Materia materia) {
		this.codigoComision = CONTADOR_MATERIAS++;
		this.alumnos = new ArrayList<Alumno>();
		this.materia = materia;
	}

	public Curso(Curso comision, CicloLectivo cicloLectivo, Horario turno) {
		this.comision = comision;
		this.cicloLectivo = cicloLectivo;
		this.turno = turno;
		this.codigoComision = CONTADOR_MATERIAS++;
	}

	public ArrayList<Alumno> getAlumnos() {
		return this.alumnos;
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

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Horario getTurno() {
		return turno;
	}

	public void setTurno(Horario turno) {
		this.turno = turno;
	}

	public Curso getComision() {
		return comision;
	}

	public void setComision(Curso comision) {
		this.comision = comision;
	}

}
