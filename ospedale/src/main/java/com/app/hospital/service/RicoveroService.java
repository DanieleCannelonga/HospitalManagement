package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Ricovero;

public interface RicoveroService {
	
	public List<Ricovero> getAllRicoveri();

	Ricovero saveOrUpdate(Ricovero ricovero);

	Ricovero getRicoveroById(Long idRicovero);

	void deleteRicovero(Long idRicovero);

}
