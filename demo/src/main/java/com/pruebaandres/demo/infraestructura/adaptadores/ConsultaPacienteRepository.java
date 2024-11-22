package com.pruebaandres.demo.infraestructura.adaptadores;

import com.pruebaandres.demo.modelo.entidad.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaPacienteRepository extends JpaRepository<Paciente, Long> {

    Paciente findByIdentificacion(int identificacion);

    Paciente findByNumeroTelefono(int numeroTelefono);

    List<Paciente> findByNombre(String nombre);
}
