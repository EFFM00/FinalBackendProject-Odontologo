package com.dh.clinica.persistence.entities.repository;

import com.dh.clinica.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
}
