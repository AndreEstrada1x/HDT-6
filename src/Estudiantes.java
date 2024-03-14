import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;

// Clase para representar los datos de los estudiantes
public class Estudiantes {
    private List<Estudiante> estudiantes;

    // Constructor
    public Estudiantes() {
        estudiantes = new ArrayList<>();
    }

    // Método para agregar un estudiante a la lista
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void cargarDesdeJson(String archivoJson) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(archivoJson)));
            String[] estudiantesArray = jsonData.split("\\},\\s*\\{");
            this.estudiantes = new ArrayList<>();
            for (String estudianteData : estudiantesArray) {
                Estudiante estudiante = parseEstudiante(estudianteData);
                this.estudiantes.add(estudiante);
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

    // Método para guardar a los estudiantes por nacionalidad en un mapa
    public Map<String, List<Estudiante>> guardarPorNacionalidad() {
        Map<String, List<Estudiante>> mapaPorNacionalidad = new HashMap<>();

        for (Estudiante estudiante : estudiantes) {
            String nacionalidad = estudiante.getPais();
            List<Estudiante> estudiantesNacionalidad = mapaPorNacionalidad.getOrDefault(nacionalidad, new ArrayList<>());
            estudiantesNacionalidad.add(estudiante);
            mapaPorNacionalidad.put(nacionalidad, estudiantesNacionalidad);
        }

        return mapaPorNacionalidad;
    }

    public Estudiante buscarPorPostalZip(String postalZip) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getPostalZip().equals(postalZip)) {
                return estudiante;
            }
        }
        return null; // Si no se encuentra ningún estudiante con el postalZip especificado
    }


    // Otros métodos para buscar estudiantes, etc.
}
