package logico;

public class EstJugador extends Estadistica {
//
	private Jugador jugador;
	
	public EstJugador(String id, int cantJuegos, int triples, int dobles, int normales, int puntosTot,
			Jugador jugador) {
		super(id, cantJuegos, triples, dobles, normales, puntosTot);
		this.jugador = jugador;
	}

	@Override
	public float efectividad() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}
