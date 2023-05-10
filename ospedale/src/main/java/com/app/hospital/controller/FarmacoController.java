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

import com.app.hospital.model.Farmaco;
import com.app.hospital.service.FarmacoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Farmaco")
public class FarmacoController {
	
	@Autowired
	FarmacoService farmacoService;
	
	@GetMapping(value = "/listaFarmaci", produces = "application/json")
		public String listaFarmaci() throws JsonProcessingException {
			List<Farmaco> listaFarmaci = farmacoService.getAllFarmaci();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaFarmaciJson = objectMapper.writeValueAsString(listaFarmaci);
			return listaFarmaciJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String FarmacoById(@PathVariable Long id) throws JsonProcessingException {
		Farmaco Farmaco = farmacoService.getFarmacoById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String FarmacoJson = objectMapper.writeValueAsString(Farmaco);
		return FarmacoJson;
	}	
	
	@PostMapping(value = "/addFarmaco", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Farmaco> addFarmaco(@RequestBody Farmaco Farmaco) {
	    Farmaco nuovoFarmaco = farmacoService.saveOrUpdate(Farmaco);
	    return ResponseEntity.ok(nuovoFarmaco);
	}
	
	@PutMapping(value = "/editFarmaco/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Farmaco> editFarmaco(@RequestBody Farmaco Farmaco) {
	    Farmaco nuovoFarmaco = farmacoService.saveOrUpdate(Farmaco);
	    return ResponseEntity.ok(nuovoFarmaco);
	}
	
	@DeleteMapping(value = "/deleteFarmaco/{id}")
	public ResponseEntity<Void> deleteFarmaco(@PathVariable Long id) {
	    farmacoService.deleteFarmaco(id);
	    return ResponseEntity.noContent().build();
	}
}