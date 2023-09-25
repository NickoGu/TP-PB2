package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {
	private ArrayList<Alumno> alumnosInscriptos;
	private ArrayList<Materia> materiasRegistradas;

	private ArrayList<Profesor> profesores;
	private ArrayList<CicloLectivo> ciclosLectivos;

	public Universidad() {
		materiasRegistradas = new ArrayList<Materia>();
		alumnosInscriptos = new ArrayList<Alumno>();
		profesores = new ArrayList<Profesor>();
		ciclosLectivos = new ArrayList<CicloLectivo>();

	}

	// Inscribir alumno
	public void inscribirAlumnoAuiversidad(Alumno alumno) {

		if (!alumnosInscriptos.contains(alumno)) {
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

	public Boolean inscribirAlumnoAMateria(Alumno alumno, Materia materiaAinscribirse, CicloLectivo cicloLectivo,
			LocalDate fechaAinscribirse) {
		Boolean sePudoInscribir = false;

		if (this.buscarSiTieneLasCorrelativasAprobadas(materiaAinscribirse)
				&& cicloLectivo.determinarSiPasoElLapso(fechaAinscribirse) && alumno.getDni() != null) {
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
			materia.agregarCorrelativa(materiaAagregarComoCorrelativa);
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

	public ArrayList<Materia> materiasAprobadas(Integer dni) {
	    Alumno alumno = this.buscarAlumno(dni);

	    for (Materia materia : alumno.getMaterias()) {
	        if (materia.getNota() != null && materia.getNota().getPrimerParcial() >= 7
	                && materia.getNota().getSegundoParcial() >= 7) {
	            alumno.materiasAprobadas.add(materia);
	        }
	    }

	    return  alumno.materiasAprobadas;
	}

	public Boolean registrarCicloLectivo(CicloLectivo nuevoCiclo) {
		Boolean seRegistro = false;
		CicloLectivo encontradoPorId = buscarCicloPorId(nuevoCiclo);
		CicloLectivo encontradoPorFechasSuperpuestas = buscarPorFechasSuperpuestas(nuevoCiclo);

		if (encontradoPorId == null && encontradoPorFechasSuperpuestas == null) {
			this.ciclosLectivos.add(nuevoCiclo);
			seRegistro = true;

		}

		return seRegistro;

	} 

	private CicloLectivo buscarPorFechasSuperpuestas(CicloLectivo nuevoCiclo) {
		CicloLectivo cicloSuperpuestoEncontrado = null;

		for (int i = 0; i < ciclosLectivos.size(); i++) {
			if ((nuevoCiclo.getFechaInicioCicloLectivo()
					.isAfter(this.ciclosLectivos.get(i).getFechaInicioCicloLectivo())
					&& nuevoCiclo.getFechaInicioCicloLectivo()
							.isBefore(this.ciclosLectivos.get(i).getFechaFinalizacionCicloLectivo()))
					|| (nuevoCiclo.getFechaFinalizacionCicloLectivo()
							.isAfter(this.ciclosLectivos.get(i).getFechaInicioCicloLectivo())
							&& nuevoCiclo.getFechaFinalizacionCicloLectivo()
									.isBefore(this.ciclosLectivos.get(i).getFechaFinalizacionCicloLectivo()))) {

				cicloSuperpuestoEncontrado = this.ciclosLectivos.get(i);

			}
		}

		return cicloSuperpuestoEncontrado;
	}

	private CicloLectivo buscarCicloPorId(CicloLectivo nuevoCiclo) {
		CicloLectivo encontrado = null;

		for (int i = 0; i < this.ciclosLectivos.size(); i++) {
			if (this.ciclosLectivos.get(i).getId().equals(nuevoCiclo.getId())) {
				encontrado = this.ciclosLectivos.get(i);
			}
		}

		return encontrado;
	}

	public void eliminarCorrelatividad(Materia materiaAeliminarleLaCorrelativa, Materia materiaCorrelativa) {
		Materia materiaAeliminarle = this.buscarMateria(materiaAeliminarleLaCorrelativa.getCodigoMateria());
		Materia materiaEliminada = this.buscarMateria(materiaCorrelativa.getCodigoMateria());

		if (materiaAeliminarle != null && materiaEliminada != null) {
			materiaAeliminarleLaCorrelativa.eliminarCorrelativa(materiaCorrelativa);
		}

	}

	public void registrarNota(Integer dni, Integer codigoComision, Nota nota) {
		Alumno alumnoEncontrado = this.buscarAlumno(dni);

		if (alumnoEncontrado != null) {
			Curso comision = alumnoEncontrado.buscarComision(codigoComision);

			if (comision != null) {
				Materia materia = comision.getMateria(); 

				if (materia != null) {
					nota.setMateria(materia);
					materia.setNota(nota); 
					alumnoEncontrado.agregarNota(materia, nota);
				}
			}
		} 
	}

	public void inscribirAlumnoAComision(Alumno alumno, Materia materiaAinscribirse, Curso comision,
			CicloLectivo cicloLectivo, LocalDate fechaAinscribirse) {

		// Verificar que el alumno y la comisión estén dados de alta

		// No se puede inscribir Alumnos si este no tiene aprobadas todas las
		// correlativas. Se aprueba con 4 o más. *
		if (materiaAinscribirse.getAlumnos().contains(alumno)
				&& cicloLectivo.determinarSiPasoElLapso(fechaAinscribirse)) {
			comision.getAlumnos().add(alumno);
			alumno.getComisiones().add(comision);
		}

		// La inscripción no se puede realizar si esta fuera de fecha Inscripción

		// No se puede inscribir el alumno si excede la cantidad de alumnos permitidos
		// en el aula
		// No se puede inscribir el Alumno si ya está inscripto a otra comisión el mismo
		// día y Turno

	}



}
