package logico;

public class EstEquipo extends Estadistica {

	private Equipo equipo;
	private int ganados;
	private int perdidos;
	
	public EstEquipo(String id, int cantJuegos, int triples, int dobles, int normales, int puntosTot, Equipo equipo,
			int ganados, int perdidos) {
		super(id, cantJuegos, triples, dobles, normales, puntosTot);
		this.equipo = equipo;
		this.ganados = ganados;
		this.perdidos = perdidos;
	}
	
	@Override
	public float efectividad() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
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
