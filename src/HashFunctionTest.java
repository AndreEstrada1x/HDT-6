
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HashFunctionTest {
    
    // Prueba unitaria para la función hash orgánica
    @Test
    public void testOrganicHashFunction() {
        HashFunction hashFunction = new OrganicHashFunction();
        String input = "Hola Mundo";
        String expectedHash = "Hola Mundo";
        assertEquals(expectedHash, hashFunction.hash(input));
    }

    // Prueba unitaria para la función hash MD5
    @Test
    public void testMD5HashFunction() {
        HashFunction hashFunction = new MD5HashFunction();
        String input = "Hola Mundo";
        String expectedHash = "3e25960a79dbc69b674cd4ec67a72c62";
        assertEquals(expectedHash, hashFunction.hash(input));
    }

    // Prueba unitaria para la función hash SHA-1 (requiere implementación)
    @Test
    public void testSHA1HashFunction() {
        HashFunction hashFunction = new SHA1HashFunction();
        String input = "Hola Mundo";
        // Ajusta el valor esperado según la implementación de SHA-1
        String expectedHash = ""; 
        assertEquals(expectedHash, hashFunction.hash(input));
    }
}
