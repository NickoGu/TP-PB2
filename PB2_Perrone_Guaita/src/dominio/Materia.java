package dominio;

import java.util.ArrayList;

public class Materia {
	private String nombre;
	private Integer codigoMateria;
	private ArrayList<Materia> correlativas;
	private Boolean isPromocionada = false;
	private ArrayList<Alumno> alumnos;
	private Nota nota;

	public Materia(String nombre, Integer codigoMateria) {
		this.nombre = nombre;
		this.codigoMateria = codigoMateria;
		correlativas = new ArrayList<Materia>();
		alumnos = new ArrayList<Alumno>();
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

	public Boolean estaPromocionada(Integer primerParcial, Integer segundoParcial) {
		Boolean promociono = false;

		if (primerParcial >= 7 && segundoParcial >= 7) {
			promociono = true;
		}

		return promociono;
	}

	public Boolean inscribirAlumno(Alumno alumno, Integer primerParcial, Integer segundoParcial) {
		Boolean sePudoInscribir = false;
		
		if(estaPromocionada(primerParcial, segundoParcial)){
			alumnos.add(alumno);
			sePudoInscribir = true;
		}
		
		
		return sePudoInscribir;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	
	
	
	
	
	
	
	
	
}
