package com.springboot.club.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.club.app.models.dao.IFutbolistaDao;
import com.springboot.club.app.models.entity.Futbolista;

@Service
public class FutbolistaServiceImpl implements IFutbolistaService {
	
	@Autowired
	IFutbolistaDao futbolistaDao;
	
	
	@Override
	public List<Futbolista> findAll() {
		return (List<Futbolista>) futbolistaDao.findAll();
	}

	@Override
	public void save(Futbolista futbolista) {
		futbolistaDao.save(futbolista);
		
	}

	@Override
	public void delete(Long id) {
		futbolistaDao.deleteById(id);
	}

	@Override
	public Futbolista findOne(Long id) {
		return futbolistaDao.findById(id).orElse(null);
	}

	@Override
	public List<Futbolista> findByName(String nombre) {
		return futbolistaDao.findIsLikeNombreOrderByNombre(nombre);
	}
	

}
