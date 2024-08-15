package EjercicioTres;

public class Main {
    public static void main(String[] args) {
        Armeria armeria = new Armeria();

        // Crear un héroe con un arma élfica con encantamiento de fuego
        Heroe heroe = new Heroe("Aragorn");
        Encantamiento fuego = new Fuego();
        Arma espadaElfica = armeria.crearArma("Elfo", fuego);
        heroe.asignarArma(espadaElfica);

        heroe.blandir();
        heroe.atacar();
        heroe.soltar();

        System.out.println("------");

        // Crear un villano con un martillo enano con encantamiento vorpal
        Villano villano = new Villano("Sauron");
        Encantamiento vorpal = new Vorpal();
        Arma martilloEnano = armeria.crearArma("Enano", vorpal);
        villano.asignarArma(martilloEnano);

        villano.blandir();
        villano.atacar();
        villano.soltar();
    }
}
