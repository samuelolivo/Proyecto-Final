package logico;

public class Juego {
	    private Equipo equipoLocal;
	    private Equipo equipoVisitante;

	    public Juego(Equipo equipoLocal, Equipo equipoVisitante) {
	        this.equipoLocal = equipoLocal;
	        this.equipoVisitante = equipoVisitante;
	    }

	    public void anotarPuntos(Equipo equipo, int puntos) {
	        equipo.sumarPuntos(puntos);
	    }

	    public void mostrarResultado() {
	        System.out.println("Resultado: " + equipoLocal.getNombre() + " " + equipoLocal.getPuntos() + " - " + equipoVisitante.getNombre() + " " + equipoVisitante.getPuntos());
	    }
	}

