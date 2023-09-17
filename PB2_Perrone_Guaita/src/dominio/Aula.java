package dominio;

import java.util.ArrayList;

public class Aula {
	private Integer capacidad;
	private Integer numAula;
	private static Integer CONTADOR_AULAS = 1;
	private static ArrayList<Aula> AULAS = new ArrayList<Aula>();
	private ArrayList<Curso> cursos;
	private Horario horarios;
	private Materia materia;

	// cada vez que se cree un aula se va agregar de manera automatica a la lista de
	// aulas
	// A su vez se le va asignar un numero aleatorio entre 50 y 200

	public Aula() {
		this.numAula = CONTADOR_AULAS++;
		capacidad = (int) (Math.random() * 200 + 50);
		AULAS.add(this);
		cursos = new ArrayList<Curso>();
	}

	public Boolean asignarTurno(Horario horarios, Materia materia) {
		Boolean sePudoAsignar = false;

		if (this.horarios == null && this.materia == null) {
			this.horarios = horarios;
			this.materia = materia;
			sePudoAsignar = true;
		}

		return sePudoAsignar;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getNumAula() {
		return numAula;
	}

	public void setNumAula(Integer numAula) {
		this.numAula = numAula;
	}

	public static Integer getCONTADOR_AULAS() {
		return CONTADOR_AULAS;
	}

	public static void setCONTADOR_AULAS(Integer cONTADOR_AULAS) {
		CONTADOR_AULAS = cONTADOR_AULAS;
	}

	public static ArrayList<Aula> getAulas() {
		return AULAS;
	}

	public static void setAulas(ArrayList<Aula> aulas) {
		AULAS = aulas;
	}

}
