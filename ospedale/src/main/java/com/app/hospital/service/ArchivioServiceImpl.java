package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Archivio;
import com.app.hospital.repository.ArchivioRepository;

@Service
@Transactional
public class ArchivioServiceImpl implements ArchivioService {
	
	@Autowired
	ArchivioRepository archivioRepository;

	@Override
	public List<Archivio> getAllArchivi() {
		return (List<Archivio>) archivioRepository.findAll();
	}

	@Override
	public Archivio getArchivioById(Long idArchivio) {
		return archivioRepository.findById(idArchivio).get();
	}

	@Override
	public Archivio saveOrUpdate(Archivio archivio) {
		return archivioRepository.save(archivio);
	}

	@Override
	public void deleteArchivio(Long idArchivio) {
		archivioRepository.deleteById(idArchivio);
	}

}
