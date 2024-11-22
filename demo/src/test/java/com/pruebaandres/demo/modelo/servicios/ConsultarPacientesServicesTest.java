package com.pruebaandres.demo.modelo.servicios;

import com.pruebaandres.demo.infraestructura.adaptadores.ConsultaPacienteRepository;
import com.pruebaandres.demo.modelo.entidad.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)

public class ConsultarPacientesServicesTest {

    @Mock
    private ConsultaPacienteRepository consultaPacienteRepository;

    @InjectMocks
    private ConsultarPacientesServices consultarPacientesServices;

    @BeforeEach
    public void setUP(){

    }

    @Test
    public void debeColsultarPorCedula(){
        int identificacion = 1002;
        Paciente prueba = new Paciente("Anthony",1002,"Perez",30178,"antho@example.com");
        prueba.setId(1l);

        Mockito.when(consultaPacienteRepository.findByIdentificacion(identificacion)).thenReturn(prueba);

        var resultado = consultarPacientesServices.consultarporcedulaPaciente(identificacion);

        Assertions.assertEquals(resultado.getIdentificacion(),prueba.getIdentificacion());



    }


    @Test
    public void debeConsultarTodosLosPcientes(){
        
        Paciente prueba = new Paciente("Anthony",1002,"Perez",30178,"antho@example.com");
        prueba.setId(1l);

        List<Paciente> listaPacientes = List.of(prueba);

        Mockito.when(consultaPacienteRepository.findAll()).thenReturn(listaPacientes);

        var resultado = consultarPacientesServices.consultarTodoslospacientes();

        Assertions.assertEquals(resultado.get(0).getIdentificacion(),prueba.getIdentificacion());

    }

    @Test
    public void debeConsultarPorNombre(){
        Paciente prueba = new Paciente("Anthony",1002,"Perez",30178,"antho@example.com");
        prueba.setId(1l);

        List<Paciente> listaPacientes1 = List.of(prueba);

        Mockito.when(consultaPacienteRepository.findByNombre(anyString())).thenReturn(listaPacientes1);

        var resultado = consultarPacientesServices.obtenerPacientesPorNombre(anyString());

        Assertions.assertEquals(resultado.get(0).getIdentificacion(),prueba.getIdentificacion());
    }
}
