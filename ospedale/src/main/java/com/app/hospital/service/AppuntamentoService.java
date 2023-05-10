package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Appuntamento;

public interface AppuntamentoService {
	
	public List<Appuntamento> getAllAppuntamenti();

	Appuntamento saveOrUpdate(Appuntamento appuntamento);

	Appuntamento getAppuntamentoById(Long idAppuntamento);

	void deleteAppuntamento(Long idAppuntamento);

}
