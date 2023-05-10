package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Farmaco;
import com.app.hospital.repository.FarmacoRepository;

@Service
@Transactional
public class FarmacoServiceImpl implements FarmacoService {
	
	@Autowired
	FarmacoRepository farmacoRepository;

	@Override
	public List<Farmaco> getAllFarmaci() {
		return (List<Farmaco>) farmacoRepository.findAll();
	}

	@Override
	public Farmaco getFarmacoById(Long idFarmaco) {
		return farmacoRepository.findById(idFarmaco).get();
	}

	@Override
	public Farmaco saveOrUpdate(Farmaco farmaco) {
		return farmacoRepository.save(farmaco);
	}

	@Override
	public void deleteFarmaco(Long idFarmaco) {
		farmacoRepository.deleteById(idFarmaco);
	}

}
