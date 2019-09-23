package com.springboot.club.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.club.app.models.entity.Futbolista;
import com.springboot.club.app.models.entity.Pais;
import com.springboot.club.app.models.entity.Posicion;
import com.springboot.club.app.models.service.IClubService;
import com.springboot.club.app.models.service.IFutbolistaService;



@Controller
@SessionAttributes("Club")
@RequestMapping("/futbolista")
public class FutbolistaController {
	
	Long idClub;
	
	
	@Autowired
	IFutbolistaService futbolistaService;
	@Autowired
	IClubService clubService;
	
	@GetMapping("/agregar/{id}")
	public String agregarPrenda(@PathVariable(value="id") Long id,Model model) {
		Futbolista futbolista = new Futbolista();
		model.addAttribute("titulo","Agregar Futbolista");
		model.addAttribute("futbolista",futbolista);
		model.addAttribute("paises", Pais.values());
		model.addAttribute("posiciones",Posicion.values());
		idClub=id;
		return "futbolista/agregar";
	}
	@PostMapping("/agregar")
	public String agregarPrenda(Futbolista futbolista,Model model) {
		
			futbolista.setClub(clubService.findOne(idClub));
			clubService.saveFutbolista(futbolista);
		
		return "redirect:/club/ver/"+idClub;
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id>0) {
			
			futbolistaService.delete(id);
		}
		return "redirect:/club/ver/"+idClub;
	}
	

}
