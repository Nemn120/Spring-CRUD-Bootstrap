package com.springboot.club.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.club.app.models.entity.Club;
import com.springboot.club.app.models.entity.Futbolista;
import com.springboot.club.app.models.entity.Persona;

public interface IClubDao extends CrudRepository<Club, Long> {
	public List<Club> findIsLikeNombreOrderByNombre(String nombre);
	
}
