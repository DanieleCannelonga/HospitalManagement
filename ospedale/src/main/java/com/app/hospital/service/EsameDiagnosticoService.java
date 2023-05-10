package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.EsameDiagnostico;

public interface EsameDiagnosticoService {
	
	public List<EsameDiagnostico> getAllEsamiDiagnostici();

	EsameDiagnostico saveOrUpdate(EsameDiagnostico esameDiagnostico);

	EsameDiagnostico getEsameDiagnosticoById(Long idEsameDiagnostico);

	void deleteEsameDiagnostico(Long idEsameDiagnostico);

}
