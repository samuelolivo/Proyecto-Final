package logico;

import java.util.ArrayList;

public class Jugador {


	private String posicion;

	private Equipo equipo;
	private ArrayList<Lesion>misLesiones;
	private ArrayList<Juego>juegos;
	private EstJugador estadisticas;
	private boolean estadoSalud;
	
	public Jugador(String id, String nombre, String posicion, float pesoKg, float alturaCm, Equipo equipo, ArrayList<Lesion> misLesiones,
			ArrayList<Juego> juegos, EstJugador estadisticas, boolean estadoSalud) {
		super();

		this.posicion = posicion;

		this.equipo = equipo;
		this.misLesiones = misLesiones;
		this.juegos = juegos;
		this.estadisticas = new EstJugador(0, 0, 0, 0, 0);
		this.estadoSalud = estadoSalud;
	}


    public void agregarLesion(Lesion lesion) {
        misLesiones.add(lesion);
    }

    public Lesion buscarLesionById(String id) {
        for (Lesion aux : misLesiones) {
            if (aux.getId().equals(id)) return aux;
        }
        return null;
    }

    public boolean tieneLesion(String id) {
        return buscarLesionById(id) != null;
    }

    public void modificarLesion(Lesion lesion) {
        Lesion update = buscarLesionById(lesion.getId());
        if (update != null) update.actualizarDatos(lesion);
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
	

	
}

