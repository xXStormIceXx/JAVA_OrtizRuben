package EjercicioTres;

public class Vorpal implements Encantamiento {
    @Override
    public void activar() {
        System.out.println("El arma se vuelve de color rojo intenso.");
    }

    @Override
    public void aplicar() {
        System.out.println("El arma incrementa la posibilidad de un ataque crítico.");
    }

    @Override
    public void desactivar() {
        System.out.println("El color rojo del arma se desvanece.");
    }
}
