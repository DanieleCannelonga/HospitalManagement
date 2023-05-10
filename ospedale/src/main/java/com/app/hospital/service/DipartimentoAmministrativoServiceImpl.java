package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.DipartimentoAmministrativo;
import com.app.hospital.repository.DipartimentoAmministrativoRepository;

@Service
@Transactional
public class DipartimentoAmministrativoServiceImpl implements DipartimentoAmministrativoService {
	
	@Autowired
	DipartimentoAmministrativoRepository dipartimentoAmministrativoRepository;

	@Override
	public List<DipartimentoAmministrativo> getAllDipartimentiAmministrativi() {
		return (List<DipartimentoAmministrativo>) dipartimentoAmministrativoRepository.findAll();
	}

	@Override
	public DipartimentoAmministrativo getDipartimentoAmministrativoById(Long idDipartimentoAmministrativo) {
		return dipartimentoAmministrativoRepository.findById(idDipartimentoAmministrativo).get();
	}

	@Override
	public DipartimentoAmministrativo saveOrUpdate(DipartimentoAmministrativo dipartimentoAmministrativo) {
		return dipartimentoAmministrativoRepository.save(dipartimentoAmministrativo);
	}

	@Override
	public void deleteDipartimentoAmministrativo(Long idDipartimentoAmministrativo) {
		dipartimentoAmministrativoRepository.deleteById(idDipartimentoAmministrativo);
	}

}
