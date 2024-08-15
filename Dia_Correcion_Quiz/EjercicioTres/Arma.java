package EjercicioTres;

public abstract class Arma {
    private Encantamiento encantamiento;

    public Arma(Encantamiento encantamiento) {
        this.encantamiento = encantamiento;
    }

    public Encantamiento getEncantamiento() {
        return encantamiento;
    }

    public abstract void activar();

    public abstract void aplicar();

    public abstract void desactivar();
}
