package com.pruebaandres.demo.modelo.servicios;

import com.pruebaandres.demo.infraestructura.adaptadores.ConsultaPacienteRepository;
import com.pruebaandres.demo.infraestructura.adaptadores.EditarPacienteRepository;
import com.pruebaandres.demo.modelo.entidad.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditarPacientesServices {

    private final EditarPacienteRepository editarPacienteRepository;

    private final ConsultaPacienteRepository consultaPacienteRepository;

    @Autowired
    public EditarPacientesServices(EditarPacienteRepository editarPacienteRepository, ConsultaPacienteRepository consultaPacienteRepository) {
        this.editarPacienteRepository = editarPacienteRepository;
        this.consultaPacienteRepository = consultaPacienteRepository;
    }


    public Paciente editarpaciente(Paciente paciente){

       Optional<Paciente> pacientePrevio = consultaPacienteRepository.findById(paciente.getId());
        if (pacientePrevio.isPresent()){
         Paciente pacienteActualizado= pacientePrevio.get();
         pacienteActualizado.setNombre(paciente.getNombre());
         pacienteActualizado.setApellidos(paciente.getApellidos());
         pacienteActualizado.setEmail(paciente.getEmail());
         pacienteActualizado.setIdentificacion(paciente.getIdentificacion());
         pacienteActualizado.setNumeroTelefono(paciente.getNumeroTelefono());
         return editarPacienteRepository.save(pacienteActualizado);

        }
        return null;
    }
}
