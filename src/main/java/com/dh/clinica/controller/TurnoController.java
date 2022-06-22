package com.dh.clinica.controller;


import com.dh.clinica.dao.impl.DomicilioDaoH2;
import com.dh.clinica.dao.impl.OdontologoDaoH2;
import com.dh.clinica.dao.impl.PacienteDaoH2;
import com.dh.clinica.dao.impl.TurnoListRepository;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.model.Turno;
import com.dh.clinica.service.OdontologoService;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    private TurnoService turnoService = new TurnoService(new TurnoListRepository());

    @Autowired
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2(new DomicilioDaoH2()));

    @Autowired
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @PostMapping("/new")
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.guardar(turno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Integer id) {
        Turno turno = turnoService.buscar(id).orElse(null);
        return ResponseEntity.ok(turno);
    }

    @PutMapping("/update")
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) {
        ResponseEntity<Turno> response = null;
        if (turno.getId() != null && turnoService.buscar(turno.getId()).isPresent()) {
            response = ResponseEntity.ok(turnoService.actualizar(turno));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (pacienteService.buscar(id).isPresent()) {
            pacienteService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }
}
