package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Visita;
import com.app.hospital.repository.VisitaRepository;

@Service
@Transactional
public class VisitaServiceImpl implements VisitaService {
	
	@Autowired
	VisitaRepository visitaRepository;

	@Override
	public List<Visita> getAllVisite() {
		return (List<Visita>) visitaRepository.findAll();
	}

	@Override
	public Visita getVisitaById(Long idVisita) {
		return visitaRepository.findById(idVisita).get();
	}

	@Override
	public Visita saveOrUpdate(Visita visita) {
		return visitaRepository.save(visita);
	}

	@Override
	public void deleteVisita(Long idVisita) {
		visitaRepository.deleteById(idVisita);
	}

}
