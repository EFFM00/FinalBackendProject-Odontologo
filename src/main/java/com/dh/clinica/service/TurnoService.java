package com.dh.clinica.service;

import com.dh.clinica.dao.IDao;
import com.dh.clinica.model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    private IDao<Turno> turnoList;

    public TurnoService(IDao<Turno> turnoList) {
        this.turnoList = turnoList;
    }

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
