package logico;

import java.util.ArrayList;

public class Juego {

	    private String id;
	    private Equipo home;
	    private Equipo away;
	    private ArrayList<Estadistica> estadisticas;
	    private int marcadorCasa;
	    private int marcadorAway;
	    private String ganador;

	    public Juego(String id, Equipo home, Equipo away) {
	        this.id = id;
	        this.home = home;
	        this.away = away;
	        this.estadisticas = new ArrayList<>();
	        this.marcadorCasa = 0;
	        this.marcadorAway = 0;
	        this.ganador = null;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public Equipo getHome() {
	        return home;
	    }

	    public void setHome(Equipo home) {
	        this.home = home;
	    }

	    public Equipo getAway() {
	        return away;
	    }

	    public void setAway(Equipo away) {
	        this.away = away;
	    }

	    public ArrayList<Estadistica> getEstadisticas() {
	        return estadisticas;
	    }

	    public void setEstadisticas(ArrayList<Estadistica> estadisticas) {
	        this.estadisticas = estadisticas;
	    }

	    public int getMarcadorCasa() {
	        return marcadorCasa;
	    }

	    public void setMarcadorCasa(int marcadorCasa) {
	        this.marcadorCasa = marcadorCasa;
	    }

	    public int getMarcadorAway() {
	        return marcadorAway;
	    }

	    public void setMarcadorAway(int marcadorAway) {
	        this.marcadorAway = marcadorAway;
	    }

	    public String getGanador() {
	        return ganador;
	    }

	    public void setGanador(String ganador) {
	        this.ganador = ganador;
	    }
	}