package EjercicioTres;

public class Espada extends Arma {

    public Espada(Encantamiento encantamiento) {
        super(encantamiento);
    }

    @Override
    public void activar() {
        System.out.println("Espada: Activando encantamiento " + getEncantamiento().getClass().getSimpleName());
        getEncantamiento().activar();
    }

    @Override
    public void aplicar() {
        System.out.println("Espada: Aplicando encantamiento " + getEncantamiento().getClass().getSimpleName());
        getEncantamiento().aplicar();
    }

    @Override
    public void desactivar() {
        System.out.println("Espada: Desactivando encantamiento " + getEncantamiento().getClass().getSimpleName());
        getEncantamiento().desactivar();
    }
}

