import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapImplementation<K, V> implements MapImplementation<K, V> {
    private Map<K, V> map;

    public LinkedHashMapImplementation() {
        this.map = new LinkedHashMap<>();
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
