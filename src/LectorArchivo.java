import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import javax.swing.JOptionPane;

public class LectorArchivo {
    public static void cargarEstudiantes(String archivo, String tipoMapa, String tipoHash, Map<String, Estudiante> mapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            StringBuilder contenidoJSON = new StringBuilder();
            while ((linea = br.readLine()) != null) {
                contenidoJSON.append(linea.trim());
            }

            // Remover los corchetes que rodean el contenido del arreglo JSON
            String jsonSinCorchetes = contenidoJSON.substring(1, contenidoJSON.length() - 1);
            // Dividir el contenido en objetos JSON individuales
            String[] objetosJSON = jsonSinCorchetes.split("\\},\\s*");

            // Recorrer cada objeto JSON
            for (String objJSON : objetosJSON) {
                // Limpiar el objeto JSON
                if (!objJSON.endsWith("}")) {
                    objJSON += "}";
                }

                // Extraer los datos relevantes del objeto JSON
                String[] campos = objJSON.split(",");
                String nombre = null;
                String nacionalidad = null;
                for (String campo : campos) {
                    String[] partes = campo.split(":");
                    String clave = partes[0].trim().replaceAll("\"", "");
                    String valor = partes[1].trim().replaceAll("\"", "");
                    if (clave.equals("name")) {
                        nombre = valor;
                    } else if (clave.equals("country")) {
                        nacionalidad = valor;
                    }
                }

                // Aplicar función hash si es necesario
                String clave;
                if (tipoHash.equals("Orgánica")) {
                    clave = nombre; // Utilizar el nombre como clave directamente
                } else {
                    // Aplicar función hash MD5 o SHA-1
                    HashFunction hashFunction = HashFunctionFactory.createHashFunction(tipoHash);
                    clave = hashFunction.hash(nombre);
                }

                // Crear instancia de Estudiante y agregar al mapa
                if (nombre != null && nacionalidad != null) {
                    Estudiante estudiante = new Estudiante(nombre, nacionalidad);
                    mapa.put(clave, estudiante);
                }
            }
            JOptionPane.showMessageDialog(null, "Estudiantes cargados correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar estudiantes desde el archivo JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
