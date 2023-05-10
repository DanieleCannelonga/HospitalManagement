package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.SistemaSicurezza;
import com.app.hospital.repository.SistemaSicurezzaRepository;

@Service
@Transactional
public class SistemaSicurezzaServiceImpl implements SistemaSicurezzaService {
	
	@Autowired
	SistemaSicurezzaRepository sistemaSicurezzaRepository;

	@Override
	public List<SistemaSicurezza> getAllSistemiSicurezza() {
		return (List<SistemaSicurezza>) sistemaSicurezzaRepository.findAll();
	}

	@Override
	public SistemaSicurezza getSistemaSicurezzaById(Long idSistemaSicurezza) {
		return sistemaSicurezzaRepository.findById(idSistemaSicurezza).get();
	}

	@Override
	public SistemaSicurezza saveOrUpdate(SistemaSicurezza sistemaSicurezza) {
		return sistemaSicurezzaRepository.save(sistemaSicurezza);
	}

	@Override
	public void deleteSistemaSicurezza(Long idSistemaSicurezza) {
		sistemaSicurezzaRepository.deleteById(idSistemaSicurezza);
	}

}
