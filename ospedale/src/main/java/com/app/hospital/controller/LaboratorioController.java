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

import com.app.hospital.model.Laboratorio;
import com.app.hospital.service.LaboratorioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Laboratorio")
public class LaboratorioController {
	
	@Autowired
	LaboratorioService laboratorioService;
	
	@GetMapping(value = "/listaLaboratori", produces = "application/json")
		public String listaLaboratori() throws JsonProcessingException {
			List<Laboratorio> listaLaboratori = laboratorioService.getAllLaboratori();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaLaboratoriJson = objectMapper.writeValueAsString(listaLaboratori);
			return listaLaboratoriJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String LaboratorioById(@PathVariable Long id) throws JsonProcessingException {
		Laboratorio Laboratorio = laboratorioService.getLaboratorioById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String LaboratorioJson = objectMapper.writeValueAsString(Laboratorio);
		return LaboratorioJson;
	}	
	
	@PostMapping(value = "/addLaboratorio", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Laboratorio> addLaboratorio(@RequestBody Laboratorio Laboratorio) {
	    Laboratorio nuovoLaboratorio = laboratorioService.saveOrUpdate(Laboratorio);
	    return ResponseEntity.ok(nuovoLaboratorio);
	}
	
	@PutMapping(value = "/editLaboratorio/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Laboratorio> editLaboratorio(@RequestBody Laboratorio Laboratorio) {
	    Laboratorio nuovoLaboratorio = laboratorioService.saveOrUpdate(Laboratorio);
	    return ResponseEntity.ok(nuovoLaboratorio);
	}
	
	@DeleteMapping(value = "/deleteLaboratorio/{id}")
	public ResponseEntity<Void> deleteLaboratorio(@PathVariable Long id) {
	    laboratorioService.deleteLaboratorio(id);
	    return ResponseEntity.noContent().build();
	}
}