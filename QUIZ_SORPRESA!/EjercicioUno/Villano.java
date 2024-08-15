package EjercicioUno;

Factory Method Pattern for Villains import java.util.HashMap;
import java.util.Map;
public class VillainFactory { private static final int MAX_VILLAINS = 5;
    private Map<String, Integer> villainCount = new HashMap<>();
    public Villain createVillain(String type) throws Exception { if (villainCount.getOrDefault(type, 0) >= MAX_VILLAINS) { throw new Exception("Max limit reached for this type of Villain.");
    } villainCount.put(type, villainCount.getOrDefault(type, 0) + 1);
        return new Villain(type); }