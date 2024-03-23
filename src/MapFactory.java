import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory {
    public static Map<String, Estudiante> createMap(String mapType) {
        switch (mapType.toLowerCase()) {
            case "hashmap":
                return new HashMap<>();
            case "treemap":
                return new TreeMap<>();
            case "linkedhashmap":
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de mapa desconocido: " + mapType);
        }
    }
}
