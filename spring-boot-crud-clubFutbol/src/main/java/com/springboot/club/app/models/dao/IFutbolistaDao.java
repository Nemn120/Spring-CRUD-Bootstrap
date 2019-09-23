package com.springboot.club.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.club.app.models.entity.Futbolista;
import com.springboot.club.app.models.entity.Persona;

public interface IFutbolistaDao extends CrudRepository<Futbolista, Long>{
	public List<Futbolista> findIsLikeNombreOrderByNombre(String nombre);
}
