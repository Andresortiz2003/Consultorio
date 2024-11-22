package com.pruebaandres.demo.infrestructura.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebaandres.demo.infraestructura.controlador;
import com.pruebaandres.demo.modelo.entidad.Paciente;
import com.pruebaandres.demo.modelo.servicios.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(controlador.class)
class ControladorIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsultarPacientesServices consultarPacientesServices;

    @MockBean
    private CrearPacientesServices crearPacientesServices;

    @MockBean
    private EditarPacientesServices editarPacientesServices;

    @MockBean
    private EliminarPacientesServices eliminarPacientesServices;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void consultarPoridentificacionTest() throws Exception {
        // Arrange
        Paciente paciente = new Paciente("Anthony",1002,"Perez",30178,"antho@example.com");
        paciente.setId(1l);
        when(consultarPacientesServices.consultarporcedulaPaciente(12345)).thenReturn(paciente);

        // Act & Assert
        mockMvc.perform(get("/consultorio/12345"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Anthony"))
                .andExpect(jsonPath("$.apellidos").value("Perez"))
                .andExpect(jsonPath("$.email").value("antho@example.com"));

        verify(consultarPacientesServices, times(1)).consultarporcedulaPaciente(12345);
    }

   @Test
    void buscarPorNombreTest() throws Exception {
        // Arrange
        List<Paciente> paciente = List.of(
                new Paciente("Anthony", 1002, "Perez", 30178, "antho@example.com"));

       when(consultarPacientesServices.obtenerPacientesPorNombre("Anthony")).thenReturn(paciente);

        // Act & Assert
        mockMvc.perform(get("/consultorio/buscarpornombre/Anthony"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Anthony"))
                .andExpect(jsonPath("$[0].apellidos").value("Perez"))
                .andExpect(jsonPath("$[0].email").value("antho@example.com"));

        verify(consultarPacientesServices, times(1)).obtenerPacientesPorNombre("Anthony");
    }

    @Test
    void consultarTodosTest() throws Exception {
        // Arrange
        List<Paciente> paciente = List.of(
                new Paciente( "Anthony", 1002, "Perez", 30178, "antho@example.com"));

        when(consultarPacientesServices.consultarTodoslospacientes()).thenReturn(paciente);

        // Act & Assert
        mockMvc.perform(get("/consultorio/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Anthony"))
                .andExpect(jsonPath("$[0].apellidos").value("Perez"))
                .andExpect(jsonPath("$[0].email").value("antho@example.com"));

        verify(consultarPacientesServices, times(1)).consultarTodoslospacientes();
    }

    @Test
    void crearTest() throws Exception {
        // Arrange
        Paciente paciente = new Paciente( "Ana",1234, "Lopez", 67890, "ana@example.com");
        when(crearPacientesServices.crearpaciente(Mockito.any(Paciente.class))).thenReturn(paciente);

        // Act & Assert
        mockMvc.perform(post("/consultorio/crear")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paciente)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Ana"))
                .andExpect(jsonPath("$.apellidos").value("Lopez"));

        verify(crearPacientesServices, times(1)).crearpaciente(Mockito.any(Paciente.class));
    }

    @Test
    void eliminarPornumerotelefonoTest() throws Exception {
        // Arrange
        when(eliminarPacientesServices.eliminarpaciente(12345)).thenReturn(true);

        // Act & Assert
        mockMvc.perform(delete("/consultorio/12345"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        verify(eliminarPacientesServices, times(1)).eliminarpaciente(12345);
    }

    @Test
    void editarPacienteTest() throws Exception {
        // Arrange
        Paciente paciente = new Paciente("Juan", 2345, "Perez", 12345, "juan@example.com");
        when(editarPacientesServices.editarpaciente(Mockito.any(Paciente.class))).thenReturn(paciente);

        // Act & Assert
        mockMvc.perform(put("/consultorio/editar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paciente)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.apellidos").value("Perez"));

        verify(editarPacientesServices, times(1)).editarpaciente(Mockito.any(Paciente.class));
    }
}
