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

import com.app.hospital.model.Trasporto;
import com.app.hospital.service.TrasportoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Trasporto")
public class TrasportoController {
	
	@Autowired
	TrasportoService trasportoService;
	
	@GetMapping(value = "/listaTrasporti", produces = "application/json")
		public String listaTrasporti() throws JsonProcessingException {
			List<Trasporto> listaTrasporti = trasportoService.getAllTrasporti();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaTrasportiJson = objectMapper.writeValueAsString(listaTrasporti);
			return listaTrasportiJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String TrasportoById(@PathVariable Long id) throws JsonProcessingException {
		Trasporto Trasporto = trasportoService.getTrasportoById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String TrasportoJson = objectMapper.writeValueAsString(Trasporto);
		return TrasportoJson;
	}	
	
	@PostMapping(value = "/addTrasporto", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Trasporto> addTrasporto(@RequestBody Trasporto Trasporto) {
	    Trasporto nuovoTrasporto = trasportoService.saveOrUpdate(Trasporto);
	    return ResponseEntity.ok(nuovoTrasporto);
	}
	
	@PutMapping(value = "/editTrasporto/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Trasporto> editTrasporto(@RequestBody Trasporto Trasporto) {
	    Trasporto nuovoTrasporto = trasportoService.saveOrUpdate(Trasporto);
	    return ResponseEntity.ok(nuovoTrasporto);
	}
	
	@DeleteMapping(value = "/deleteTrasporto/{id}")
	public ResponseEntity<Void> deleteTrasporto(@PathVariable Long id) {
	    trasportoService.deleteTrasporto(id);
	    return ResponseEntity.noContent().build();
	}
}