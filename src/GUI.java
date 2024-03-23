import javax.swing.*;

public class GUI {
    public static String seleccionarTipoMapa() {
        Object[] opciones = {"HashMap", "TreeMap", "LinkedHashMap"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el tipo de mapa a utilizar:",
                "Selección de Tipo de Mapa", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, opciones, opciones[0]);
        switch (seleccion) {
            case 0:
                return "HashMap";
            case 1:
                return "TreeMap";
            case 2:
                return "LinkedHashMap";
            default:
                return "HashMap";
        }
    }

    public static String seleccionarTipoHash() {
        Object[] opciones = {"MD5", "SHA-1", "Orgánica"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el tipo de función hash a utilizar:",
                "Selección de Función Hash", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, opciones, opciones[0]);
        switch (seleccion) {
            case 0:
                return "MD5";
            case 1:
                return "SHA-1";
            case 2:
                return "Orgánica";
            default:
                return "MD5";
        }
    }
}
