package com.dh.clinica.service;


import com.dh.clinica.persistence.entities.Domicilio;
import com.dh.clinica.persistence.entities.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {

    @Autowired
    DomicilioRepository domicilioRepository;

    public Domicilio guardar(Domicilio d) {
        return domicilioRepository.save(d);
    }

    public Optional<Domicilio> buscar(Integer id) {
        return domicilioRepository.findById(id);
    }

    public List<Domicilio> buscarTodos() {
        return domicilioRepository.findAll();
    }

    public void eliminar(Integer id) {
        if(domicilioRepository.findById(id).isPresent()){
            domicilioRepository.deleteById(id);
        }
    }
}
