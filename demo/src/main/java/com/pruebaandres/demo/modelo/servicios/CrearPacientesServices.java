package com.pruebaandres.demo.modelo.servicios;

import com.pruebaandres.demo.infraestructura.adaptadores.CrearPacienteRepository;
import com.pruebaandres.demo.modelo.entidad.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearPacientesServices {


    private final CrearPacienteRepository crearPacienteRepository;

    @Autowired
    public CrearPacientesServices(CrearPacienteRepository crearPacienteRepository) {
        this.crearPacienteRepository = crearPacienteRepository;


    }

    public Paciente crearpaciente (Paciente paciente){

        return crearPacienteRepository.save(paciente);

    }
}
