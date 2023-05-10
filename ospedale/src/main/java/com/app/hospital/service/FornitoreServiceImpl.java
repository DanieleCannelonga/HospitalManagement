package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Fornitore;
import com.app.hospital.repository.FornitoreRepository;

@Service
@Transactional
public class FornitoreServiceImpl implements FornitoreService {
	
	@Autowired
	FornitoreRepository fornitoreRepository;

	@Override
	public List<Fornitore> getAllFornitori() {
		return (List<Fornitore>) fornitoreRepository.findAll();
	}

	@Override
	public Fornitore getFornitoreById(Long idFornitore) {
		return fornitoreRepository.findById(idFornitore).get();
	}

	@Override
	public Fornitore saveOrUpdate(Fornitore fornitore) {
		return fornitoreRepository.save(fornitore);
	}

	@Override
	public void deleteFornitore(Long idFornitore) {
		fornitoreRepository.deleteById(idFornitore);
	}

}
