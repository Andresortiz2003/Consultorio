package com.pruebaandres.demo.modelo.servicios;

import com.pruebaandres.demo.infraestructura.adaptadores.CrearPacienteRepository;
import com.pruebaandres.demo.modelo.entidad.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CrearPacientesServicesTest {

    @Mock
    private CrearPacienteRepository crearPacienteRepository;

    @InjectMocks
    private CrearPacientesServices crearPacientesServices;

    @BeforeEach
    public void setUP(){

    }

    @Test
    public void debeCrearCorrecto(){
        Paciente prueba = new Paciente("Anthony",1002,"Perz",30178,"antho@example.com");
        prueba.setId(1l);

        Mockito.when(crearPacienteRepository.save(Mockito.any(Paciente.class))).thenReturn(prueba);

        var resultado = crearPacientesServices.crearpaciente(prueba);

        Assertions.assertEquals(resultado.getNombre(),prueba.getNombre());


    }

}
