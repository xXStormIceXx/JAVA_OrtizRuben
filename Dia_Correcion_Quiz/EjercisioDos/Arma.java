package EjercisioDos;

public abstract class Arma {
    protected Encantamiento encantamiento;

    public Arma(Encantamiento encantamiento) {
        this.encantamiento = encantamiento;
    }

    public void blander() {
        encantamiento.activar();
    }

    public void atacar() {
        encantamiento.aplicar();
    }

    public void soltar() {
        encantamiento.desactivar();
    }

    public void cambiarEncantamiento(Encantamiento nuevoEncantamiento) {
        encantamiento.desactivar();
        this.encantamiento = nuevoEncantamiento;
        encantamiento.activar();
    }
}
