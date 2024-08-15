package EjercicioUno;
Singleton Pattern for Hero public class Hero {
    private static Hero instance;
    private Hero() {}
}
public static Hero getInstance() {
    if (instance == null) { instance = new Hero();
    } return instance;
}