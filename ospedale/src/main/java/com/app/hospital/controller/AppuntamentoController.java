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

import com.app.hospital.model.Appuntamento;
import com.app.hospital.service.AppuntamentoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Appuntamento")
public class AppuntamentoController {
	
	@Autowired
	AppuntamentoService appuntamentoService;
	
	@GetMapping(value = "/listaAppuntamenti", produces = "application/json")
		public String listaAppuntamenti() throws JsonProcessingException {
			List<Appuntamento> listaAppuntamenti = appuntamentoService.getAllAppuntamenti();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaAppuntamentiJson = objectMapper.writeValueAsString(listaAppuntamenti);
			return listaAppuntamentiJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String AppuntamentoById(@PathVariable Long id) throws JsonProcessingException {
		Appuntamento Appuntamento = appuntamentoService.getAppuntamentoById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String AppuntamentoJson = objectMapper.writeValueAsString(Appuntamento);
		return AppuntamentoJson;
	}	
	
	@PostMapping(value = "/addAppuntamento", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Appuntamento> addAppuntamento(@RequestBody Appuntamento Appuntamento) {
	    Appuntamento nuovoAppuntamento = appuntamentoService.saveOrUpdate(Appuntamento);
	    return ResponseEntity.ok(nuovoAppuntamento);
	}
	
	@PutMapping(value = "/editAppuntamento/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Appuntamento> editAppuntamento(@RequestBody Appuntamento Appuntamento) {
	    Appuntamento nuovoAppuntamento = appuntamentoService.saveOrUpdate(Appuntamento);
	    return ResponseEntity.ok(nuovoAppuntamento);
	}
	
	@DeleteMapping(value = "/deleteAppuntamento/{id}")
	public ResponseEntity<Void> deleteAppuntamento(@PathVariable Long id) {
	    appuntamentoService.deleteAppuntamento(id);
	    return ResponseEntity.noContent().build();
	}
}