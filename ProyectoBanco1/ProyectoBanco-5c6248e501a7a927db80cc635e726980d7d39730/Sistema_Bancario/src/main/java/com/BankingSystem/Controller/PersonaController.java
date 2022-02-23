package com.BankingSystem.Controller;

import javax.validation.Valid;
import com.BankingSystem.Models.Persona;
import com.BankingSystem.Service.PersonaService;
import com.BankingSystem.ServiceInterface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonaController {
    @Autowired
	private PersonaService service;
	
	//@GetMapping("/index")
	//public String mostrar() {
	//	return "principal";
	//}

	@GetMapping("/persona")
	public String listar(Model model) {
		model.addAttribute("personas", service. listar());
		return "persona";
	}
	@GetMapping("/editarpersona/{id}")
	public String listarId(@PathVariable int id,Model model) {
		model.addAttribute("persona", service.listarId(id));
		return "formpersona";
	}
	
	@GetMapping("/newpersona")
	public String nuevo(Model model) {
		model.addAttribute("persona", new Persona());
		return "formpersona";
	}
	
	@PostMapping("/savepersona")
	public String save(@Valid Persona p,Model model) {
		int id=service.save(p);
		if(id==0) {
			return "formpersona";
		}
		return "redirect:/persona";
	} 
	
	@GetMapping("/deletepersona/{id}")
	public String eliminar(@PathVariable int id,Model model) {
		service.delete(id);
		return "redirect:/persona";
	}
}
