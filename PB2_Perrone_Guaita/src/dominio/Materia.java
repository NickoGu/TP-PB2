package dominio;

import java.util.ArrayList;

public class Materia {
	private String nombre;
	private Integer codigoMateria;
	private Integer idMateria;
	private ArrayList<Materia> correlativas;
	private Boolean isPromocionada = false;
	private ArrayList<Alumno> alumnosInscriptosAlaMateria;
	private Nota nota;
	private ArrayList<Profesor> profesores;
	private static Integer CONTADOR_MATERIAS = 1;
	private Dias dias;
	private Horario horarios;
	private ArrayList<Curso> comisiones;
	private Aula aula;
	private CicloLectivo cicloLectivo;

	public Materia(String nombre, Integer codigoMateria, Dias dias, Horario horarios) {
		this.nombre = nombre;
		this.codigoMateria = codigoMateria;
		correlativas = new ArrayList<Materia>();
		alumnosInscriptosAlaMateria = new ArrayList<Alumno>();
		this.idMateria = CONTADOR_MATERIAS++;
		this.dias = dias;
		this.horarios = horarios;
		profesores = new ArrayList<Profesor>();
		comisiones = new ArrayList<Curso>();

		aula = new Aula();
	}

	public Boolean agregarComision( CicloLectivo cicloLectivo, Curso comision, Horario turno) {
	    // Verificamos si ya existe una comisión con los mismos datos
	    for (int i = 0; i < comisiones.size(); i++) {
	        Curso comisionExistente = comisiones.get(i);
	        if (comisionExistente.getCicloLectivo().equals(cicloLectivo) &&
	        		comisionExistente.getTurno().equals(turno)) {
	            return false; // Ya existe una comisión con los mismos datos, no se puede agregar otra
	        }
	    }

	    // Si no existe una comisión con los mismos datos, creamos una nueva comisión
	    Curso nuevaComision = new Curso(comision, cicloLectivo, turno);
	    
	    // Agregamos la nueva comisión a la lista de comisiones de la materia
	    comisiones.add(nuevaComision);
	    
	    return true; // Comisión agregada con éxito
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(Integer codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public void eliminarCorrelativa(Materia materia) {
		correlativas.remove(materia);
	}

	public void agregarCorrelativa(Materia materia) {
		correlativas.add(materia);
	}

	public void estaPromocionada(Integer primerParcial, Integer segundoParcial) {

		if (primerParcial >= 7 && segundoParcial >= 7) {
			isPromocionada = true;
		}

	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Boolean getIsPromocionada() {
		return isPromocionada;
	}

	public void setIsPromocionada(Boolean isPromocionada) {
		this.isPromocionada = isPromocionada;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnosInscriptosAlaMateria;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnosInscriptosAlaMateria = alumnos;
	}

	public Dias getDias() {
		return dias;
	}

	public void setDias(Dias dias) {
		this.dias = dias;
	}

	public Horario getHorarios() {
		return horarios;
	}

	public void setHorarios(Horario horarios) {
		this.horarios = horarios;
	}

	public ArrayList<Alumno> getAlumnosInscriptosAlaMateria() {
		return alumnosInscriptosAlaMateria;
	}

	public void setAlumnosInscriptosAlaMateria(ArrayList<Alumno> alumnosInscriptosAlaMateria) {
		this.alumnosInscriptosAlaMateria = alumnosInscriptosAlaMateria;
	}

	public static Integer getCONTADOR_MATERIAS() {
		return CONTADOR_MATERIAS;
	}

	public static void setCONTADOR_MATERIAS(Integer cONTADOR_MATERIAS) {
		CONTADOR_MATERIAS = cONTADOR_MATERIAS;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}


	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

}
