package EjercicioUno;

import java.util.HashMap;
import java.util.Map;

public class Villano extends Personaje {
    private static final int LIMITE_INSTANCIAS = 5;
    private static final Map<String, Integer> contadorInstancias = new HashMap<>();

    public Villano(String nombre, int poder) throws Exception {
        super(nombre, poder);

        if (contadorInstancias.getOrDefault(nombre, 0) >= LIMITE_INSTANCIAS) {
            throw new Exception("No se pueden crear más de " + LIMITE_INSTANCIAS + " villanos del tipo " + nombre);
        }

        contadorInstancias.put(nombre, contadorInstancias.getOrDefault(nombre, 0) + 1);
    }

    @Override
    public void usarHabilidadEspecial() {
        System.out.println(nombre + " usa su habilidad especial de Villano!");
    }
}
