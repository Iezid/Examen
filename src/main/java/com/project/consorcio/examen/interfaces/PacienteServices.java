package com.project.consorcio.examen.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.examen.entity.Paciente;
import com.project.consorcio.examen.repository.PacienteRepository;

@Service
public class PacienteServices {
	@Autowired
	private PacienteRepository repo;
	
	public List<Paciente> listarPacientes(){
		return repo.findAll();
	}
	public void registrar(Paciente pac) {
		repo.save(pac);
	}
	public void actualizar(Paciente pac) {
		repo.save(pac);
	}
	public void eliminarPorID(Integer pac) {
		repo.deleteById(pac);
	}
	public Paciente buscarPorID(Integer pac) {
		return repo.findById(pac).orElse(null);
	}
}
