package com.springboot.club.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.club.app.models.dao.IClubDao;
import com.springboot.club.app.models.dao.IFutbolistaDao;
import com.springboot.club.app.models.entity.Club;
import com.springboot.club.app.models.entity.Futbolista;
import com.springboot.club.app.models.entity.Persona;

@Service
public class ClubServiceImpl implements IClubService{
	
	@Autowired
	 IClubDao clubDao;
	
	@Autowired
	IFutbolistaDao futbolistaDao;
	
	@Override
	@Transactional
	public List<Club> findAll() {
		// TODO Auto-generated method stub
		return (List<Club>) clubDao.findAll();
	}

	@Override
	@Transactional
	public void save(Club club) {
		clubDao.save(club);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clubDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public Club findOne(Long id) {
		// TODO Auto-generated method stub
		return clubDao.findById(id).orElse(null);
	}

	@Override
	public List<Club> findByName(String nombre) {
		return clubDao.findIsLikeNombreOrderByNombre(nombre);
	}

	@Override
	@Transactional
	public void saveFutbolista(Futbolista futbolista) {
		futbolistaDao.save(futbolista);
		
	}



}
