package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.SistemaSicurezza;

public interface SistemaSicurezzaService {
	
	public List<SistemaSicurezza> getAllSistemiSicurezza();

	SistemaSicurezza saveOrUpdate(SistemaSicurezza sistemaSicurezza);

	SistemaSicurezza getSistemaSicurezzaById(Long idSistemaSicurezza);

	void deleteSistemaSicurezza(Long idSistemaSicurezza);

}
