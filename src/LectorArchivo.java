import java.io.FileReader;
import java.util.Map;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LectorArchivo {
    public static void cargarEstudiantes(String archivo, String tipoMapa, String tipoHash, Map<String, Estudiante> mapa) {
        try (FileReader reader = new FileReader(archivo)) {
            JSONParser parser = new JSONParser();
            JSONArray estudiantesArray = (JSONArray) parser.parse(reader);

            for (Object obj : estudiantesArray) {
                JSONObject estudianteJSON = (JSONObject) obj;
                String nombre = (String) estudianteJSON.get("name");
                String nacionalidad = (String) estudianteJSON.get("country");

                String clave;
                if (tipoHash.equals("Orgánica")) {
                    clave = tipoMapa.equals("Nombre") ? nombre : nacionalidad;
                } else {
                    HashFunction hashFunction = HashFunctionFactory.createHashFunction(tipoHash);
                    clave = hashFunction.hash(tipoMapa.equals("Nombre") ? nombre : nacionalidad);
                }

                Estudiante estudiante = new Estudiante(nombre, nacionalidad);
                mapa.put(clave, estudiante);
            }
            JOptionPane.showMessageDialog(null, "Estudiantes cargados correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar estudiantes desde el archivo JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

