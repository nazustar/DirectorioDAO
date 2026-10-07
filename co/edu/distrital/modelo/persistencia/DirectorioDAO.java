package co.edu.distrital.modelo.persistencia;

import java.util.ArrayList;

import co.edu.distrital.modelo.Persona;

// DAO: Capa de persistencia de la aplicación.
// Implementa los principios SOLID, aísla las operaciones de la base de datos.

public class DirectorioDAO implements InterfaceDAO<Persona> {

    private  ArrayList<Persona> datos;

    // Constructor del directorio.
    public DirectorioDAO(){
        // Crea un nuevo arregro para almacenar los datos de las personas.
        datos = new ArrayList<Persona>();
    }

    @Override
    public String getAll() {
        // Para crear y modificar cadenas de texto eficientemente.
        StringBuilder sb = new StringBuilder();

        //For each para recorrer las personas.
        for (Persona p: datos){
            sb.append(p);
            sb.append("\n");
        }
        return sb.toString();
    }

    // Método abstracto para agregar personas.
    @Override
    public boolean add(Persona x) {
        //Valida que la persona no tenga el mismo número de teléfono que otro.
        if(find(x) == null){
            datos.add(x);
            return true;
        }
        return false;
    }

    // Método abstracto para eliminar personas.
    @Override
    public boolean delete(Persona x) {
        // Hace una copia de la persona.
        Persona coincidencia = find(x);
        // Valida si la coincidencia NO es nula.
        if(coincidencia!=null){
            // Si la condición se cumple se borrará la persona.
            datos.remove(coincidencia);
            return true;
        }
        return false;
    }

    // Método abstracto para actualizar personas.
    @Override
    public boolean update(Persona x, Persona y) {
        // Asigna el valor anterior y busca el conficto.
        Persona anterior = find(x);
        Persona conflicto = find(y);

        // Si no hay datos en el anterior se retorna false.
        if (anterior == null) {
            return false;
        }

        // Si no coinciden el anterior y el nuevo se retorna falso.
        if (conflicto != null && conflicto != anterior) {
            return false;
        }

        // Si no entra en los if se actualizan los datos.
        anterior.setNombre(y.getNombre());
        anterior.setTelefono(y.getTelefono());
        anterior.setEdad(y.getEdad());
        
        return true;
    }

    // Métoodo abstracto para encontrar persona.
    // Usa el teléfono.
    @Override
    public Persona find(Persona x) {

        Persona encontrada = null;
        
        if (!datos.isEmpty()) {
            for (Persona persona : datos){
                if(x.getTelefono().equals(persona.getTelefono())){
                    encontrada = persona;
                }
            }
        }
        return encontrada;
    }
    
}
