package logico;

import java.util.ArrayList;

public class SerieNacional {
    private ArrayList<Equipo> misEquipos;
    private static int generadorEquipo;
    private ArrayList<Jugador> misJugadores;
    private static int generadorJugador;
    private ArrayList<Juego> misJuegos;
    private static int generadorJuego;




    public Equipo buscarEquipoById(String id) {
        for (Equipo aux : misEquipos) {
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



    public void agregarLesion(Jugador jugador, Lesion lesion) {
        jugador.agregarLesion(lesion);
    }

    public void modificarEquipo(Equipo aux) {
        Equipo update = buscarEquipoById(aux.getId());
        if (update != null) update.actualizarDatos(aux);
    }



    public void modificarJuego(Juego aux) {
        Juego update = buscarJuegoById(aux.getId());
        if (update != null) update.actualizarDatos(aux);
    }

    

    public void actualizarJuego(Juego juegoActualizado) {
        for (int i = 0; i < misJuegos.size(); i++) {
            if (misJuegos.get(i).getId().equals(juegoActualizado.getId())) {
                misJuegos.set(i, juegoActualizado);
                break;
            }
        }
    }




    public void setMisEquipos(ArrayList<Equipo> misEquipos) {
        this.misEquipos = misEquipos;
    }



    public void setMisJugadores(ArrayList<Jugador> misJugadores) {
        this.misJugadores = misJugadores;
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


}
