import javax.swing.JOptionPane;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Mostrar opciones para seleccionar tipo de mapa y tipo de hash
        String tipoMapa = GUI.seleccionarTipoMapa();
        String tipoHash = GUI.seleccionarTipoHash();

        // Crear mapa seleccionado por el usuario
        Map<String, Estudiante> mapa = MapFactory.createMap(tipoMapa);

        // Cargar estudiantes desde el archivo JSON al mapa
        LectorArchivo.cargarEstudiantes("resources/estudiantes.json", tipoMapa, tipoHash, mapa);

        // Mostrar mensaje de carga exitosa y opciones de búsqueda
        JOptionPane.showMessageDialog(null, "Estudiantes cargados correctamente.");

        // Mostrar opciones de búsqueda
        Object[] opcionesBusqueda = {"Búsqueda por nombre", "Búsqueda por nacionalidad"};
        int seleccionBusqueda = JOptionPane.showOptionDialog(null, "Seleccione el tipo de búsqueda a realizar:",
                "Opciones de Búsqueda", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, opcionesBusqueda, opcionesBusqueda[0]);

        // Realizar la búsqueda seleccionada por el usuario
        switch (seleccionBusqueda) {
            case 0:
                // Búsqueda por nombre
                String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
                // Verificar si el nombre está en el mapa y mostrar los detalles del estudiante
                if (mapa.containsKey(nombreBusqueda)) {
                    Estudiante estudiante = mapa.get(nombreBusqueda);
                    JOptionPane.showMessageDialog(null, "Detalles del estudiante:\nNombre: " + estudiante.getNombre() +
                            "\nNacionalidad: " + estudiante.getNacionalidad());
                } else {
                    JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                }
                break;
            case 1:
                // Búsqueda por nacionalidad
                String nacionalidadBusqueda = JOptionPane.showInputDialog("Ingrese la nacionalidad:");
                // Verificar si la nacionalidad está en el mapa y mostrar los detalles de los estudiantes
                StringBuilder estudiantesNacionalidad = new StringBuilder();
                for (Map.Entry<String, Estudiante> entry : mapa.entrySet()) {
                    Estudiante estudiante = entry.getValue();
                    if (estudiante.getNacionalidad().equalsIgnoreCase(nacionalidadBusqueda)) {
                        estudiantesNacionalidad.append("Nombre: ").append(estudiante.getNombre()).append(", ");
                    }
                }
                // Mostrar los estudiantes encontrados con la nacionalidad especificada
                if (estudiantesNacionalidad.length() > 0) {
                    JOptionPane.showMessageDialog(null, "Estudiantes con nacionalidad " + nacionalidadBusqueda + ":\n" +
                            estudiantesNacionalidad.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron estudiantes con la nacionalidad especificada.");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
                break;
        }
    }
}
