// Interfaz para la implementación de mapas
public interface MapImplementation<K, V> {
    void put(K key, V value);
    V get(K key);
    int size();
}
