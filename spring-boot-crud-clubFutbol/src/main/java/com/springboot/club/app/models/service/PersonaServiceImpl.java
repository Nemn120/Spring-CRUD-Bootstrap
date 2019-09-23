package com.springboot.club.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.club.app.models.dao.IPersonaDao;
import com.springboot.club.app.models.entity.Persona;
// CLASE DE SERVICIO
@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaDao personaDao;
	

	@Override
	@Transactional
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Persona persona) {
		personaDao.save(persona);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		personaDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public Persona findOne(Long id) {
		return personaDao.findById(id).orElse(null);
		
	}

	@Override
	public List<Persona> findByName(String nombre) {
		return personaDao.findIsLikeNombreOrderByNombre(nombre);
	}
	
}
