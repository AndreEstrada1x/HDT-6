import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Interfaz para las funciones hash
public interface HashFunction {
    String hash(String input);
}

// Implementación de la función hash orgánica
class OrganicHashFunction implements HashFunction {
    @Override
    public String hash(String input) {
        // Devolver el mismo dato como llave
        return input;
    }
}

// Implementación de la función hash MD5
class MD5HashFunction implements HashFunction {
    @Override
    public String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            // Convertir el array de bytes a representación hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Implementación de la función hash SHA-1
class SHA1HashFunction implements HashFunction {
    @Override
    public String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            // Convertir el array de bytes a representación hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

