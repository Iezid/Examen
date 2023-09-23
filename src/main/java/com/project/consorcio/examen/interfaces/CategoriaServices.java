package com.project.consorcio.examen.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.examen.entity.Categoria;
import com.project.consorcio.examen.repository.CategoriaRepository;


@Service
public class CategoriaServices {
	@Autowired
	private CategoriaRepository repo;
	
	public List<Categoria> listartodos(){
		return repo.findAll();
	}

}
