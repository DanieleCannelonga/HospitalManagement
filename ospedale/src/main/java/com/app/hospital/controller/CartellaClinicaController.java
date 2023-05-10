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

import com.app.hospital.model.CartellaClinica;
import com.app.hospital.service.CartellaClinicaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/CartellaClinica")
public class CartellaClinicaController {
	
	@Autowired
	CartellaClinicaService cartellaClinicaService;
	
	@GetMapping(value = "/listaCartelleCliniche", produces = "application/json")
		public String listaCartelleCliniche() throws JsonProcessingException {
			List<CartellaClinica> listaCartelleCliniche = cartellaClinicaService.getAllCartelleCliniche();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaCartelleClinicheJson = objectMapper.writeValueAsString(listaCartelleCliniche);
			return listaCartelleClinicheJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String CartellaClinicaById(@PathVariable Long id) throws JsonProcessingException {
		CartellaClinica CartellaClinica = cartellaClinicaService.getCartellaClinicaById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String CartellaClinicaJson = objectMapper.writeValueAsString(CartellaClinica);
		return CartellaClinicaJson;
	}	
	
	@PostMapping(value = "/addCartellaClinica", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CartellaClinica> addCartellaClinica(@RequestBody CartellaClinica CartellaClinica) {
	    CartellaClinica nuovoCartellaClinica = cartellaClinicaService.saveOrUpdate(CartellaClinica);
	    return ResponseEntity.ok(nuovoCartellaClinica);
	}
	
	@PutMapping(value = "/editCartellaClinica/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CartellaClinica> editCartellaClinica(@RequestBody CartellaClinica CartellaClinica) {
	    CartellaClinica nuovoCartellaClinica = cartellaClinicaService.saveOrUpdate(CartellaClinica);
	    return ResponseEntity.ok(nuovoCartellaClinica);
	}
	
	@DeleteMapping(value = "/deleteCartellaClinica/{id}")
	public ResponseEntity<Void> deleteCartellaClinica(@PathVariable Long id) {
	    cartellaClinicaService.deleteCartellaClinica(id);
	    return ResponseEntity.noContent().build();
	}
}