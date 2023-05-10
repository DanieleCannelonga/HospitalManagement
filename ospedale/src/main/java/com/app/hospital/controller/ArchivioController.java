package com.app.hospital.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hospital.model.Archivio;
import com.app.hospital.service.ArchivioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Archivio")
public class ArchivioController {
	
	@Autowired
	ArchivioService archivioService;
	
	@GetMapping(value = "/listaArchivi", produces = "application/json")
		public String listaArchivi() throws JsonProcessingException {
			List<Archivio> listaArchivi = archivioService.getAllArchivi();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaArchiviJson = objectMapper.writeValueAsString(listaArchivi);
			return listaArchiviJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String ArchivioById(@PathVariable Long id) throws JsonProcessingException {
		Archivio Archivio = archivioService.getArchivioById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String ArchivioJson = objectMapper.writeValueAsString(Archivio);
		return ArchivioJson;
	}	
	
	@PostMapping(value = "/addArchivio", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Archivio> addArchivio(@RequestBody Archivio Archivio) {
	    Archivio nuovoArchivio = archivioService.saveOrUpdate(Archivio);
	    return ResponseEntity.ok(nuovoArchivio);
	}
	
	@PutMapping(value = "/editArchivio/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Archivio> editArchivio(@RequestBody Archivio Archivio) {
	    Archivio nuovoArchivio = archivioService.saveOrUpdate(Archivio);
	    return ResponseEntity.ok(nuovoArchivio);
	}
	
	@DeleteMapping(value = "/deleteArchivio/{id}")
	public ResponseEntity<Void> deleteArchivio(@PathVariable Long id) {
	    archivioService.deleteArchivio(id);
	    return ResponseEntity.noContent().build();
	}
}