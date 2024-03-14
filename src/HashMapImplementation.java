import java.util.HashMap;
import java.util.Map;

// Clase para la implementación de HashMap
public class HashMapImplementation<K, V> implements MapImplementation<K, V> {
    private Map<K, V> map;

    public HashMapImplementation() {
        this.map = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public int size() {
        return map.size();
    }
}
