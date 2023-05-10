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

import com.app.hospital.model.AttrezzaturaMedica;
import com.app.hospital.service.AttrezzaturaMedicaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/AttrezzaturaMedica")
public class AttrezzaturaMedicaController {
	
	@Autowired
	AttrezzaturaMedicaService attrezzaturaMedicaService;
	
	@GetMapping(value = "/listaAttrezzatureMediche", produces = "application/json")
		public String listaAttrezzatureMediche() throws JsonProcessingException {
			List<AttrezzaturaMedica> listaAttrezzatureMediche = attrezzaturaMedicaService.getAllAttrezzatureMediche();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaAttrezzatureMedicheJson = objectMapper.writeValueAsString(listaAttrezzatureMediche);
			return listaAttrezzatureMedicheJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String AttrezzaturaMedicaById(@PathVariable Long id) throws JsonProcessingException {
		AttrezzaturaMedica AttrezzaturaMedica = attrezzaturaMedicaService.getAttrezzaturaMedicaById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String AttrezzaturaMedicaJson = objectMapper.writeValueAsString(AttrezzaturaMedica);
		return AttrezzaturaMedicaJson;
	}	
	
	@PostMapping(value = "/addAttrezzaturaMedica", consumes = "application/json", produces = "application/json")
	public ResponseEntity<AttrezzaturaMedica> addAttrezzaturaMedica(@RequestBody AttrezzaturaMedica AttrezzaturaMedica) {
	    AttrezzaturaMedica nuovoAttrezzaturaMedica = attrezzaturaMedicaService.saveOrUpdate(AttrezzaturaMedica);
	    return ResponseEntity.ok(nuovoAttrezzaturaMedica);
	}
	
	@PutMapping(value = "/editAttrezzaturaMedica/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<AttrezzaturaMedica> editAttrezzaturaMedica(@RequestBody AttrezzaturaMedica AttrezzaturaMedica) {
	    AttrezzaturaMedica nuovoAttrezzaturaMedica = attrezzaturaMedicaService.saveOrUpdate(AttrezzaturaMedica);
	    return ResponseEntity.ok(nuovoAttrezzaturaMedica);
	}
	
	@DeleteMapping(value = "/deleteAttrezzaturaMedica/{id}")
	public ResponseEntity<Void> deleteAttrezzaturaMedica(@PathVariable Long id) {
	    attrezzaturaMedicaService.deleteAttrezzaturaMedica(id);
	    return ResponseEntity.noContent().build();
	}
}