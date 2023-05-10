package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.EsameDiagnostico;
import com.app.hospital.repository.EsameDiagnosticoRepository;

@Service
@Transactional
public class EsameDiagnosticoServiceImpl implements EsameDiagnosticoService {
	
	@Autowired
	EsameDiagnosticoRepository esameDiagnosticoRepository;

	@Override
	public List<EsameDiagnostico> getAllEsamiDiagnostici() {
		return (List<EsameDiagnostico>) esameDiagnosticoRepository.findAll();
	}

	@Override
	public EsameDiagnostico getEsameDiagnosticoById(Long idEsameDiagnostico) {
		return esameDiagnosticoRepository.findById(idEsameDiagnostico).get();
	}

	@Override
	public EsameDiagnostico saveOrUpdate(EsameDiagnostico esameDiagnostico) {
		return esameDiagnosticoRepository.save(esameDiagnostico);
	}

	@Override
	public void deleteEsameDiagnostico(Long idEsameDiagnostico) {
		esameDiagnosticoRepository.deleteById(idEsameDiagnostico);
	}

}
