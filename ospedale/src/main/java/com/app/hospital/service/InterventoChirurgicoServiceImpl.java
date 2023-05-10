package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.InterventoChirurgico;
import com.app.hospital.repository.InterventoChirurgicoRepository;

@Service
@Transactional
public class InterventoChirurgicoServiceImpl implements InterventoChirurgicoService {
	
	@Autowired
	InterventoChirurgicoRepository interventoChirurgicoRepository;

	@Override
	public List<InterventoChirurgico> getAllInterventiChirurgici() {
		return (List<InterventoChirurgico>) interventoChirurgicoRepository.findAll();
	}

	@Override
	public InterventoChirurgico getInterventoChirurgicoById(Long idInterventoChirurgico) {
		return interventoChirurgicoRepository.findById(idInterventoChirurgico).get();
	}

	@Override
	public InterventoChirurgico saveOrUpdate(InterventoChirurgico interventoChirurgico) {
		return interventoChirurgicoRepository.save(interventoChirurgico);
	}

	@Override
	public void deleteInterventoChirurgico(Long idInterventoChirurgico) {
		interventoChirurgicoRepository.deleteById(idInterventoChirurgico);
	}

}
