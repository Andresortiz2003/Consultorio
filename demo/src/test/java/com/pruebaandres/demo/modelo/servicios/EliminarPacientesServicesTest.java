package com.pruebaandres.demo.modelo.servicios;

import com.pruebaandres.demo.infraestructura.adaptadores.ConsultaPacienteRepository;
import com.pruebaandres.demo.infraestructura.adaptadores.ElimnarPacienteRepository;
import com.pruebaandres.demo.modelo.entidad.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EliminarPacientesServicesTest  {

    @Mock
    private ElimnarPacienteRepository elimnarPacienteRepository;

    @Mock
    private ConsultaPacienteRepository consultaPacienteRepository;

    @InjectMocks
    private EliminarPacientesServices eliminarPacientesServices;

    @BeforeEach
    public void setUP(){

    }

    @Test
    public void debeEliminarCorrecto(){
        int numeroTelefono = 30178;
        Paciente prueba = new Paciente("Anthony",1002,"Perz",30178,"antho@example.com");
        prueba.setId(1l);

        var pacieteprevio = Optional.of(prueba);

        Mockito.when(consultaPacienteRepository.findByNumeroTelefono(numeroTelefono)).thenReturn(prueba);

        var resultado = eliminarPacientesServices.eliminarpaciente(numeroTelefono);

        Assertions.assertTrue(resultado);

    }
    @Test
    public void noDebeEliminarCorrecto(){
        int numeroTelefono = 30178;
        Paciente prueba;

        //var pacieteprevio = Optional.of(prueba);

        Mockito.when(consultaPacienteRepository.findByNumeroTelefono(numeroTelefono)).thenReturn(Mockito.nullable(Paciente.class));

        var resultado = eliminarPacientesServices.eliminarpaciente(numeroTelefono);

        Assertions.assertFalse(resultado);

    }
}
