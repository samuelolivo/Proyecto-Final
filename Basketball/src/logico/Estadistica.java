package logico;

public abstract class Estadistica {

	protected int cantJuegos;
	protected int triples;
	protected int dobles;
	protected int normales;
	protected int puntosTot;
	
	public Estadistica(int cantJuegos, int triples, int dobles, int normales, int puntosTot) {
		super();
		this.cantJuegos = cantJuegos;
		this.triples = triples;
		this.dobles = dobles;
		this.normales = normales;
		this.puntosTot = puntosTot;
	}

	public int getCantJuegos() {
		return cantJuegos;
	}

	public void setCantJuegos(int cantJuegos) {
		this.cantJuegos = cantJuegos;
	}

	public int getTriples() {
		return triples;
	}

	public void setTriples(int triples) {
		this.triples = triples;
	}

	public int getDobles() {
		return dobles;
	}

	public void setDobles(int dobles) {
		this.dobles = dobles;
	}

	public int getNormales() {
		return normales;
	}

	public void setNormales(int normales) {
		this.normales = normales;
	}

	public int getPuntosTot() {
		return puntosTot;
	}

	public void setPuntosTot(int puntosTot) {
		this.puntosTot = puntosTot;
	}
	
	public abstract float efectividad();
}
