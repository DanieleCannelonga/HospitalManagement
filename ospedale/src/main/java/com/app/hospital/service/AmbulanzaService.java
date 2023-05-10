package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Ambulanza;

public interface AmbulanzaService {
	
	public List<Ambulanza> getAllAmbulanze();

	Ambulanza saveOrUpdate(Ambulanza ambulanza);

	Ambulanza getAmbulanzaById(Long idAmbulanza);

	void deleteAmbulanza(Long idAmbulanza);

}
