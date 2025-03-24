package logico;

import java.util.ArrayList;

public class Equipo {
	
	    private String id;
	    private String nombre;
	    private ArrayList<Juego> juegos;
	    private ArrayList<Jugador> jugadores;
	    private EstEquipo estadistica;

	    public Equipo(String id, String nombre) {
	        this.id = id;
	        this.nombre = nombre;
	        this.juegos = new ArrayList<>();
	        this.jugadores = new ArrayList<>();
	        this.estadistica = new EstEquipo( nombre, 0, 0, 0, 0, 0, null, 0, 0);
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public ArrayList<Juego> getJuegos() {
	        return juegos;
	    }

	    public void setJuegos(ArrayList<Juego> juegos) {
	        this.juegos = juegos;
	    }

	    public ArrayList<Jugador> getJugadores() {
	        return jugadores;
	    }

	    public void setJugadores(ArrayList<Jugador> jugadores) {
	        this.jugadores = jugadores;
	    }

	    public EstEquipo getEstadistica() {
	        return estadistica;
	    }

	    public void setEstadistica(EstEquipo estadistica) {
	        this.estadistica = estadistica;
	    }
	}