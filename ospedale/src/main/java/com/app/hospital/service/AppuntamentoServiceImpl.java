package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Appuntamento;
import com.app.hospital.repository.AppuntamentoRepository;

@Service
@Transactional
public class AppuntamentoServiceImpl implements AppuntamentoService {
	
	@Autowired
	AppuntamentoRepository appuntamentoRepository;

	@Override
	public List<Appuntamento> getAllAppuntamenti() {
		return (List<Appuntamento>) appuntamentoRepository.findAll();
	}

	@Override
	public Appuntamento getAppuntamentoById(Long idAppuntamento) {
		return appuntamentoRepository.findById(idAppuntamento).get();
	}

	@Override
	public Appuntamento saveOrUpdate(Appuntamento appuntamento) {
		return appuntamentoRepository.save(appuntamento);
	}

	@Override
	public void deleteAppuntamento(Long idAppuntamento) {
		appuntamentoRepository.deleteById(idAppuntamento);
	}

}
