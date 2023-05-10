package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.SalaOperatoria;
import com.app.hospital.repository.SalaOperatoriaRepository;

@Service
@Transactional
public class SalaOperatoriaServiceImpl implements SalaOperatoriaService {
	
	@Autowired
	SalaOperatoriaRepository salaOperatoriaRepository;

	@Override
	public List<SalaOperatoria> getAllSaleOperatorie() {
		return (List<SalaOperatoria>) salaOperatoriaRepository.findAll();
	}

	@Override
	public SalaOperatoria getSalaOperatoriaById(Long idSalaOperatoria) {
		return salaOperatoriaRepository.findById(idSalaOperatoria).get();
	}

	@Override
	public SalaOperatoria saveOrUpdate(SalaOperatoria salaOperatoria) {
		return salaOperatoriaRepository.save(salaOperatoria);
	}

	@Override
	public void deleteSalaOperatoria(Long idSalaOperatoria) {
		salaOperatoriaRepository.deleteById(idSalaOperatoria);
	}

}
