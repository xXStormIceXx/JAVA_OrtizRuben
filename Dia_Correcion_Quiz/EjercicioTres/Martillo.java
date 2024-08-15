package EjercicioTres;

public class Martillo extends Arma {

    public Martillo(Encantamiento encantamiento) {
        super(encantamiento);
    }

    @Override
    public void activar() {
        System.out.println("Martillo: Activando encantamiento " + getEncantamiento().getClass().getSimpleName());
        getEncantamiento().activar();
    }

    @Override
    public void aplicar() {
        System.out.println("Martillo: Aplicando encantamiento " + getEncantamiento().getClass().getSimpleName());
        getEncantamiento().aplicar();
    }

    @Override
    public void desactivar() {
        System.out.println("Martillo: Desactivando encantamiento " + getEncantamiento().getClass().getSimpleName());
        getEncantamiento().desactivar();
    }
}
