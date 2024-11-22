package com.pruebaandres.demo.infraestructura;

import com.pruebaandres.demo.modelo.entidad.Paciente;
import com.pruebaandres.demo.modelo.servicios.ConsultarPacientesServices;
import com.pruebaandres.demo.modelo.servicios.CrearPacientesServices;
import com.pruebaandres.demo.modelo.servicios.EditarPacientesServices;
import com.pruebaandres.demo.modelo.servicios.EliminarPacientesServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorio")

public class controlador {

    private ConsultarPacientesServices consultarPacientesServices;
    private CrearPacientesServices crearPacientesServices;
    private EditarPacientesServices editarPacientesServices;
    private EliminarPacientesServices eliminarPacientesServices;

    public controlador(ConsultarPacientesServices consultarPacientesServices,
                       CrearPacientesServices crearPacientesServices,
                       EditarPacientesServices editarPacientesServices,
                       EliminarPacientesServices eliminarPacientesServices) {
        this.consultarPacientesServices = consultarPacientesServices;
        this.crearPacientesServices = crearPacientesServices;
        this.editarPacientesServices = editarPacientesServices;
        this.eliminarPacientesServices = eliminarPacientesServices;
    }

    @GetMapping(value = "/{identificacion}")
    public ResponseEntity<Paciente> consultarPoridentifiacion(@PathVariable int identificacion){

        return new ResponseEntity<>(consultarPacientesServices.consultarporcedulaPaciente(identificacion),null,HttpStatus.OK);
    }
    @GetMapping("/buscarpornombre/{nombre}" )
    public ResponseEntity<List<Paciente>> buscarPorNombre(@PathVariable String nombre) {

        return new ResponseEntity<>(consultarPacientesServices.obtenerPacientesPorNombre(nombre),null,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Paciente>> consultarTodos(){
        return new ResponseEntity<>(consultarPacientesServices.consultarTodoslospacientes(),null,HttpStatus.OK);
    }
    @PostMapping(value = "/crear")
    public ResponseEntity <Paciente> crear(@RequestBody Paciente paciente) {

        return new ResponseEntity<>(crearPacientesServices.crearpaciente(paciente),null,HttpStatus.OK);
    }
    @DeleteMapping(value = "/{numeroTelefono}")
    public ResponseEntity<Boolean> eliminarPornumerotelefono(@PathVariable int numeroTelefono){
        return new ResponseEntity<>(eliminarPacientesServices.eliminarpaciente(numeroTelefono),null,HttpStatus.OK);
    }
    @PutMapping(value ="/editar")
    public ResponseEntity<Paciente> editarPaciente (@RequestBody Paciente paciente){
        return new ResponseEntity<>(editarPacientesServices.editarpaciente(paciente),null, HttpStatus.OK );
    }
}

