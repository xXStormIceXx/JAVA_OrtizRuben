package EjercicioUno;

public class Heroe extends Personaje {
    private static Heroe instancia;

    private Heroe(String nombre, int poder) {
        super(nombre, poder);
    }

    public static Heroe getInstancia(String nombre, int poder) {
        if (instancia == null) {
            instancia = new Heroe(nombre, poder);
        }
        return instancia;
    }

    @Override
    public void usarHabilidadEspecial() {
        System.out.println(nombre + " usa su habilidad especial de Héroe!");
    }
}
