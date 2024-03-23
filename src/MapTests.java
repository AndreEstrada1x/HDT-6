import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;

public class MapTests {
    @Test
    public void testHashMap() {
        // Test HashMap
        Map<String, Estudiante> hashMap = MapFactory.createMap("HashMap");
        assertNotNull(hashMap);
        assertTrue(hashMap.isEmpty());

        // Agregar estudiantes
        Estudiante estudiante1 = new Estudiante("Juan", "España");
        Estudiante estudiante2 = new Estudiante("Maria", "Francia");
        hashMap.put("clave1", estudiante1);
        hashMap.put("clave2", estudiante2);

        // Verificar tamaño
        assertEquals(2, hashMap.size());
        // Verificar si contiene las claves
        assertTrue(hashMap.containsKey("clave1"));
        assertTrue(hashMap.containsKey("clave2"));
    }

    @Test
    public void testTreeMap() {
        // Test TreeMap
        Map<String, Estudiante> treeMap = MapFactory.createMap("TreeMap");
        assertNotNull(treeMap);
        assertTrue(treeMap.isEmpty());

        // Agregar estudiantes
        Estudiante estudiante1 = new Estudiante("Juan", "España");
        Estudiante estudiante2 = new Estudiante("Maria", "Francia");
        treeMap.put("clave1", estudiante1);
        treeMap.put("clave2", estudiante2);

        // Verificar tamaño
        assertEquals(2, treeMap.size());
        // Verificar si contiene las claves
        assertTrue(treeMap.containsKey("clave1"));
        assertTrue(treeMap.containsKey("clave2"));
    }

    @Test
    public void testLinkedHashMap() {
        // Test LinkedHashMap
        Map<String, Estudiante> linkedHashMap = MapFactory.createMap("LinkedHashMap");
        assertNotNull(linkedHashMap);
        assertTrue(linkedHashMap.isEmpty());

        // Agregar estudiantes
        Estudiante estudiante1 = new Estudiante("Juan", "España");
        Estudiante estudiante2 = new Estudiante("Maria", "Francia");
        linkedHashMap.put("clave1", estudiante1);
        linkedHashMap.put("clave2", estudiante2);

        // Verificar tamaño
        assertEquals(2, linkedHashMap.size());
        // Verificar si contiene las claves
        assertTrue(linkedHashMap.containsKey("clave1"));
        assertTrue(linkedHashMap.containsKey("clave2"));
    }
}
