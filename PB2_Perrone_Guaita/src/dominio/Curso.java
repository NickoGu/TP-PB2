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
		this.codigoComision = CONTADOR_MATERIAS++;
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

	public void asignarAulaAcomision(Integer codigoComision) {
	    Curso comision = null;

	    // Buscar la comisión con el código especificado
	    for (int i = 0; i < alumnos.size(); i++) {
	        Alumno alumno = alumnos.get(i);
	        for (int j = 0; j < alumno.getComisiones().size(); j++) {
	            Curso curso = alumno.getComisiones().get(j);
	            if (curso.getCodigoComision().equals(codigoComision)) {
	                comision = curso;
	                break; // Salir del bucle interno si se encuentra la comisión
	            }
	        }
	        if (comision != null) {
	            break; // Salir del bucle externo si se encuentra la comisión
	        }
	    }

	    if (comision != null) {
	        // La comisión ya tiene un aula asignada
	        if (comision.getAula() != null) {
	            return; // Salir del método si ya tiene un aula asignada
	        }

	        // Buscar un aula disponible
	        Aula aulaDisponible = null;
	        for (int i = 0; i < Aula.getAulas().size(); i++) {
	            Aula aula = Aula.getAulas().get(i);
	            if (aula.getMateria() == null && aula.getHorarios() == null) {
	                aulaDisponible = aula;
	                break; // Salir del bucle si se encuentra un aula disponible
	            }
	        }

	        if (aulaDisponible != null) {
	            // Asignar el aula a la comisión
	            aulaDisponible.asignarTurno(comision.getMateria().getHorarios(), comision.getMateria(), codigoComision);
	            comision.setAula(aulaDisponible);
	        }
	    }
	}
//		// Para asignar el curso debo chequear que el aula tenga la capacidad
//		// suficiente,
//		// Va haber una lista de aulas, las cuales se van a generar con distintas
//		// capacidades
//		// este metodo va a buscar el aula con la capacidad necesaria y se la va asignar
//		// Al alumno le voy asignar la comision correspondiente a ese curso
//		// A la materia le voy asignar la comision correspondiente a ese curso.
//
//		for (int i = 0; i < Aula.getAulas().size(); i++) {
//			if (Aula.getAulas().get(i) != null && Aula.getAulas().get(i).getCapacidad() >= pb1.getAlumnos().size()) {
//				alum3.getComisiones().add(cursoAasignar);
//				Aula.getAulas().get(i).asignarTurno(horarios, pb1);
//
//				pudoAsignar = true;
//				break;
//			}
//
//		}
//
//		return pudoAsignar;
//	}
		
	}


