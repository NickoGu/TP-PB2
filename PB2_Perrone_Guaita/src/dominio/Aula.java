package dominio;

public class Aula {
	private Integer capacidad;
	private Integer numAula;
	private static Integer CONTADOR_AULAS = 1;
	
	public Aula() {
		this.numAula = CONTADOR_AULAS++;
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
		this.numAula += numAula;
	}

}
