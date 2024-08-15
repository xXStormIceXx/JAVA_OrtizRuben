package EjercicioUno;

public abstract class Personaje {
    protected String nombre;
    protected int poder;

    public Personaje(String nombre, int poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoder() {
        return poder;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + ", Poder: " + poder);
    }

    public abstract void usarHabilidadEspecial();
}

