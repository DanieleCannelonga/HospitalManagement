package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Laboratorio;
import com.app.hospital.repository.LaboratorioRepository;

@Service
@Transactional
public class LaboratorioServiceImpl implements LaboratorioService {
	
	@Autowired
	LaboratorioRepository laboratorioRepository;

	@Override
	public List<Laboratorio> getAllLaboratori() {
		return (List<Laboratorio>) laboratorioRepository.findAll();
	}

	@Override
	public Laboratorio getLaboratorioById(Long idLaboratorio) {
		return laboratorioRepository.findById(idLaboratorio).get();
	}

	@Override
	public Laboratorio saveOrUpdate(Laboratorio laboratorio) {
		return laboratorioRepository.save(laboratorio);
	}

	@Override
	public void deleteLaboratorio(Long idLaboratorio) {
		laboratorioRepository.deleteById(idLaboratorio);
	}

}
