package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Ricovero;
import com.app.hospital.repository.RicoveroRepository;

@Service
@Transactional
public class RicoveroServiceImpl implements RicoveroService {
	
	@Autowired
	RicoveroRepository ricoveroRepository;

	@Override
	public List<Ricovero> getAllRicoveri() {
		return (List<Ricovero>) ricoveroRepository.findAll();
	}

	@Override
	public Ricovero getRicoveroById(Long idRicovero) {
		return ricoveroRepository.findById(idRicovero).get();
	}

	@Override
	public Ricovero saveOrUpdate(Ricovero ricovero) {
		return ricoveroRepository.save(ricovero);
	}

	@Override
	public void deleteRicovero(Long idRicovero) {
		ricoveroRepository.deleteById(idRicovero);
	}

}
