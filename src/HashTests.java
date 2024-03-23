
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class HashTests {
    
    @Test
    public void testOrganicHash() {
        HashFunction hashFunction = new OrganicHash();
        assertEquals("Test de función hash orgánica", "hello", hashFunction.hash("hello"));
    }

    @Test
    public void testMD5Hash() {
        HashFunction hashFunction = new MD5Hash();
        assertEquals("Test de función hash MD5", "5d41402abc4b2a76b9719d911017c592", hashFunction.hash("hello"));
    }

    @Test
    public void testSHA1Hash() {
        HashFunction hashFunction = new SHA1Hash();
        assertEquals("Test de función hash SHA-1", "aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d", hashFunction.hash("hello"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHashType() {
        HashFunctionFactory.createHashFunction("invalid");
    }

    @Test
    public void testHashFunctionFactory() {
        HashFunction hashFunction = HashFunctionFactory.createHashFunction("md5");
        assertEquals("Test de Factory para función hash MD5", "5d41402abc4b2a76b9719d911017c592", hashFunction.hash("hello"));
    }
}
