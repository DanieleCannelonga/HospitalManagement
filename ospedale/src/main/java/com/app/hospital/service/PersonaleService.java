package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Personale;

public interface PersonaleService {
	
	public List<Personale> getAllPersonale();

	Personale saveOrUpdate(Personale personale);

	Personale getPersonaleById(Long idPersonale);

	void deletePersonale(Long idPersonale);

}
