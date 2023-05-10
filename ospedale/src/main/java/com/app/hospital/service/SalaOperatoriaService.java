package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.SalaOperatoria;

public interface SalaOperatoriaService {
	
	public List<SalaOperatoria> getAllSaleOperatorie();

	SalaOperatoria saveOrUpdate(SalaOperatoria salaOperatoria);

	SalaOperatoria getSalaOperatoriaById(Long idSalaOperatoria);

	void deleteSalaOperatoria(Long idSalaOperatoria);

}
