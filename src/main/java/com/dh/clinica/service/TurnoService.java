package com.dh.clinica.service;

import com.dh.clinica.persistence.entities.Turno;
import com.dh.clinica.persistence.entities.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    TurnoRepository turnoRepository;

    public Turno guardar(Turno turno) {
        turnoList.guardar(turno);
        return turno;
    }

    public Optional<Turno> buscar(Integer id) {
        return turnoList.buscar(id);
    }

    public void eliminar(Integer id) {
        turnoList.eliminar(id);
    }

    public List<Turno> buscarTodos() {
        return turnoList.buscarTodos();
    }

    public Turno actualizar(Turno turno) {
        return turnoList.actualizar(turno);
    }
}
