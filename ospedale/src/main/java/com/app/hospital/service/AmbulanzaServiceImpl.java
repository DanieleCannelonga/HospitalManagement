package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Ambulanza;
import com.app.hospital.repository.AmbulanzaRepository;

@Service
@Transactional
public class AmbulanzaServiceImpl implements AmbulanzaService {
	
	@Autowired
	AmbulanzaRepository AmbulanzaRepository;

	@Override
	public List<Ambulanza> getAllAmbulanze() {
		return (List<Ambulanza>) AmbulanzaRepository.findAll();
	}

	@Override
	public Ambulanza getAmbulanzaById(Long idAmbulanza) {
		return AmbulanzaRepository.findById(idAmbulanza).get();
	}

	@Override
	public Ambulanza saveOrUpdate(Ambulanza ambulanza) {
		return AmbulanzaRepository.save(ambulanza);
	}

	@Override
	public void deleteAmbulanza(Long idAmbulanza) {
		AmbulanzaRepository.deleteById(idAmbulanza);
	}

}
