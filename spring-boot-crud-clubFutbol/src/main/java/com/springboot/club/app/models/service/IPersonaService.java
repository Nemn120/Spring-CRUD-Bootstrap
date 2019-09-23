package com.springboot.club.app.models.service;

import java.util.List;

import com.springboot.club.app.models.entity.Persona;

public interface IPersonaService {
	
	public List<Persona> findAll();
	public void save(Persona persona);
	public void delete(Long id);
	public Persona findOne(Long id);
	public List<Persona> findByName(String nombre);
	

}
