package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.InterventoChirurgico;

public interface InterventoChirurgicoService {
	
	public List<InterventoChirurgico> getAllInterventiChirurgici();

	InterventoChirurgico saveOrUpdate(InterventoChirurgico interventoChirurgico);

	InterventoChirurgico getInterventoChirurgicoById(Long idInterventoChirurgico);

	void deleteInterventoChirurgico(Long idInterventoChirurgico);

}
