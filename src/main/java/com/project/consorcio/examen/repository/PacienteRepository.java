package com.project.consorcio.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.consorcio.examen.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
