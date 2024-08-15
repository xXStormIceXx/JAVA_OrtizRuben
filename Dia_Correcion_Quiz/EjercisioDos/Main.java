package EjercisioDos;

public class Main {
    public static void main(String[] args) {
        // Crear encantamientos
        Encantamiento fuego = new Fuego();
        Encantamiento vorpal = new Vorpal();

        // Crear armas con encantamientos
        Arma espada = new Espada(fuego);
        Arma martillo = new Martillo(vorpal);

        // Usar las armas
        espada.blander();
        espada.atacar();
        espada.soltar();

        System.out.println("------");

        martillo.blander();
        martillo.atacar();
        martillo.soltar();

        System.out.println("------");

        // Cambiar el encantamiento de la espada a Vorpal
        espada.cambiarEncantamiento(vorpal);

        espada.blander();
        espada.atacar();
        espada.soltar();
    }
}
