package dominio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Universidad {
	private ArrayList<Alumno> alumnosInscriptos;
	private ArrayList<Materia> materiasRegistradas;
	private ArrayList<Profesor> profesores;
	private CicloLectivo cicloLectivo;

	public Universidad() {
		materiasRegistradas = new ArrayList<Materia>();
		alumnosInscriptos = new ArrayList<Alumno>();
		profesores = new ArrayList<Profesor>();
		this.cicloLectivo = new CicloLectivo();

	}

	// Inscribir alumno
	public void inscribirAlumnoAuiversidad(Alumno alumno) {

		boolean alumnoExiste = false;

		for (int i = 0; i < alumnosInscriptos.size(); i++) {
			if (alumno.getDni().equals(alumnosInscriptos.get(i).getDni())) {
				alumnoExiste = true;
				break;
			}
		}

		if (!alumnoExiste) {
			alumnosInscriptos.add(alumno);
		}
	}

	// registrar materia
	public void registrarMateria(Materia materia) {

		boolean materiaExiste = false;

		for (int i = 0; i < materiasRegistradas.size(); i++) {
			if (materia.getIdMateria().equals(materiasRegistradas.get(i).getIdMateria())) {
				materiaExiste = true;
				break;
			}
		}

		if (!materiaExiste) {
			materiasRegistradas.add(materia);
		}
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
				cantidadDeCorrelativasNecesarias++; // pb1 nul null null null
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

	public Boolean verificarHorariosYDias(Alumno alumno, Materia materia) {
		Boolean estáLibre = true;

		for (int i = 0; i < alumno.getMaterias().size(); i++) {
			if (alumno.getMaterias().get(i).getDias().equals(materia.getDias())
					&& alumno.getMaterias().get(i).getHorarios().equals(materia.getHorarios())) {
				estáLibre = false;
				break;
			}
		}

		return estáLibre;
	}

	public Boolean inscribirAlumnoAMateria(Alumno alumno, Materia materiaAinscribirse, LocalDate fechaAinscribirse) {
		Boolean sePudoInscribir = false;

		if (this.buscarSiTieneLasCorrelativasAprobadas(materiaAinscribirse) && buscarAlumno(alumno.getDni()) != null
				&& cicloLectivo.determinarSiPasoElLapso(fechaAinscribirse)) {
			alumno.getMaterias().add(materiaAinscribirse);
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

	public void agregarUnaCorrelativaAunaMateria(Materia materia, Materia materiaAagregarComoCorrelativa) {
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

		boolean profesorExistente = false;

		for (int i = 0; i < profesores.size(); i++) {
			if (profesor.getDni() == profesores.get(i).getDni()) {
				profesorExistente = true;
				break;
			}
		}

		if (!profesorExistente) {
			profesores.add(profesor);
		}
	}

	public boolean asignarCursoAmateriaYalumno(Materia pb1, Alumno alum3, Curso cursoAasignar, Horario horarios) {
		Boolean pudoAsignar = false;

		// Para asignar el curso debo chequear que el aula tenga la capacidad
		// suficiente,
		// Va haber una lista de aulas, las cuales se van a generar con distintas
		// capacidades
		// este metodo va a buscar el aula con la capacidad necesaria y se la va asignar
		// Al alumno le voy asignar la comision correspondiente a ese curso
		// A la materia le voy asignar la comision correspondiente a ese curso.

		for (int i = 0; i < Aula.getAulas().size(); i++) {
			if (Aula.getAulas().get(i) != null && Aula.getAulas().get(i).getCapacidad() >= pb1.getAlumnos().size()) {
				alum3.getComisiones().add(cursoAasignar);
				pb1.getComisiones().add(cursoAasignar);
				Aula.getAulas().get(i).asignarTurno(horarios, pb1);

				pudoAsignar = true;
				break;
			}

		}

		return pudoAsignar;
	}

	public void asignarProfesor(ArrayList<Profesor> profesores, Materia materia) {
		// Para asignar profesor se debe contar la cantidad de alumnos
		Integer contadorDeProfes = this.contarProfesores(materia);

		if (profesores.size() > contadorDeProfes) {
			for (int i = 0; i < contadorDeProfes; i++) {
				materia.getProfesores().add(profesores.get(i));
			}
		}

	}

	public Integer contarProfesores(Materia materia) {
		Integer cantidadDeProfesoresAasignar = 0, cantidadDeAlumnos = 0;

		for (int i = 0; i < materia.getAlumnos().size(); i++) {
			if (materia.getAlumnos().get(i) != null) {
				cantidadDeAlumnos++;
			}
		}
		cantidadDeProfesoresAasignar = cantidadDeAlumnos / 20;

		return cantidadDeProfesoresAasignar;
	}

}
