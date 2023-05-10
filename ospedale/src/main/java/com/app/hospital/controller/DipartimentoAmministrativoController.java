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

import com.app.hospital.model.DipartimentoAmministrativo;
import com.app.hospital.service.DipartimentoAmministrativoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/DipartimentoAmministrativo")
public class DipartimentoAmministrativoController {
	
	@Autowired
	DipartimentoAmministrativoService dipartimentoAmministrativoService;
	
	@GetMapping(value = "/listaDipartimentiAmministrativi", produces = "application/json")
		public String listaDipartimentiAmministrativi() throws JsonProcessingException {
			List<DipartimentoAmministrativo> listaDipartimentiAmministrativi = dipartimentoAmministrativoService.getAllDipartimentiAmministrativi();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaDipartimentiAmministrativiJson = objectMapper.writeValueAsString(listaDipartimentiAmministrativi);
			return listaDipartimentiAmministrativiJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String DipartimentoAmministrativoById(@PathVariable Long id) throws JsonProcessingException {
		DipartimentoAmministrativo DipartimentoAmministrativo = dipartimentoAmministrativoService.getDipartimentoAmministrativoById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String DipartimentoAmministrativoJson = objectMapper.writeValueAsString(DipartimentoAmministrativo);
		return DipartimentoAmministrativoJson;
	}	
	
	@PostMapping(value = "/addDipartimentoAmministrativo", consumes = "application/json", produces = "application/json")
	public ResponseEntity<DipartimentoAmministrativo> addDipartimentoAmministrativo(@RequestBody DipartimentoAmministrativo DipartimentoAmministrativo) {
	    DipartimentoAmministrativo nuovoDipartimentoAmministrativo = dipartimentoAmministrativoService.saveOrUpdate(DipartimentoAmministrativo);
	    return ResponseEntity.ok(nuovoDipartimentoAmministrativo);
	}
	
	@PutMapping(value = "/editDipartimentoAmministrativo/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<DipartimentoAmministrativo> editDipartimentoAmministrativo(@RequestBody DipartimentoAmministrativo DipartimentoAmministrativo) {
	    DipartimentoAmministrativo nuovoDipartimentoAmministrativo = dipartimentoAmministrativoService.saveOrUpdate(DipartimentoAmministrativo);
	    return ResponseEntity.ok(nuovoDipartimentoAmministrativo);
	}
	
	@DeleteMapping(value = "/deleteDipartimentoAmministrativo/{id}")
	public ResponseEntity<Void> deleteDipartimentoAmministrativo(@PathVariable Long id) {
	    dipartimentoAmministrativoService.deleteDipartimentoAmministrativo(id);
	    return ResponseEntity.noContent().build();
	}
}