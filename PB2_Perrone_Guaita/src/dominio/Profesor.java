package dominio;

public class Profesor {

	private String nombre;
	private Integer dni;
	private Horario horario;
	private CicloLectivo cuatri;
	private Dias dias;

	public Profesor(String nombre, Integer dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	

}
