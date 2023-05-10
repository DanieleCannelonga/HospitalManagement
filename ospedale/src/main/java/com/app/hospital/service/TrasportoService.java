package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Trasporto;

public interface TrasportoService {
	
	public List<Trasporto> getAllTrasporti();

	Trasporto saveOrUpdate(Trasporto trasporto);

	Trasporto getTrasportoById(Long idTrasporto);

	void deleteTrasporto(Long idTrasporto);

}
