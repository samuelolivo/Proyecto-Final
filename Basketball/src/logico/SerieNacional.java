package logico;

import java.util.ArrayList;

public class SerieNacional {

	private ArrayList<Equipo> misEquipos;
	private static int generadorEquipo;

	private ArrayList<Jugador> misJugadores;
	private static int generadorJugador;

	private ArrayList<Juego> misJuegos;
	private static int generadorJuego;
	
	private static int generadorLesion;

	private static SerieNacional serie = null;
	
	private SerieNacional() {
		super();
		misEquipos = new ArrayList<Equipo>();
		generadorEquipo = 1;
		
		misJugadores = new ArrayList<Jugador>();
		generadorJugador = 1;
		
		misJuegos = new ArrayList<Juego>();
		generadorJuego = 1;
		
		generadorLesion = 1;
	}
	
	public SerieNacional getInstance() {
		if (serie == null)
			serie = new SerieNacional();
		
		return serie;
	}

	public ArrayList<Equipo> getMisEquipos() {
		return misEquipos;
	}

	public void setMisEquipos(ArrayList<Equipo> misEquipos) {
		this.misEquipos = misEquipos;
	}

	public ArrayList<Jugador> getMisJugadores() {
		return misJugadores;
	}

	public void setMisJugadores(ArrayList<Jugador> misJugadores) {
		this.misJugadores = misJugadores;
	}

	public ArrayList<Juego> getMisJuegos() {
		return misJuegos;
	}

	public void setMisJuegos(ArrayList<Juego> misJuegos) {
		this.misJuegos = misJuegos;
	}

	public static int getGeneradorEquipo() {
		return generadorEquipo;
	}

	public static int getGeneradorJugador() {
		return generadorJugador;
	}

	public static int getGeneradorJuego() {
		return generadorJuego;
	}

	public static int getGeneradorLesion() {
		return generadorLesion;
	}
}
