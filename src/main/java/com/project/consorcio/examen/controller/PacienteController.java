package com.project.consorcio.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.examen.entity.Categoria;
import com.project.consorcio.examen.entity.Paciente;
import com.project.consorcio.examen.interfaces.CategoriaServices;
import com.project.consorcio.examen.interfaces.PacienteServices;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
		
	@Autowired
	private CategoriaServices servicioCat;
	
	@Autowired
	private PacienteServices servicioPac;
	
	
	@RequestMapping("lista")
	public String index(Model model) {
		model.addAttribute("categorias", servicioCat.listartodos());
		model.addAttribute("pacientes", servicioPac.listarPacientes());
		return "paciente";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod,
			@RequestParam("nombre") String nom,
			@RequestParam("apellido") String ape,
			@RequestParam("sexo") String sexo,
			@RequestParam("categoria") int codCat,
			RedirectAttributes redirect) {
		
		try {
			Paciente pac=new Paciente();
			
			pac.setNombre(nom);
			pac.setApellido(ape);
			pac.setSexo(sexo);
			
			
			Categoria cat=new Categoria();
			
			cat.setCodigo(codCat);
			pac.setCategoria(cat);
			
			if(cod==0) {
				servicioPac.registrar(pac);
				redirect.addFlashAttribute("MENSAJE","Paciente Registrado");
				
			}
			else {
				pac.setCodigo(cod);
				servicioPac.actualizar(pac);
				redirect.addFlashAttribute("MENSAJE","Paciente Registrado");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/paciente/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Paciente buscar(@RequestParam("codigo")Integer cod) {
		
		return servicioPac.buscarPorID(cod);
	}
}
