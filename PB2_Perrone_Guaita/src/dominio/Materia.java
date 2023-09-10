package dominio;

import java.util.ArrayList;

public class Materia {
	private String nombre;
	private Integer codigoMateria;
	private ArrayList<Correlativa> correlativas;
	private Boolean isPromocionada = false;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(Integer codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public ArrayList<Correlativa> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Correlativa> correlativas) {
		this.correlativas = correlativas;
	}

}
