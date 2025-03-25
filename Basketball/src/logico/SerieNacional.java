

package logico;

import java.util.ArrayList;

public class SerieNacional {
    private ArrayList<Equipo> misEquipos;
    private static int generadorEquipo;
    private ArrayList<Jugador> misJugadores;
    private static int generadorJugador;
    private ArrayList<Juego> misJuegos;
    private static int generadorJuego;
    private ArrayList<Lesion> misLesiones;
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
        misLesiones = new ArrayList<Lesion>();
        generadorLesion = 1;
    }

    public static SerieNacional getInstance() {
        if (serie == null) {
            serie = new SerieNacional();
        }
        return serie;
    }


    public Equipo buscarEquipoPorId(String id) {
        for (Equipo equipo : misEquipos) {
            if (equipo.getId().equals(id)) {
                return equipo;
            }
        }
        return null;
    }

    public Jugador buscarJugadorPorId(String id) {
        for (Jugador jugador : misJugadores) {
            if (jugador.getId().equals(id)) {
                return jugador;
            }
        }
        return null;
    }

    public Juego buscarJuegoPorId(String id) {
        for (Juego juego : misJuegos) {
            if (juego.getId().equals(id)) {
                return juego;
            }
        }
        return null;
    }

    public Lesion buscarLesionPorId(String id) {
        for (Lesion lesion : misLesiones) {
            if (lesion.getId().equals(id)) {
                return lesion;
            }
        }
        return null;
    }


    public void agregarEquipo(Equipo equipo) {
        equipo.setId("EQ-" + generadorEquipo++);
        misEquipos.add(equipo);
    }

    public void agregarJugador(Jugador jugador) {
        jugador.setId("JG-" + generadorJugador++);
        misJugadores.add(jugador);
    }

    public void agregarJuego(Juego juego) {
        juego.setId("JU-" + generadorJuego++);
        misJuegos.add(juego);
    }

    public void agregarLesion(Lesion lesion) {
        lesion.setId("LS-" + generadorLesion++);
        misLesiones.add(lesion);
    }


    public void actualizarEquipo(Equipo equipoActualizado) {
        for (int i = 0; i < misEquipos.size(); i++) {
            if (misEquipos.get(i).getId().equals(equipoActualizado.getId())) {
                misEquipos.set(i, equipoActualizado);
                break;
            }
        }
    }

    public void actualizarJugador(Jugador jugadorActualizado) {
        for (int i = 0; i < misJugadores.size(); i++) {
            if (misJugadores.get(i).getId().equals(jugadorActualizado.getId())) {
                misJugadores.set(i, jugadorActualizado);
                break;
            }
        }
    }

    public void actualizarJuego(Juego juegoActualizado) {
        for (int i = 0; i < misJuegos.size(); i++) {
            if (misJuegos.get(i).getId().equals(juegoActualizado.getId())) {
                misJuegos.set(i, juegoActualizado);
                break;
            }
        }
    }

    public void actualizarLesion(Lesion lesionActualizada) {
        for (int i = 0; i < misLesiones.size(); i++) {
            if (misLesiones.get(i).getId().equals(lesionActualizada.getId())) {
                misLesiones.set(i, lesionActualizada);
                break;
            }
        }
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

    public ArrayList<Lesion> getMisLesiones() {
        return misLesiones;
    }

    public void setMisLesiones(ArrayList<Lesion> misLesiones) {
        this.misLesiones = misLesiones;
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
