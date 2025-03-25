package logico;

public class EstJugador extends Estadistica {

	public EstJugador(int cantJuegos, int triples, int dobles, int normales, int puntosTot) {
		super(cantJuegos, triples, dobles, normales, puntosTot);
	}

	@Override
	public float efectividad() {
		float puntosPromedio;
		puntosPromedio=(float)puntosTot/cantJuegos;
		return puntosPromedio;
		
	}
}
