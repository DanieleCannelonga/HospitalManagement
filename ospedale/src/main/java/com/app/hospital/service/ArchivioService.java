package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Archivio;

public interface ArchivioService {
	
	public List<Archivio> getAllArchivi();

	Archivio saveOrUpdate(Archivio archivio);

	Archivio getArchivioById(Long idArchivio);

	void deleteArchivio(Long idArchivio);

}
