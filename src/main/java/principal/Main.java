
package principal;

import estructuras.ListaEnlazada;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.awt.Color;
import modelo.Estudiante;

public class Main {
    public static void main(String[] args) {
        UIManager.put("OptionPane.background", new ColorUIResource(Color.decode("#F8C8DC")));
        UIManager.put("Panel.background", new ColorUIResource(Color.decode("#F8C8DC")));

        ListaEnlazada lista = new ListaEnlazada();
        int opcion = 0;

        String menu = "Menú de Opciones:\n\n"
                    + "1. Registrar un Estudiante\n"
                    + "2. Eliminar un Estudiante\n"
                    + "3. Mostrar lista de Estudiantes\n"
                    + "4. Salir\n\n"
                    + "Elige una opción:";

        do {
            try {
                String input = JOptionPane.showInputDialog(null, menu, "Gestión de Estudiantes", JOptionPane.PLAIN_MESSAGE);
                
                if (input == null) break;
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        String numControl = JOptionPane.showInputDialog("Ingresa el Número de Control:");
                        if (numControl != null && !numControl.trim().isEmpty()) {
                            String nombre = JOptionPane.showInputDialog("Ingresa el Nombre:");
                            String apellidos = JOptionPane.showInputDialog("Ingresa los Apellidos:");
                            String carrera = JOptionPane.showInputDialog("Ingresa la Carrera:");
                            
                            Estudiante nuevoEstudiante = new Estudiante(numControl, nombre, apellidos, carrera);
                            lista.registrarEstudiante(nuevoEstudiante);
                        }
                        break;
                    case 2:
                        String numControlEliminar = JOptionPane.showInputDialog("Ingresa el Número de Control del estudiante a eliminar:");
                        if (numControlEliminar != null && !numControlEliminar.trim().isEmpty()) {
                            lista.eliminarEstudiante(numControlEliminar);
                        }
                        break;
                    case 3:
                        lista.mostrarLista();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intenta de nuevo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
            }
        } while (opcion != 4);
    }
}
