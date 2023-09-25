package dominio;

import java.util.ArrayList;

public class Alumno {
	private String nombre;
	private String apellido;
	private Integer dni;
	private ArrayList<Nota> notas;
	private ArrayList<Materia> materias;
	private ArrayList<Curso> comisiones;
	ArrayList<Materia> materiasAprobadas;


	public Alumno(String nombre, String apellido, Integer dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		materias = new ArrayList<Materia>();
		comisiones = new ArrayList<Curso>();
		notas = new ArrayList<Nota>();
		materiasAprobadas = new ArrayList<>();

	}
	
	public Curso buscarComision(Integer codigoComision) {
		Curso comisionEncontrada = null;

		for (int i = 0; i < comisiones.size(); i++) {
			if (comisiones.get(i).getCodigoComision().equals(codigoComision)) {
				comisionEncontrada = comisiones.get(i);
			}
		}
		return comisionEncontrada;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	public ArrayList<Curso> getComisiones() {
		return comisiones;
	}

	public void setComisiones(ArrayList<Curso> comisiones) {
		this.comisiones = comisiones;
	}

	public void agregarNota(Materia materia, Nota nota) {

		// Agregar la nota a la lista de notas del alumno
		notas.add(nota);

		// Asociar la materia a la nota (si no está asociada ya)
		if (!nota.getMateria().equals(materia)) {
			nota.setMateria(materia);
		}

	}

	public ArrayList<Materia> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(ArrayList<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}


	
	

	
	
}
