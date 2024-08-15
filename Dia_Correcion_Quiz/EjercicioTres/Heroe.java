package EjercicioTres;

public class Heroe extends Personaje {

    public Heroe(String nombre) {
        super(nombre);
    }

    @Override
    public void blandir() {
        System.out.println(getNombre() + " blandió su espada.");
        if (getArma() != null) {
            getArma().activar();
        }
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " atacó.");
        if (getArma() != null) {
            getArma().aplicar();
        }
    }

    @Override
    public void soltar() {
        System.out.println(getNombre() + " soltó el arma.");
        if (getArma() != null) {
            getArma().desactivar();
        }
    }
}
