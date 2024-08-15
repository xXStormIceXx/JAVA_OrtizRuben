package EjercicioTres;

public class HerreroElfo extends Herrero {
    @Override
    public Arma crearArma(Encantamiento encantamiento) {
        System.out.println("Creando arma élfica...");
        return new Espada(encantamiento);
    }
}