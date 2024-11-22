package com.pruebaandres.demo.infraestructura.adaptadores;

import com.pruebaandres.demo.modelo.entidad.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditarPacienteRepository  extends JpaRepository<Paciente, Long> {


}
