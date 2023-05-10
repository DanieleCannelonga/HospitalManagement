package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.AttrezzaturaMedica;
import com.app.hospital.repository.AttrezzaturaMedicaRepository;

@Service
@Transactional
public class AttrezzaturaMedicaServiceImpl implements AttrezzaturaMedicaService {
	
	@Autowired
	AttrezzaturaMedicaRepository attrezzaturaMedicaRepository;

	@Override
	public List<AttrezzaturaMedica> getAllAttrezzatureMediche() {
		return (List<AttrezzaturaMedica>) attrezzaturaMedicaRepository.findAll();
	}

	@Override
	public AttrezzaturaMedica getAttrezzaturaMedicaById(Long idAttrezzaturaMedica) {
		return attrezzaturaMedicaRepository.findById(idAttrezzaturaMedica).get();
	}

	@Override
	public AttrezzaturaMedica saveOrUpdate(AttrezzaturaMedica attrezzaturaMedica) {
		return attrezzaturaMedicaRepository.save(attrezzaturaMedica);
	}

	@Override
	public void deleteAttrezzaturaMedica(Long idAttrezzaturaMedica) {
		attrezzaturaMedicaRepository.deleteById(idAttrezzaturaMedica);
	}

}
