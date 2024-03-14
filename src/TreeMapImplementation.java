import java.util.Map;
import java.util.TreeMap;

public class TreeMapImplementation<K, V> implements MapImplementation<K, V> {
    private Map<K, V> map;

    public TreeMapImplementation() {
        this.map = new TreeMap<>();
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
