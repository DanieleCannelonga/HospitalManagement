package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Paziente;

public interface PazienteService {
	
	public List<Paziente> getAllPazienti();

	Paziente saveOrUpdate(Paziente paziente);

	Paziente getPazienteById(Long idPaziente);

	void deletePaziente(Long idPaziente);

}
