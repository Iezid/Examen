package com.project.consorcio.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.consorcio.examen.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
