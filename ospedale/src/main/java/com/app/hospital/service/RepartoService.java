package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Reparto;

public interface RepartoService {
	
	public List<Reparto> getAllReparti();

	Reparto saveOrUpdate(Reparto reparto);

	Reparto getRepartoById(Long idReparto);

	void deleteReparto(Long idReparto);

}
