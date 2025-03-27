package logico;

import java.util.ArrayList;

public class Jugador {
	private String id;
	private String nombre;
	private String posicion;
	private float pesoKg;
	private float alturaCm;
	private Equipo equipo;
	private ArrayList<Lesion>misLesiones;
	private ArrayList<Juego>juegos;
	private EstJugador estadisticas;
	private boolean estadoSalud;
	
	public Jugador(String id, String nombre, String posicion, float pesoKg, float alturaCm, Equipo equipo, ArrayList<Lesion> misLesiones,
			ArrayList<Juego> juegos, EstJugador estadisticas, boolean estadoSalud) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.posicion = posicion;
		this.pesoKg = pesoKg;
		this.alturaCm = alturaCm;
		this.equipo = equipo;
		this.misLesiones = misLesiones;
		this.juegos = juegos;
		this.estadisticas = new EstJugador(0, 0, 0, 0, 0);
		this.estadoSalud = estadoSalud;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(float pesoKg) {
		this.pesoKg = pesoKg;
	}

	public float getAlturaCm() {
		return alturaCm;
	}

	public void setAlturaCm(float alturaCm) {
		this.alturaCm = alturaCm;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public ArrayList<Lesion> getMisLesiones() {
		return misLesiones;
	}

	public void setMisLesiones(ArrayList<Lesion> misLesiones) {
		this.misLesiones = misLesiones;
	}

	public ArrayList<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(ArrayList<Juego> juegos) {
		this.juegos = juegos;
	}

	public EstJugador getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(EstJugador estadisticas) {
		this.estadisticas = estadisticas;
	}

	public boolean isEstadoSalud() {
		return estadoSalud;
	}

	public void setEstadoSalud(boolean estadoSalud) {
		this.estadoSalud = estadoSalud;
	}
	

	public void setId(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public void actualizarDatos(Jugador aux) {
		this.nombre = aux.getNombre();
		this.pesoKg = aux.getPesoKg();
		this.posicion = aux.getPosicion();
		this.alturaCm = aux.getAlturaCm();
		this.equipo = aux.getEquipo();
		this.misLesiones = aux.getMisLesiones();
		this.juegos = aux.getJuegos();
		this.estadoSalud = aux.isEstadoSalud();
	}
}
