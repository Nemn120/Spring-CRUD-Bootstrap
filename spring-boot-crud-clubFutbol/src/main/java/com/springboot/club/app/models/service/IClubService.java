package com.springboot.club.app.models.service;

import java.util.List;

import com.springboot.club.app.models.entity.Club;
import com.springboot.club.app.models.entity.Futbolista;
import com.springboot.club.app.models.entity.Persona;

public interface IClubService {
	
	public List<Club> findAll();
	public void save(Club club);
	public void delete(Long id);
	public Club findOne(Long id);
	public List<Club> findByName(String nombre);
	public void saveFutbolista(Futbolista futbolista);

}
