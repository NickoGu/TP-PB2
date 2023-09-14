package dominio;

public class Profesor {

	private String nombre;
	private Integer dni;
	private static Integer CONTADOR_ID_PROFESORES = 1;
	private Integer idProfesores;

	public Profesor(String nombre, Integer dni) {
		this.nombre = nombre;
		this.dni = dni;
		this.idProfesores = CONTADOR_ID_PROFESORES++;
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

	public static Integer getCONTADOR_ID_PROFESORES() {
		return CONTADOR_ID_PROFESORES;
	}

	public static void setCONTADOR_ID_PROFESORES(Integer cONTADOR_ID_PROFESORES) {
		CONTADOR_ID_PROFESORES = cONTADOR_ID_PROFESORES;
	}

	public Integer getIdProfesores() {
		return idProfesores;
	}

	public void setIdProfesores(Integer idProfesores) {
		this.idProfesores = idProfesores;
	}
	

}
