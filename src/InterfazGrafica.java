import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGrafica {
    private static Estudiantes estudiantes = new Estudiantes();
    private static LectorArchivo lector = new LectorArchivo();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Programa de búsqueda de estudiantes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblMapType = new JLabel("Seleccione el tipo de Mapa:");
        JComboBox<String> mapTypeComboBox = new JComboBox<>(new String[]{"HashMap", "TreeMap", "LinkedHashMap"});
        JLabel lblHashFunction = new JLabel("Seleccione la función Hash:");
        JComboBox<String> hashFunctionComboBox = new JComboBox<>(new String[]{"MD5", "SHA-1", "Orgánica"});

        JButton loadDataButton = new JButton("Cargar Datos");
        loadDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implementar la lógica para cargar los datos desde el archivo JSON
                JOptionPane.showMessageDialog(frame, "Datos cargados desde el archivo JSON");
                lector.leerArchivo("estudiantes.json");
            }
        });

        JButton searchButton = new JButton("Buscar");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implementar la lógica para la búsqueda de estudiantes
                String postalZipSeleccionado = JOptionPane.showInputDialog(frame, "Ingrese el postalZip a buscar:");
                Estudiante estudiante = estudiantes.buscarPorPostalZip(postalZipSeleccionado);
                if (estudiante != null) {
                    JOptionPane.showMessageDialog(frame, "Estudiante encontrado:\n" + estudiante);
                } else {
                    JOptionPane.showMessageDialog(frame, "Estudiante no encontrado");
                }
            }
        });

        panel.add(lblMapType);
        panel.add(mapTypeComboBox);
        panel.add(lblHashFunction);
        panel.add(hashFunctionComboBox);
        panel.add(loadDataButton);
        panel.add(searchButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
