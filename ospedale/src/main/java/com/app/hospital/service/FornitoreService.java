package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Fornitore;

public interface FornitoreService {
	
	public List<Fornitore> getAllFornitori();

	Fornitore saveOrUpdate(Fornitore fornitore);

	Fornitore getFornitoreById(Long idFornitore);

	void deleteFornitore(Long idFornitore);

}
