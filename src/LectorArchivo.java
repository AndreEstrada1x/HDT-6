import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LectorArchivo {
    private Map<String, Estudiante> mapaEstudiantes;

    public LectorArchivo() {
        this.mapaEstudiantes = new HashMap<>();
    }

    public void leerArchivo(String nombreArchivo) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
            String[] estudiantesArray = jsonData.split("\\},\\s*\\{");
            
            for (String estudianteData : estudiantesArray) {
                Estudiante estudiante = parseEstudiante(estudianteData);
                mapaEstudiantes.put(estudiante.getPostalZip(), estudiante);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Estudiante parseEstudiante(String estudianteData) {
        // Eliminamos los caracteres de inicio y fin del objeto JSON
        estudianteData = estudianteData.replaceAll("\\{\\s*", "");
        estudianteData = estudianteData.replaceAll("\\s*\\}", "");
        
        // Dividimos los campos del estudiante basándonos en las comas
        String[] campos = estudianteData.split(",\\s*");
        
        // Creamos un nuevo objeto Estudiante para almacenar los datos
        Estudiante estudiante = new Estudiante();
        
        // Iteramos sobre los campos y los asignamos al estudiante
        for (String campo : campos) {
            // Dividimos el campo en clave y valor basándonos en los dos puntos
            String[] partes = campo.split(":\\s*");
            String clave = partes[0];
            String valor = partes[1];
            
            // Eliminamos las comillas que rodean al valor
            valor = valor.replaceAll("\"", "");
            
            // Asignamos el valor al campo correspondiente del estudiante
            switch (clave) {
                case "name":
                    estudiante.setNombre(valor);
                    break;
                case "phone":
                    estudiante.setTelefono(valor);
                    break;
                case "email":
                    estudiante.setEmail(valor);
                    break;
                case "postalZip":
                    estudiante.setPostalZip(valor);
                    break;
                case "country":
                    estudiante.setPais(valor);
                    break;
                default:
                    // No hacemos nada para campos desconocidos
                    break;
            }
        }
        
        return estudiante;
    }    

    public Estudiante buscarEstudiante(String postalZip) {
        return mapaEstudiantes.get(postalZip);
    }
}
