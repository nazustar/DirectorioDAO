package co.edu.distrital.modelo;

// Estructura de persona para el directorio.

public class Persona {
    
    // Datos a almacenar.
    private String nombre;
    private String telefono;
    private int edad;

    // Definición de datos por defecto.
    // No se usa un constructror para evitar requerir todos los datos.
    public Persona() {
        this.nombre = "";
        this.telefono = "";
        this.edad = 0;
    }

    // Getters y setters.
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Convierte el objeto persona a una cadena de texto.
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Teléfono: " + telefono;
    }
}