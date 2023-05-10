package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Farmaco;

public interface FarmacoService {
	
	public List<Farmaco> getAllFarmaci();

	Farmaco saveOrUpdate(Farmaco farmaco);

	Farmaco getFarmacoById(Long idFarmaco);

	void deleteFarmaco(Long idFarmaco);

}
