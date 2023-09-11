package dominio;

import java.util.ArrayList;

public class Universidad {
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<Profesor> profesores;

<<<<<<< HEAD
=======
	public Universidad() {
		 materias = new ArrayList<Materia>();
	}

	public void registrarMateria(Materia materia) {

		materias.add(materia);

	}

	public void asignarCorrelativas(Materia materia, Materia materia2) {

		materia.agregarCorrelativa(materia2);

	}

	public Boolean inscribirCorrelativa(Materia materia, Materia materia2) {
		Boolean inscribioCorrelativa = false;

		if (materia.getCorrelativas().contains(materia2)) {
			inscribioCorrelativa = true;
		}

		return inscribioCorrelativa;
	}
>>>>>>> branch 'master' of https://github.com/NickoGu/TP-PB2.git


}
