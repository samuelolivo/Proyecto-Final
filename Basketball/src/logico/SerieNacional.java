package logico;

import java.util.ArrayList;

public class SerieNacional {
	private ArrayList<User> misUsuarios;
	private static User loginUser;
	
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
		
		misUsuarios = new ArrayList<User>();
		
		generadorLesion = 1;
	}
	
	public static SerieNacional getInstance() {
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
	
	public Equipo searchEquipoById(String id, ArrayList<Equipo> auxList) {
		for (Equipo auxI: auxList)
		{
			if (auxI.getId().equals(id))
				return auxI;
		}
		
		return null;
	}

	public Jugador searchJugadorById(String id, ArrayList<Jugador> auxList) {
		for (Jugador auxI: auxList)
		{
			if (auxI.getId().equals(id))
				return auxI;
		}
		
		return null;
	}	
	
	public Juego searchJuegoById(String id, ArrayList<Juego> auxList) {
		for (Juego auxI: auxList)
		{
			if (auxI.getId().equals(id))
				return auxI;
		}
		
		return null;
	}	
	
	public Lesion searchLesionByIdInPlayer(String id, ArrayList<Lesion> auxList) {
		for (Lesion auxI: auxList)
		{
			if (auxI.getId().equals(id))
				return auxI;
		}
		
		return null;
	}	
	
	public Lesion searchLesionById(String id, ArrayList<Jugador> auxList) {
		for (Jugador auxI: auxList)
		{
			for (Lesion auxJ: auxI.getMisLesiones())
				if (auxJ.getId().equals(id))
					return auxJ;
		}
		
		return null;
	}	
	
	public void guardarEquipo(Equipo aux){
		misEquipos.add(aux);
		generadorEquipo++;
	}
	
	public void guardarJugador(Jugador aux){
		misJugadores.add(aux);
		generadorJugador++;
	}
	
	public void guardarJuego(Juego aux){
		misJuegos.add(aux);
		generadorJuego++;
	}
	
	public void guardarLesion(Lesion aux){
		Jugador jug = searchJugadorById(aux.getJugador().getId(), misJugadores);
		if (jug != null) {
			jug.getMisLesiones().add(aux);
			generadorLesion++;
		}
	}
	
	public void modificarEquipo(Equipo aux) {
		Equipo update = searchEquipoById(aux.getId(), misEquipos);
		if (update != null)
			update.actualizarDatos(aux);
		return;
	}
	
	public void modificarJugador(Jugador aux) {
		Jugador update = searchJugadorById(aux.getId(), misJugadores);
		if (update != null)
			update.actualizarDatos(aux);
		return;
	}
	
	public void modificarJuego(Juego aux) {
		Juego update = searchJuegoById(aux.getId(), misJuegos);
		if (update != null)
			update.actualizarDatos(aux);
		return;
	}
	
	public void modificarLesion(Lesion aux) {
		Jugador jug = searchJugadorById(aux.getJugador().getId(), misJugadores);
		Lesion update = searchLesionByIdInPlayer(aux.getId(), jug.getMisLesiones());
		
		if (update != null && jug != null)
			update.actualizarDatos(aux);
		return;
	}
	
	public void eliminarJugador(Jugador aux) {
		misJugadores.remove(aux);
	}
	
	public void eliminarLesion(Lesion aux) {
		Jugador jug = searchJugadorById(aux.getJugador().getId(), misJugadores);
		Lesion del = searchLesionByIdInPlayer(aux.getId(), jug.getMisLesiones());
		
		if (jug != null && del != null)
			jug.getMisLesiones().remove(del);
	}
}
