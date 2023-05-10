package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Paziente;
import com.app.hospital.repository.PazienteRepository;

@Service
@Transactional
public class PazienteServiceImpl implements PazienteService {
	
	@Autowired
	PazienteRepository pazienteRepository;

	@Override
	public List<Paziente> getAllPazienti() {
		return (List<Paziente>) pazienteRepository.findAll();
	}

	@Override
	public Paziente getPazienteById(Long idPaziente) {
		return pazienteRepository.findById(idPaziente).get();
	}

	@Override
	public Paziente saveOrUpdate(Paziente paziente) {
		return pazienteRepository.save(paziente);
	}

	@Override
	public void deletePaziente(Long idPaziente) {
		pazienteRepository.deleteById(idPaziente);
	}

}
