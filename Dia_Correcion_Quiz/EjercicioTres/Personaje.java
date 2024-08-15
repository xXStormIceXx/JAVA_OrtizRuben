package EjercicioTres;

public abstract class Personaje {
    private String nombre;
    private Arma arma;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.arma = null;
    }

    public String getNombre() {
        return nombre;
    }

    public Arma getArma() {
        return arma;
    }

    public void asignarArma(Arma arma) {
        this.arma = arma;
    }

    public abstract void blandir();

    public abstract void atacar();

    public abstract void soltar();
}
