package com.dh.clinica.dao.impl;

import com.dh.clinica.dao.IDao;
import com.dh.clinica.model.Turno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TurnoListRepository implements IDao<Turno> {

    private final List<Turno> listaTurnos;

    public TurnoListRepository() {
        this.listaTurnos = new ArrayList<>();
    }


    @Override
    public Turno guardar(Turno turno) {
        listaTurnos.add(turno);
        return turno;
    }

    @Override
    public Optional<Turno> buscar(Integer id) {
        for (Turno turno : listaTurnos) {
            if (turno.getId().equals(id)) {
                return Optional.of(turno);
            }
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Integer id) {
        for (Turno turno : listaTurnos) {
            if (turno.getId().equals(id)) {
                listaTurnos.remove(turno);
            }
        }
    }

    @Override
    public List<Turno> buscarTodos() {
        return listaTurnos;
    }

    @Override
    public Turno actualizar(Turno turno) {
        eliminar(turno.getId());
        listaTurnos.add(turno);
        return turno;
    }
}
