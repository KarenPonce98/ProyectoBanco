package com.BankingSystem.Controller;

import javax.validation.Valid;

import com.BankingSystem.Models.Compañia;
import com.BankingSystem.Service.CompañiaService;
import com.BankingSystem.ServiceInterface.ICompaniaS;
import com.BankingSystem.ServiceInterface.ICompaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompañiaController {
    @Autowired
	private CompañiaService service;
	
	//@GetMapping("/index")
	//public String mostrar() {
	//	return "principal";
	//}

	@GetMapping("/compania")
	public String listar(Model model) {
		model.addAttribute("personas", service. listar());
		return "compañia";
	}
	@GetMapping("/editarcompania/{id}")
	public String listarId(@PathVariable int id,Model model) {
		model.addAttribute("persona", service.listarId(id));
		return "formcompañia";
	}
	
	@GetMapping("/newcompania")
	public String nuevo(Model model) {
		model.addAttribute("persona", new Compañia());
		return "formcompañia";
	}
	
	@PostMapping("/savecompania")
	public String save(@Valid Compañia c,Model model) {
		int id=service.save(c);
		if(id==0) {
			return "formcompañia";
		}
		return "redirect:/compania";
	} 
	
	@GetMapping("/deletecompania/{id}")
	public String eliminar(@PathVariable int id,Model model) {
		service.delete(id);
		return "redirect:/compania";
	}
}
