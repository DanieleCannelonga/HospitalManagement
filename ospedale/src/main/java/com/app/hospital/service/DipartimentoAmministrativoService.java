package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.DipartimentoAmministrativo;

public interface DipartimentoAmministrativoService {
	
	public List<DipartimentoAmministrativo> getAllDipartimentiAmministrativi();

	DipartimentoAmministrativo saveOrUpdate(DipartimentoAmministrativo dipartimentoAmministrativo);

	DipartimentoAmministrativo getDipartimentoAmministrativoById(Long idDipartimentoAmministrativo);

	void deleteDipartimentoAmministrativo(Long idDipartimentoAmministrativo);

}
