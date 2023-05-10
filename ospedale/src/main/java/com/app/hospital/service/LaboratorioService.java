package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Laboratorio;

public interface LaboratorioService {
	
	public List<Laboratorio> getAllLaboratori();

	Laboratorio saveOrUpdate(Laboratorio laboratorio);

	Laboratorio getLaboratorioById(Long idLaboratorio);

	void deleteLaboratorio(Long idLaboratorio);

}
