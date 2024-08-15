package EjercisioDos;

public class Fuego implements Encantamiento {
    @Override
    public void activar() {
        System.out.println("El arma emite un aura de luz.");
    }

    @Override
    public void aplicar() {
        System.out.println("El arma añade daño de fuego al ataque.");
    }

    @Override
    public void desactivar() {
        System.out.println("El aura de luz desaparece.");
    }
}
