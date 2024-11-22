package com.pruebaandres.demo.modelo.servicios;

import com.pruebaandres.demo.infraestructura.adaptadores.ConsultaPacienteRepository;
import com.pruebaandres.demo.infraestructura.adaptadores.EditarPacienteRepository;
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
import static org.mockito.MockitoAnnotations.initMocks;

@ExtendWith(MockitoExtension.class)
public class EditarPacientesServicesTest {

    @Mock
    private EditarPacienteRepository editarPacienteRepository;

    @Mock
    private ConsultaPacienteRepository consultaPacienteRepository;

    @InjectMocks
    private EditarPacientesServices editarPacientesServices;

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void debeEditarCorrecto(){
        Paciente prueba = new Paciente("norma",1,"navarro",30077,"nn@example.com");
        prueba.setId(1l);
        Paciente prueba1 = new Paciente("andres",20,"navarro",377,"an@example.com");
        prueba1.setId(1l);
        var pacieteprevio = Optional.of(prueba);

        Mockito.when(consultaPacienteRepository.findById(Mockito.anyLong())).thenReturn(pacieteprevio);
        Mockito.when(editarPacienteRepository.save(Mockito.any(Paciente.class))).thenReturn(prueba1);

        var resultado= editarPacientesServices.editarpaciente(prueba1);

        Assertions.assertEquals(resultado.getNombre(),prueba1.getNombre());
    }
    @Test
    public void debeEditarFallando(){
        Paciente prueba = new Paciente("norma",1,"navarro",30077,"nn@example.com");
        prueba.setId(1l);
        Paciente prueba1 = new Paciente("andres",20,"navarro",377,"an@example.com");
        prueba1.setId(1l);
        var pacieteprevio = Optional.of(prueba);
        Mockito.when(consultaPacienteRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        var resultado= editarPacientesServices.editarpaciente(prueba1);

        Assertions.assertNull(resultado);
    }
}
