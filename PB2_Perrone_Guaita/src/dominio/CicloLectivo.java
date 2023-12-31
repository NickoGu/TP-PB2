package dominio;

import java.time.LocalDate;

public class CicloLectivo {

	private Integer Id;
	private LocalDate fechaInicioCicloLectivo;
	private LocalDate fechaFinalizacionCicloLectivo;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	private Cuatrimestres cuatris;
	private static Integer CONTADOR_ID_CICLOS_LECTIVOS = 1;

	public CicloLectivo(LocalDate fechaInicioCicloLectivo, LocalDate fechaFinalizacionCicloLectivo,
			LocalDate fechaInicioInscripcion, LocalDate fechaFinalizacionInscripcion) {
		this.Id = CONTADOR_ID_CICLOS_LECTIVOS++;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}

	public Boolean determinarSiPasoElLapso(LocalDate fechaDeRegistro) {
		Boolean iscripcionAceptada = false;
		if (fechaDeRegistro.isAfter(fechaInicioInscripcion) && fechaDeRegistro.isBefore(fechaFinalizacionInscripcion)) {
			iscripcionAceptada = true;
		}

		return iscripcionAceptada;

	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public LocalDate getFechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}

	public void setFechaInicioCicloLectivo(LocalDate fechaInicioCicloLectivo) {
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
	}

	public LocalDate getFechaFinalizacionCicloLectivo() {
		return fechaFinalizacionCicloLectivo;
	}

	public void setFechaFinalizacionCicloLectivo(LocalDate fechaFinalizacionCicloLectivo) {
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
	}

	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}

	public LocalDate getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}

	public void setFechaFinalizacionInscripcion(LocalDate fechaFinalizacionInscripcion) {
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}

	public static Integer getCONTADOR_ID_CICLOS_LECTIVOS() {
		return CONTADOR_ID_CICLOS_LECTIVOS;
	}

	public static void setCONTADOR_ID_CICLOS_LECTIVOS(Integer cONTADOR_ID_CICLOS_LECTIVOS) {
		CONTADOR_ID_CICLOS_LECTIVOS = cONTADOR_ID_CICLOS_LECTIVOS;
	}

	public Cuatrimestres getCuatris() {
		return cuatris;
	}

	public void setCuatris(Cuatrimestres cuatris) {
		this.cuatris = cuatris;
	}

}
