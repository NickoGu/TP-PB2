package dominio;

import java.util.ArrayList;

public class Materia {
	private String nombre;
	private Integer codigoMateria;
	private ArrayList<Correlativa> correlativas;
	private Boolean isPromocionada = false;

	public Materia(String nombre, Integer codigoMateria) {
		this.nombre = nombre;
		this.codigoMateria = codigoMateria;
	}

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

	public Boolean estaPromocionada(Integer primerParcial, Integer segundoParcial ) {
		Boolean promociono = false;
		
		if (primerParcial >= 7 && segundoParcial >= 7) {
			promociono = true;
		}
		
		
		return promociono;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
