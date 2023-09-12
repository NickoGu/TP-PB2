package dominio;

import java.util.ArrayList;


public class Universidad {
	private ArrayList<Alumno> alumnosInscriptos;
	private ArrayList<Materia> materiasRegistradas;
	private ArrayList<Profesor> profesores;
	private ArrayList<Curso> cursos;

	public Universidad() {
		materiasRegistradas = new ArrayList<Materia>();
		alumnosInscriptos = new ArrayList<Alumno>();
		profesores = new ArrayList<Profesor>();
	}

	// Inscribir alumno
	public void inscribirAlumnoAuiversidad(Alumno alumno) {
		alumnosInscriptos.add(alumno);

	}

	// registrar materia
	public void registrarMateria(Materia materia) {

		materiasRegistradas.add(materia);

	}


	public Alumno buscarAlumno(Integer dniAlumno) {
		Alumno alumnoEncontrado = null;

		for (int i = 0; i < alumnosInscriptos.size(); i++) {
			if (alumnosInscriptos.get(i).getDni().equals(dniAlumno)) {
				alumnoEncontrado = alumnosInscriptos.get(i);
			}
		}
		return alumnoEncontrado;

	}

	public Materia buscarMateria(Integer codigoMateria) {
		Materia materiaEncontrada = null;

		for (int i = 0; i < materiasRegistradas.size(); i++) {
			if (materiasRegistradas.get(i).getCodigoMateria().equals(codigoMateria)) {
				materiaEncontrada = materiasRegistradas.get(i);
			}
		}

		return materiaEncontrada;
	}

	public Boolean buscarSiTieneLasCorrelativasAprobadas(Materia materia) {
		Boolean lasTienePromocionadas = false;
		Integer cantidadDeCorrelativasPromocionadas = 0, cantidadDeCorrelativasNecesarias = 0;

		// El for recorre las correlativas de la materia brindada por parametro
		for (int i = 0; i < materia.getCorrelativas().size(); i++) {
			if (this.buscarMateria(materia.getCorrelativas().get(i).getCodigoMateria()) != null) {
				cantidadDeCorrelativasNecesarias++;
				// si encuentra una correlativa, luego tiene que verificar que este promocionada

				// Si la correlativa que se encuentra en esa posicion del array que pertence a
				// materias esta
				// promocionada, entonces sumo correlativas
				if (this.buscarMateria(materia.getCorrelativas().get(i).getCodigoMateria()).getIsPromocionada()) {
					cantidadDeCorrelativasPromocionadas++;
				}
			}

		}

		if (cantidadDeCorrelativasPromocionadas == cantidadDeCorrelativasNecesarias) {
			lasTienePromocionadas = true;
		}
		return lasTienePromocionadas;

	}

	public Boolean inscribirAlumnoAMateria(Alumno alumno, Materia materiaAinscribirse, Integer primerParcial,
			Integer segundoParcial) {
		Boolean sePudoInscribir = false;

		if (this.buscarSiTieneLasCorrelativasAprobadas(materiaAinscribirse)) {
			materiaAinscribirse.getAlumnos().add(alumno);
			sePudoInscribir = true;
		}

		// Para inscribir alumno en la materia
		// fijarme si la materia tiene correlativa
		// Si la materia tiene correlativa chquear que el alumno la tenga aprobada
		// Si el alumno la tiene aprobada inscribir al alumno en la materia
		// Al alumno lo tengo a agreagar al array de alumos dentro de la materia

		return sePudoInscribir;
	}

	public void agregarUnaCoorrelativaAunaMateria(Materia materia, Materia materiaAagregarComoCorrelativa) {
		Materia materiaExiste = this.buscarMateria(materia.getCodigoMateria());
		Materia materiaAagregarExiste = this.buscarMateria(materiaAagregarComoCorrelativa.getCodigoMateria());

		if (materiaExiste != null && materiaAagregarExiste != null) {
			materiaAagregarExiste.agregarCorrelativa(materiaAagregarComoCorrelativa);
		}

	}

	public ArrayList<Alumno> getAlumnosInscriptos() {
		return alumnosInscriptos;
	}

	public void setAlumnosInscriptos(ArrayList<Alumno> alumnosInscriptos) {
		this.alumnosInscriptos = alumnosInscriptos;
	}

	public ArrayList<Materia> getMateriasRegistradas() {
		return materiasRegistradas;
	}

	public void setMateriasRegistradas(ArrayList<Materia> materiasRegistradas) {
		this.materiasRegistradas = materiasRegistradas;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public void inscribirProfesor(Profesor profesor) {
		profesores.add(profesor);
		
	}
	

}
