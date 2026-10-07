package co.edu.distrital.modelo;

import co.edu.distrital.modelo.persistencia.DirectorioDAO;

// Clase del directorio.

public class Directorio {

    // Crea el objeto directorio privado.
    private DirectorioDAO dirDAO;

    // Constructor del directorio que implementa el DAO.
    public Directorio() {
        dirDAO = new DirectorioDAO();
    }
    
    // Usa el metodo del DAO add y retorna la respuesta.
    public String adicionarPersona(Persona x) {
        String rta = "";

        if (dirDAO.add(x)) {
            rta = "Persona agregada correctamente.";
        } else {
            rta = "La persona ya existe en el directorio.";
        }
        return rta;
    }

    // Usa el metodo del DAO delete y retorna la respuesta.
    public String eliminarPersona(Persona x) {
        String rta = "";

        if (dirDAO.delete(x)) {
            rta = "Persona eliminada correctamente.";
        } else {
            rta = "La persona no existe en el directorio.";
        }
        return rta;
    }

    // Usa el metodo del DAO update y retorna la respuesta.
    public String actualizarPersona(Persona x, Persona y) {
        String rta = "";

        if (dirDAO.update(x, y)) {
            rta = "Persona actualizada correctamente.";
        } else {
            rta = "La persona no existe en el directorio o ya existe otra persona con el mismo telefono.";
        }
        return rta;
    }

    // Usa el metodo del DAO find y retorna la respuesta.
    public String buscarPersona(Persona x) {
        String rta = "";
        Persona p = dirDAO.find(x);

        if (p != null) {
            rta = p.toString();
        } else {
            rta = "La persona no existe en el directorio.";
        }
        return rta;
    }

    // Usa el metodo del DAO getAll y retorna la respuesta.
    public String listarPersonas() {
        String rta = dirDAO.getAll();

        if (rta.isEmpty()) {
            rta = "El directorio está vacío.";
        }
        return rta;
    }
}