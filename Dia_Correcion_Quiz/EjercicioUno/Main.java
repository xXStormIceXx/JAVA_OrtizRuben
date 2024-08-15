package EjercicioUno;

public class Main {
    public static void main(String[] args) {
        // Crear el Héroe
        Heroe heroe = Heroe.getInstancia("Superman", 100);
        heroe.mostrarInformacion();
        heroe.usarHabilidadEspecial();

        // Intentar crear otro Héroe (debería devolver la misma instancia)
        Heroe otroHeroe = Heroe.getInstancia("Batman", 90);
        otroHeroe.mostrarInformacion(); // Esto mostrará "Superman", no "Batman"

        // Crear Villanos
        try {
            Villano villano1 = new Villano("Joker", 80);
            Villano villano2 = new Villano("Joker", 75);
            Villano villano3 = new Villano("Joker", 70);
            Villano villano4 = new Villano("Joker", 85);
            Villano villano5 = new Villano("Joker", 90);
            // Este lanzará una excepción
            Villano villano6 = new Villano("Joker", 65);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
