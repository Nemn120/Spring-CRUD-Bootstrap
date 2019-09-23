package com.springboot.club.app.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.club.app.models.entity.Club;
import com.springboot.club.app.models.entity.Futbolista;
import com.springboot.club.app.models.entity.Pais;
import com.springboot.club.app.models.entity.Persona;
import com.springboot.club.app.models.service.IClubService;
import com.springboot.club.app.models.service.IFutbolistaService;
import com.springboot.club.app.models.service.IPersonaService;
// TIENE QUE EXISITR EL RETURN EN EL TEMPLATE
@Controller
@RequestMapping("/club")
@SessionAttributes("club")
public class ClubController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	IClubService clubService;
	

	@GetMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("titulo", " EASY CRUD !");
		return "club/index";
	}
	
	// MANDAS EL OBJETO PERSONA A LA VISTA
	@GetMapping("/form")
	public String crear( Model model) {
		
		Club club = new Club();
		
		model.addAttribute("titulo", "Crea tu nuevo Club");
		model.addAttribute("club", club);
		model.addAttribute("paises", Pais.values());
		return "club/form";
	}
	
	// RECIBES LOS DATOS DEL FORMULARIO
	@PostMapping("/form")
	public String guardar( Club club, Model model) {
		model.addAttribute("titulo", "Crea tu nuevo Club");
		clubService.save(club);
		return "redirect:/club/listar";
	}
	
	@GetMapping("/listar")
	public String listar( Model model) {
		model.addAttribute("titulo", "Lista de Clubes");
		List<Club> lista = clubService.findAll();
		model.addAttribute("clubes", lista);
		return "club/listar";
		
	}
	
	@GetMapping("/ver/{id}")
	public String verPersona(@PathVariable(value = "id") Long id , Model model ) {
		Club club = clubService.findOne(id);
		model.addAttribute("club", club);
		model.addAttribute("nombre",club.getNombre());
		return "club/ver";
		
	}
	
	@GetMapping("/form/{id}")
	public String modificar(@PathVariable(value="id")Long id, Model model) {
		Club club = null;
		if(id>0) {
			club=clubService.findOne(id);
		}else {
			return "redirect:/listar";
		}
		
	
		model.addAttribute("titulo", "Editar Cliente");
		model.addAttribute("club", club);
		return "club/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id")Long id) {
		
		if(id>0) {
			
			clubService.delete(id);
		}
		
		return "redirect:/club/listar";
	}
	@GetMapping("/buscar")
	public String buscarxNombres( Model model) {
		String nombre = null;
		model.addAttribute("titulo", "Buscar club");
		model.addAttribute("nombre", nombre);
		return "club/buscar";
	}
	@PostMapping("/buscar")
	public String buscarxNombre(String nombre, Model model) {
		List<Club> clubes = clubService.findByName(nombre);
		
	model.addAttribute("clubes", clubes);
		model.addAttribute("titulo", "Busqueda de clubes por nombre");
		System.out.println("Nombre: "+nombre);
		return "club/buscar";
	}
	
	

	
	

	
}
