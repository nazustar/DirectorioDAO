package co.edu.distrital.controlador;

import co.edu.distrital.modelo.Directorio;
import co.edu.distrital.modelo.Persona;
import co.edu.distrital.vista.View;

public class Controller {
    private Directorio directorio;
    private View vista;

    public Controller() {
        directorio = new Directorio();
        vista = new View();
    }

    public void run() {
        int opcion;

        do {
            vista.mostrarInformacion("\nDirectorio de personas\n"
                    + "1. Agregar persona\n"
                    + "2. Eliminar persona\n"
                    + "3. Actualizar persona\n"
                    + "4. Buscar persona\n"
                    + "5. Listar personas\n"
                    + "0. Salir");
            opcion = vista.leerEntero("Ingrese una opción:");

            switch (opcion) {
                case 1:
                    agregar();
                    break;
                case 2:
                    eliminar();
                    break;
                case 3:
                    actualizar();
                    break;
                case 4:
                    buscar();
                    break;
                case 5:
                    vista.mostrarInformacion(directorio.listarPersonas());
                    break;
                case 0:
                    break;
                default:
                    vista.mostrarInformacion("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // Pide nombre, teléfono y edad, y arma una Persona completa.
    private Persona leerPersonaCompleta() {
        Persona p = new Persona();
        p.setNombre(vista.leerCadenaCaracteres("Nombre:"));
        p.setTelefono(vista.leerCadenaCaracteres("Teléfono:"));
        p.setEdad(vista.leerEntero("Edad:"));
        return p;
    }

    // Para buscar/eliminar con el teléfono.
    private Persona leerPersonaPorTelefono() {
        Persona p = new Persona();
        p.setTelefono(vista.leerCadenaCaracteres("Teléfono:"));
        return p;
    }

    private void agregar() {
        Persona p = leerPersonaCompleta();
        vista.mostrarInformacion(directorio.adicionarPersona(p));
    }

    private void eliminar() {
        Persona p = leerPersonaPorTelefono();
        vista.mostrarInformacion(directorio.eliminarPersona(p));
    }

    private void actualizar() {
        vista.mostrarInformacion("Teléfono de la persona a actualizar:");
        Persona vieja = leerPersonaPorTelefono();

        vista.mostrarInformacion("Nuevos datos:");
        Persona nueva = leerPersonaCompleta();

        vista.mostrarInformacion(directorio.actualizarPersona(vieja, nueva));
    }

    private void buscar() {
        Persona p = leerPersonaPorTelefono();
        vista.mostrarInformacion(directorio.buscarPersona(p));
    }
}