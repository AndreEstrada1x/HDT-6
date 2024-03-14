import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class LectorArchivo {
    private Map<String, Estudiante> mapaEstudiantes;

    // Constructor que toma un tipo de mapa y crea una instancia usando el Factory
    public LectorArchivo(MapType mapType) {
        // Crear una instancia de la implementación del mapa utilizando el Factory
        Map<String, Estudiante> map = MapFactory.createMap(mapType);
        this.mapaEstudiantes = map;
    }

    // Método para leer desde el archivo y guardar a los estudiantes en el mapa
    public void leerArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Aquí debes procesar cada línea y crear objetos Estudiante
                // Luego, puedes agregar los estudiantes al mapa utilizando el nombre como clave
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
