package logico;

import java.time.LocalDate;

public class Lesion {
	private String id;
	private Jugador jugador;
	private LocalDate fechaLes;
	private LocalDate fechaRecPrevista;
	private String descripcionCorta;
	private boolean estadoRec;
	
	public Lesion(String id, Jugador jugador, LocalDate fechaLes, LocalDate fechaRecPrevista, String descripcionCorta,
			boolean estadoRec) {
		super();
		this.id = id;
		this.jugador = jugador;
		this.fechaLes = fechaLes;
		this.fechaRecPrevista = fechaRecPrevista;
		this.descripcionCorta = descripcionCorta;
		this.estadoRec = estadoRec;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public LocalDate getFechaLes() {
		return fechaLes;
	}

	public void setFechaLes(LocalDate fechaLes) {
		this.fechaLes = fechaLes;
	}

	public LocalDate getFechaRecPrevista() {
		return fechaRecPrevista;
	}

	public void setFechaRecPrevista(LocalDate fechaRecPrevista) {
		this.fechaRecPrevista = fechaRecPrevista;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public boolean isEstadoRec() {
		return estadoRec;
	}

	public void setEstadoRec(boolean estadoRec) {
		this.estadoRec = estadoRec;
	}
	
	

}
