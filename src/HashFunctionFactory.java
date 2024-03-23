public class HashFunctionFactory {
    public static HashFunction createHashFunction(String hashType) {
        switch (hashType.toLowerCase()) {
            case "organic":
                return new OrganicHash();
            case "md5":
                return new MD5Hash();
            case "sha1":
                return new SHA1Hash();
            default:
                throw new IllegalArgumentException("Tipo de función hash desconocido: " + hashType);
        }
    }
}
