
package estructuras;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import modelo.Nodo;

public class ListaEnlazada {
    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }
    public void registrarEstudiante(Estudiante estudiante) {
        Nodo nuevoNodo = new Nodo(estudiante);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        JOptionPane.showMessageDialog(null, "Estudiante registrado exitosamente.");
    }
    public void eliminarEstudiante(String numeroControl) {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return;
        }

        if (cabeza.getEstudiante().getNumeroControl().equals(numeroControl)) {
            cabeza = cabeza.getSiguiente();
            JOptionPane.showMessageDialog(null, "Estudiante eliminado.");
            return;
        }

        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null && !actual.getEstudiante().getNumeroControl().equals(numeroControl)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (actual == null) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
            return;
        }

        anterior.setSiguiente(actual.getSiguiente());
        JOptionPane.showMessageDialog(null, "Estudiante eliminado.");
    }
    public void mostrarLista() {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "La lista de estudiantes está vacía.");
            return;
        }

        StringBuilder sb = new StringBuilder("--- Lista de Estudiantes ---\n\n");
        Nodo actual = cabeza;
        while (actual != null) {
            sb.append(actual.getEstudiante().toString()).append("\n");
            actual = actual.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
   
}