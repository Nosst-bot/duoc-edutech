package com.edutech.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.edutech.model.Persona;
import com.edutech.edutech.repository.PersonaRepository;
//Fernando Huamanchumo
@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    //Metodo guardar Persona
    public String guardarPersona(Persona persona){
        if (persona.getRut() == null || persona.getRut().trim().isEmpty()) {
        return "El RUT no puede estar vacío.";
    }
        Persona validacion = personaRepository.findByRut(persona.getRut());
        if (validacion == null) {
            personaRepository.save(persona);
            return "Persona almacenada correctamente";
        }else {
            return "Persona con Rut: " + persona.getRut() + ", ya se encuentra ingresada";
    }
}

    public String buscarPorRut(String rut){
        Persona persona = personaRepository.findByRut(rut);

        if(persona == null) {
            return "No se encontro una persona con RUT: " + rut;
        }else{
            return "Persona encontrada: " + persona.getNombre() + " " + persona.getApellido();
        }
    }
    public String eliminarPorRut(String rut) {
        Persona persona = personaRepository.findByRut(rut);

        if (persona == null) {
            return "No se puede eliminar. No existe persona con RUT: " + rut;
        }else{
            personaRepository.delete(persona);
            return "Persona con RUT: " + rut + " eliminada correctamente. ";
        }
    }
    public List<Persona> listar(){
        return personaRepository.findAll();
    }
}
