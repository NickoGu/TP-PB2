package dominio;

public class Nota {

	private Integer primerParcial;
	private Integer segundoParcial;

	public void asignarValorAprimerParcial(Integer valorNota) {
		if (valorNota >= 1 && valorNota <= 10)
			this.primerParcial = valorNota;

	}

	public void asignarValorAsegundoParcial(Integer valorNota) {
		if (valorNota >= 1 && valorNota <= 10)
			this.segundoParcial = valorNota;

	}

	public Integer getPrimerParcial() {
		return primerParcial;
	}

	public void setPrimerParcial(Integer primerParcial) {
		this.primerParcial = primerParcial;
	}

	public Integer getSegundoParcial() {
		return segundoParcial;
	}

	public void setSegundoParcial(Integer segundoParcial) {
		this.segundoParcial = segundoParcial;
	}

	public Boolean estadoRecuperatorio() {
		Boolean sePuedeRecuperar = false;

		if ((this.primerParcial < 7 && this.segundoParcial >= 7)
				|| (this.primerParcial >= 7 && this.segundoParcial < 7))
			sePuedeRecuperar = true;

		return sePuedeRecuperar;
	}

	public Boolean recuperarPrimerParcial() {
		Boolean loDebeRecuperar = false;

		if (this.primerParcial < 7)
			loDebeRecuperar = true;

		return loDebeRecuperar;
	}

	public Boolean recuperarSegundoParcial() {
		Boolean loDebeRecuperar = false;

		if (this.segundoParcial < 7)
			loDebeRecuperar = true;

		return loDebeRecuperar;

	}

	public void recuperarParcial(Integer valorRecuperatorio) {
		if (this.recuperarPrimerParcial()) {
			this.primerParcial = valorRecuperatorio;
		} else if (this.recuperarSegundoParcial()) {
			this.segundoParcial = valorRecuperatorio;
		}

	}

}
