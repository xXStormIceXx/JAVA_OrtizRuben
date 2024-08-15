package EjercicioTres;

public class HerreroEnano extends Herrero {
    @Override
    public Arma crearArma(Encantamiento encantamiento) {
        System.out.println("Creando arma enana...");
        return new Martillo(encantamiento);
    }
}