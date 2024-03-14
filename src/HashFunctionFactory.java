public class HashFunctionFactory {
    // Método para crear instancias de funciones hash según el tipo especificado
    public static HashFunction createHashFunction(String type) {
        switch (type) {
            case "organic":
                return new OrganicHashFunction();
            case "MD5":
                return new MD5HashFunction();
            default:
                throw new IllegalArgumentException("Tipo de función hash no válido: " + type);
        }
    }
}
