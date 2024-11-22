package com.pruebaandres.demo.modelo.servicios;

import com.pruebaandres.demo.infraestructura.adaptadores.ConsultaPacienteRepository;
import com.pruebaandres.demo.modelo.entidad.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultarPacientesServices {

    private final ConsultaPacienteRepository consultaPacienteRepository;
    @Autowired

    public ConsultarPacientesServices(ConsultaPacienteRepository consultaPacienteRepository) {
        this.consultaPacienteRepository = consultaPacienteRepository;
    }

    public Paciente consultarporcedulaPaciente(int identificacion){

        return consultaPacienteRepository.findByIdentificacion(identificacion);
    }

    public List<Paciente> consultarTodoslospacientes(){

        return consultaPacienteRepository.findAll();
    }

    public List<Paciente> obtenerPacientesPorNombre(String nombre){
        return consultaPacienteRepository.findByNombre(nombre);
    }
}
