package logico;

public class EstEquipo extends Estadistica {

	private int ganados;
	private int perdidos;
	
	public EstEquipo(int cantJuegos, int triples, int dobles, int normales, int puntosTot,
			int ganados, int perdidos) {
		super(cantJuegos, triples, dobles, normales, puntosTot);
		this.ganados = ganados;
		this.perdidos = perdidos;
	}
	
	@Override
	public float efectividad() {
		int totalP=ganados+perdidos;
		float winrate;
	
		winrate=(float)(ganados/totalP)*100;
		return winrate;
		
	}

	public int getGanados() {
		return ganados;
	}

	public void setGanados(int ganados) {
		this.ganados = ganados;
	}

	public int getPerdidos() {
		return perdidos;
	}

	public void setPerdidos(int perdidos) {
		this.perdidos = perdidos;
	}
}
