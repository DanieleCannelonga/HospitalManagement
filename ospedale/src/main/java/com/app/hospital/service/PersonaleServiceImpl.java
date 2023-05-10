package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Personale;
import com.app.hospital.repository.PersonaleRepository;

@Service
@Transactional
public class PersonaleServiceImpl implements PersonaleService {
	
	@Autowired
	PersonaleRepository personaleRepository;

	@Override
	public List<Personale> getAllPersonale() {
		return (List<Personale>) personaleRepository.findAll();
	}

	@Override
	public Personale getPersonaleById(Long idPersonale) {
		return personaleRepository.findById(idPersonale).get();
	}

	@Override
	public Personale saveOrUpdate(Personale personale) {
		return personaleRepository.save(personale);
	}

	@Override
	public void deletePersonale(Long idPersonale) {
		personaleRepository.deleteById(idPersonale);
	}

}
