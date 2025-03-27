package logico;

import java.util.ArrayList;

public class Jugador {
    private String id;
    private String nombre;
    private ArrayList<Lesion> misLesiones;
    private int generadorLesion;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.misLesiones = new ArrayList<>();
        this.generadorLesion = 1;
    }

    public void agregarLesion(Lesion lesion) {
        lesion.setId("LS-" + generadorLesion++);
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

    public void actualizarDatos(Jugador nuevo) {
        this.nombre = nuevo.getNombre();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public ArrayList<Lesion> getMisLesiones() { return misLesiones; }
}