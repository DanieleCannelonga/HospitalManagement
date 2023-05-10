package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Visita;

public interface VisitaService {
	
	public List<Visita> getAllVisite();

	Visita saveOrUpdate(Visita visita);

	Visita getVisitaById(Long idVisita);

	void deleteVisita(Long idVisita);

}
