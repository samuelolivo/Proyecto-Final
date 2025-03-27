package logico;

import java.util.ArrayList;

public class SerieNacional {
    private ArrayList<Equipo> misEquipos;
    private static int generadorEquipo;
    private ArrayList<Jugador> misJugadores;
    private static int generadorJugador;
    private ArrayList<Juego> misJuegos;
    private static int generadorJuego;
    private static SerieNacional serie = null;

    private SerieNacional() {
        misEquipos = new ArrayList<>();
        generadorEquipo = 1;
        misJugadores = new ArrayList<>();
        generadorJugador = 1;
        misJuegos = new ArrayList<>();
        generadorJuego = 1;
    }

    public static SerieNacional getInstance() {
        if (serie == null) {
            serie = new SerieNacional();
        }
        return serie;
    }

    public Equipo buscarEquipoById(String id) {
        for (Equipo aux : misEquipos) {
            if (aux.getId().equals(id)) return aux;
        }
        return null;
    }

    public Jugador buscarJugadorById(String id) {
        for (Jugador aux : misJugadores) {
            if (aux.getId().equals(id)) return aux;
        }
        return null;
    }

    public Juego buscarJuegoById(String id) {
        for (Juego aux : misJuegos) {
            if (aux.getId().equals(id)) return aux;
        }
        return null;
    }

    public Lesion buscarLesionById(String id) {
        for (Jugador jugador : misJugadores) {
            Lesion encontrada = jugador.buscarLesionById(id);
            if (encontrada != null) return encontrada;
        }
        return null;
    }

    public void guardarEquipo(Equipo aux) {
        aux.setId("EQ-" + generadorEquipo++);
        misEquipos.add(aux);
    }

    public void guardarJugador(Jugador aux) {
        aux.setId("JG-" + generadorJugador++);
        misJugadores.add(aux);
    }

    public void guardarJuego(Juego aux) {
        aux.setId("JU-" + generadorJuego++);
        misJuegos.add(aux);
    }

    public void agregarLesion(Jugador jugador, Lesion lesion) {
        jugador.agregarLesion(lesion);
    }

    public void modificarEquipo(Equipo aux) {
        Equipo update = buscarEquipoById(aux.getId());
        if (update != null) update.actualizarDatos(aux);
    }

    public void modificarJugador(Jugador aux) {
        Jugador update = buscarJugadorById(aux.getId());
        if (update != null) update.actualizarDatos(aux);
    }

    public void modificarJuego(Juego aux) {
        Juego update = buscarJuegoById(aux.getId());
        if (update != null) update.actualizarDatos(aux);
    }

    public void modificarLesion(Lesion aux) {
        for (Jugador jugador : misJugadores) {
            if (jugador.tieneLesion(aux.getId())) {
                jugador.modificarLesion(aux);
                break;
            }
        }
    }

    public ArrayList<Equipo> getMisEquipos() { return misEquipos; }
    public ArrayList<Jugador> getMisJugadores() { return misJugadores; }
    public ArrayList<Juego> getMisJuegos() { return misJuegos; }
}
