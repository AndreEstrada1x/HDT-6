import javax.swing.JOptionPane;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String tipoMapa = GUI.seleccionarTipoMapa();
        String tipoHash = GUI.seleccionarTipoHash();
        Map<String, Estudiante> mapa = MapFactory.createMap(tipoMapa);
        LectorArchivo.cargarEstudiantes("resources/estudiantes.json", tipoMapa, tipoHash, mapa);

        JOptionPane.showMessageDialog(null, "Estudiantes cargados correctamente.");
        Object[] opcionesBusqueda = {"Búsqueda por nombre", "Búsqueda por nacionalidad"};
        int seleccionBusqueda = JOptionPane.showOptionDialog(null, "Seleccione el tipo de búsqueda a realizar:",
                "Opciones de Búsqueda", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, opcionesBusqueda, opcionesBusqueda[0]);
        switch (seleccionBusqueda) {
            case 0:
                String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
                if (mapa.containsKey(nombreBusqueda)) {
                    Estudiante estudiante = mapa.get(nombreBusqueda);
                    JOptionPane.showMessageDialog(null, "Detalles del estudiante:\nNombre: " + estudiante.getNombre() +
                            "\nNacionalidad: " + estudiante.getNacionalidad());
                } else {
                    JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
                }
                break;
            case 1:
                String nacionalidadBusqueda = JOptionPane.showInputDialog("Ingrese la nacionalidad:");
                StringBuilder estudiantesNacionalidad = new StringBuilder();
                for (Map.Entry<String, Estudiante> entry : mapa.entrySet()) {
                    Estudiante estudiante = entry.getValue();
                    if (estudiante.getNacionalidad().equalsIgnoreCase(nacionalidadBusqueda)) {
                        estudiantesNacionalidad.append("Nombre: ").append(estudiante.getNombre()).append(", ");
                    }
                }
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
