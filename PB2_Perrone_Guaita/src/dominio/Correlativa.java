package dominio;

public class Correlativa {
	private Nota nota;
	private Boolean estadoDeMateria;
	private Integer codigoCorrelativa;
	private String nombre;

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Boolean getEstadoDeMateria() {
		return estadoDeMateria;
	}

	public void setEstadoDeMateria(Boolean estadoDeMateria) {
		this.estadoDeMateria = estadoDeMateria;
	}

	public Integer getCodigoCorrelativa() {
		return codigoCorrelativa;
	}

	public void setCodigoCorrelativa(Integer codigoCorrelativa) {
		this.codigoCorrelativa = codigoCorrelativa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
