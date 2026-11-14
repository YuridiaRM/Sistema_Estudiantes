
package modelo;
public class Estudiante {
    private String numeroControl;
    private String nombre;
    private String apellidos;
    private String carrera;

    public Estudiante(String numeroControl, String nombre, String apellidos, String carrera) {
        this.numeroControl = numeroControl;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.carrera = carrera;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    @Override
    public String toString() {
        return "No. Control: " + numeroControl + " | Nombre: " + nombre + " " + apellidos + " | Carrera: " + carrera;
    }
}