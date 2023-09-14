package dominio;

import java.util.ArrayList;

public class Materia {
	private String nombre;
	private Integer codigoMateria;
	private ArrayList <Materia> correlativas;
	private Boolean isPromocionada = false;
	private ArrayList<Alumno> alumnosInscriptosAlaMateria;
	private Nota nota;
	private static Integer CONTADOR_MATERIAS = 1;

	public Materia(String nombre, Integer codigoMateria) {
		this.nombre = nombre;
		this.codigoMateria = codigoMateria;
		correlativas = new ArrayList<Materia>();
		alumnosInscriptosAlaMateria = new ArrayList<Alumno>();
		this.codigoMateria = CONTADOR_MATERIAS++;
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

	public void agregarCorrelativa(Materia materia) {
		correlativas.add(materia);
	}

	public void estaPromocionada(Integer primerParcial, Integer segundoParcial) {

		if (primerParcial >= 7 && segundoParcial >= 7) {
			isPromocionada = true;
		}

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
	
	

}
