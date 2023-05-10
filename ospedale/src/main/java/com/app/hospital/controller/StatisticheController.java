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

import com.app.hospital.model.Statistiche;
import com.app.hospital.service.StatisticheService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Statistiche")
public class StatisticheController {
	
	@Autowired
	StatisticheService statisticheService;
	
	@GetMapping(value = "/listaStatistiche", produces = "application/json")
		public String listaStatistiche() throws JsonProcessingException {
			List<Statistiche> listaStatistiche = statisticheService.getAllStatistiche();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaStatisticheJson = objectMapper.writeValueAsString(listaStatistiche);
			return listaStatisticheJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String StatisticheById(@PathVariable Long id) throws JsonProcessingException {
		Statistiche Statistiche = statisticheService.getStatisticheById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String StatisticheJson = objectMapper.writeValueAsString(Statistiche);
		return StatisticheJson;
	}	
	
	@PostMapping(value = "/addStatistiche", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Statistiche> addStatistiche(@RequestBody Statistiche Statistiche) {
	    Statistiche nuovoStatistiche = statisticheService.saveOrUpdate(Statistiche);
	    return ResponseEntity.ok(nuovoStatistiche);
	}
	
	@PutMapping(value = "/editStatistiche/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Statistiche> editStatistiche(@RequestBody Statistiche Statistiche) {
	    Statistiche nuovoStatistiche = statisticheService.saveOrUpdate(Statistiche);
	    return ResponseEntity.ok(nuovoStatistiche);
	}
	
	@DeleteMapping(value = "/deleteStatistiche/{id}")
	public ResponseEntity<Void> deleteStatistiche(@PathVariable Long id) {
	    statisticheService.deleteStatistiche(id);
	    return ResponseEntity.noContent().build();
	}
}