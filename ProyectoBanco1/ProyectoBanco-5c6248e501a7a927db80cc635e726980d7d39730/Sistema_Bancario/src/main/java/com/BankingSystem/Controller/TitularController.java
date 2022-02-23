package com.BankingSystem.Controller;

import javax.validation.Valid;
import com.BankingSystem.Models.Titular;
import com.BankingSystem.ServiceInterface.ITitularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TitularController {
	@Autowired
	private ITitularService service;
	
	//@GetMapping("/index")
	//public String mostrar() {
	//	return "principal";
	//}

	@GetMapping("/titular")
	public String listar(Model model) {
		model.addAttribute("personas", service.listar());
		return "titular";
	}

	@GetMapping("/listartodo")
	public String listartodo(Model model) {
		model.addAttribute("personas", service.listar());
		return "Customers";
	}

	@GetMapping("/editartitular/{id}")
	public String listarId(@PathVariable int id,Model model) {
		model.addAttribute("persona", service.listarId(id));
		return "formtitular";
	}
	
	@GetMapping("/newtitular")
	public String nuevo(Model model) {
		model.addAttribute("persona", new Titular());
		return "formtitular";
	}
	
	@PostMapping("/savetitular")
	public String save(@Valid Titular t,Model model) {
		int id=service.save(t);
		if(id==0) {
			return "formtitular";
		}
		return "redirect:/titular";
	} 
	
	@GetMapping("/deletetitular/{id}")
	public String eliminar(@PathVariable int id,Model model) {
		service.delete(id);
		return "redirect:/titular";
	}
}
