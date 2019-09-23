package com.springboot.club.app.models.service;

import java.util.List;

import com.springboot.club.app.models.entity.Club;
import com.springboot.club.app.models.entity.Futbolista;

public interface IFutbolistaService {
	public List<Futbolista> findAll();
	public void save(Futbolista club);
	public void delete(Long id);
	public Futbolista findOne(Long id);
	public List<Futbolista> findByName(String nombre);
	
}
