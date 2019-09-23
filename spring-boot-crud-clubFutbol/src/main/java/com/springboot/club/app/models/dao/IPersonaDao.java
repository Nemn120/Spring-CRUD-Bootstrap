package com.springboot.club.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.club.app.models.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long>{
	
	// SELECT A NIVEL DE OBJETO
//	@Query("select p from Persona p where p.nombre = term")
	//public List<Persona> findByNombre(String term);
	
	
	
    
    /**
     * @Query("select u from Usuario u where u.nombre like :nombre order by u.nombre")
    	List<Usuario>buscaPorNombre(@Param("nombre") String nombre);
     * Esta funcion hace exactamente lo mismo que la funcion buscaPorNombre pero utilizando DSL (Domain Specificic Lenguage) de Spring
     * @param nombre Nombre de usuario a buscar (sin wildcards, ya lo pone JPL)
     * @return Lista de Usuarios a buscar
     */
	public List<Persona> findIsLikeNombreOrderByNombre(String nombre);
	
	}

