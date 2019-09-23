package com.springboot.club.app.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.club.app.models.entity.Pais;
import com.springboot.club.app.models.entity.Persona;
import com.springboot.club.app.models.service.IClubService;
import com.springboot.club.app.models.service.IPersonaService;

@Controller
@SessionAttributes("persona")
@RequestMapping("/persona")
public class ClienteController {
	
	@Autowired
	IPersonaService personaService;
	

	@Autowired
	IClubService clubService;

	@GetMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("titulo", " EASY CRUD !");
		return "persona/index";
	}
	
	// MANDAS EL OBJETO PERSONA A LA VISTA
	@GetMapping("/form")
	public String crear( Model model) {
		
		Persona persona = new Persona();
		
		model.addAttribute("titulo", "Aprendiendo Spring GET");
		model.addAttribute("persona", persona);
		model.addAttribute("paises", Pais.values());
		return "persona/form";
	}
	
	// RECIBES LOS DATOS DEL FORMULARIO
	@PostMapping("/form")
	public String guardar( Persona persona, Model model) {
		model.addAttribute("titulo", "Aprendiendo Spring POST");
		//model.addAttribute("persona", persona);
		//lista.add(persona);
		personaService.save(persona);
		return "redirect:/persona/listar";
	}
	
	@GetMapping("/listar")
	public String listar( Model model) {
		model.addAttribute("titulo", "Aprendiendo Spring: LISTAR");
		List<Persona> lista = personaService.findAll();
		model.addAttribute("personas", lista);
		return "persona/listar";
		
	}
	
	@GetMapping("/ver/{id}")
	public String verPersona(@PathVariable(value = "id") Long id , Model model ) {
		Persona persona = personaService.findOne(id);
		model.addAttribute("persona", persona);
		return "persona/ver";
		
	}
	
	@GetMapping("/form/{id}")
	public String modificar(@PathVariable(value="id")Long id, Model model) {
		Persona persona = null;
		if(id>0) {
			persona=personaService.findOne(id);
		}else {
			return "redirect:/persona/listar";
		}
		
	
		model.addAttribute("titulo", "Editar Cliente");
		model.addAttribute("persona", persona);
		//personaService.save(persona);
		return "persona/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id")Long id) {
		
		if(id>0) {
			
			personaService.delete(id);
		}
		
		return "redirect:/listar";
	}
	@GetMapping("/buscar")
	public String buscarxNombres( Model model) {
		//List<Persona> personas = personaService.findByName(nombre);
		//model.addAttribute("personas", nombre);
		String nombre = null;
		model.addAttribute("titulo", "BUQUEDA POR NOMBRE");
		model.addAttribute("nombre", nombre);
		return "persona/buscar";
	}
	@PostMapping("/buscar")
	public String buscarxNombre(String nombre, Model model) {
		List<Persona> personas = personaService.findByName(nombre);
		
		model.addAttribute("personas", personas);
		model.addAttribute("titulo", "BUQUEDA POR NOMBRE POST");
		System.out.println("Nolbre: "+nombre);
		return "persona/buscar";
	}
	
	
	
	
	

}
