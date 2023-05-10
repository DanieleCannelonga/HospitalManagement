package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.AttrezzaturaMedica;

public interface AttrezzaturaMedicaService {
	
	public List<AttrezzaturaMedica> getAllAttrezzatureMediche();

	AttrezzaturaMedica saveOrUpdate(AttrezzaturaMedica attrezzaturaMedica);

	AttrezzaturaMedica getAttrezzaturaMedicaById(Long idAttrezzaturaMedica);

	void deleteAttrezzaturaMedica(Long idAttrezzaturaMedica);

}
