package logico;

public class EstJugador extends Estadistica {
	private int robos;
	private int tapones;
	private int asistencias;
	private int faltas;
	private int mvp;
	
	public EstJugador(int cantJuegos, int triples, int dobles, int normales, int puntosTot, int robos, int tapones,
			int asistencias, int faltas, int mvp) {
		super(cantJuegos, triples, dobles, normales, puntosTot);
		this.robos = robos;
		this.tapones = tapones;
		this.asistencias = asistencias;
		this.faltas = faltas;
		this.mvp = mvp;
	}
	
	@Override
	public float efectividad() {
		float puntosPromedio;
		puntosPromedio=(float)puntosTot/cantJuegos;
		return puntosPromedio;
		
	}

	public int getRobos() {
		return robos;
	}

	public void setRobos(int robos) {
		this.robos = robos;
	}

	public int getTapones() {
		return tapones;
	}

	public void setTapones(int tapones) {
		this.tapones = tapones;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public int getMvp() {
		return mvp;
	}

	public void setMvp(int mvp) {
		this.mvp = mvp;
	}
}
