package com.pruebaandres.demo.modelo.servicios;

import com.pruebaandres.demo.infraestructura.adaptadores.ConsultaPacienteRepository;
import com.pruebaandres.demo.infraestructura.adaptadores.ElimnarPacienteRepository;
import com.pruebaandres.demo.modelo.entidad.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EliminarPacientesServices {

    private final ElimnarPacienteRepository elimnarPacienteRepository;
    private final ConsultaPacienteRepository consultaPacienteRepository;

    @Autowired
    public EliminarPacientesServices(ElimnarPacienteRepository elimnarPacienteRepository, ConsultaPacienteRepository consultaPacienteRepository) {
        this.elimnarPacienteRepository = elimnarPacienteRepository;
        this.consultaPacienteRepository = consultaPacienteRepository;
    }


    public Boolean eliminarpaciente(int numeroTelefono) {

        Optional<Paciente> pacientePrevio = Optional.ofNullable(consultaPacienteRepository.findByNumeroTelefono(numeroTelefono));
        if (pacientePrevio.isPresent()) {
            elimnarPacienteRepository.delete(pacientePrevio.get());
            return true;
        }

        return false;
    }
}

