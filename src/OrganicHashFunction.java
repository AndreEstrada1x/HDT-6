public class OrganicHashFunction implements HashFunction {
    @Override
    public String hash(String input) {
        // Devolver el mismo dato como llave
        return input;
    }
}
