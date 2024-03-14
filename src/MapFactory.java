import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

enum MapType {
    HASH_MAP,
    TREE_MAP,
    LINKED_HASH_MAP
}
public class MapFactory {
    public static <K, V> Map<K, V> createMap(MapType type) {
        switch (type) {
            case HASH_MAP:
                return new HashMap<>();
            case TREE_MAP:
                return new TreeMap<>();
            case LINKED_HASH_MAP:
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Tipo de mapa no válido: " + type);
        }
    }
}
