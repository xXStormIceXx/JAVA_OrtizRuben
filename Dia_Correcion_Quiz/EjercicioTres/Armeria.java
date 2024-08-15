package EjercicioTres;

public class Armeria {

    public Arma crearArma(String tipoHerrero, Encantamiento encantamiento) {
        if (tipoHerrero.equalsIgnoreCase("Elfo")) {
            return new Espada(encantamiento);
        } else if (tipoHerrero.equalsIgnoreCase("Enano")) {
            return new Martillo(encantamiento);
        } else {
            throw new IllegalArgumentException("Tipo de herrero desconocido.");
        }
    }
}
