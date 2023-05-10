package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Reparto;
import com.app.hospital.repository.RepartoRepository;

@Service
@Transactional
public class RepartoServiceImpl implements RepartoService {
	
	@Autowired
	RepartoRepository repartoRepository;

	@Override
	public List<Reparto> getAllReparti() {
		return (List<Reparto>) repartoRepository.findAll();
	}

	@Override
	public Reparto getRepartoById(Long idReparto) {
		return repartoRepository.findById(idReparto).get();
	}

	@Override
	public Reparto saveOrUpdate(Reparto reparto) {
		return repartoRepository.save(reparto);
	}

	@Override
	public void deleteReparto(Long idReparto) {
		repartoRepository.deleteById(idReparto);
	}

}
