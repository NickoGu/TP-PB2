package dominio;

import java.util.ArrayList;

public class AsignacionCursoProfe {
	private Integer id;
	private Curso curso;
	private Profesor profe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfe() {
		return profe;
	}

	public void setProfe(Profesor profe) {
		this.profe = profe;
	}

	public void asignarProfesor(ArrayList<Profesor> profesores, Materia materia) {
	    // Para asignar profesor se debe contar la cantidad de alumnos
	    Integer contadorDeProfes = this.contarProfesores(materia);

	    for (int i = 0; i <= contadorDeProfes; i++) {
	        materia.getProfesores().add(profesores.get(i));
	    }
	}

	public Integer contarProfesores(Materia materia) {
		Integer cantidadDeProfesoresAasignar = 0, cantidadDeAlumnos = 0;

		for (int i = 0; i < materia.getAlumnos().size(); i++) {
			if (materia.getAlumnos().get(i) != null) {
				cantidadDeAlumnos++;
			}
		}
		if (cantidadDeAlumnos > 20) {
			cantidadDeProfesoresAasignar = cantidadDeAlumnos / 20;
		} else if(cantidadDeAlumnos < 20) {
			cantidadDeProfesoresAasignar = 1;
		}

		return cantidadDeProfesoresAasignar;
	}

}
