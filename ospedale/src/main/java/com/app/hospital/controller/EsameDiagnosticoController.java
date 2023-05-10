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

import com.app.hospital.model.EsameDiagnostico;
import com.app.hospital.service.EsameDiagnosticoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/EsameDiagnostico")
public class EsameDiagnosticoController {
	
	@Autowired
	EsameDiagnosticoService esameDiagnosticoService;
	
	@GetMapping(value = "/listaEsamiDiagnostici", produces = "application/json")
		public String listaEsamiDiagnostici() throws JsonProcessingException {
			List<EsameDiagnostico> listaEsamiDiagnostici = esameDiagnosticoService.getAllEsamiDiagnostici();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaEsamiDiagnosticiJson = objectMapper.writeValueAsString(listaEsamiDiagnostici);
			return listaEsamiDiagnosticiJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String EsameDiagnosticoById(@PathVariable Long id) throws JsonProcessingException {
		EsameDiagnostico EsameDiagnostico = esameDiagnosticoService.getEsameDiagnosticoById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String EsameDiagnosticoJson = objectMapper.writeValueAsString(EsameDiagnostico);
		return EsameDiagnosticoJson;
	}	
	
	@PostMapping(value = "/addEsameDiagnostico", consumes = "application/json", produces = "application/json")
	public ResponseEntity<EsameDiagnostico> addEsameDiagnostico(@RequestBody EsameDiagnostico EsameDiagnostico) {
	    EsameDiagnostico nuovoEsameDiagnostico = esameDiagnosticoService.saveOrUpdate(EsameDiagnostico);
	    return ResponseEntity.ok(nuovoEsameDiagnostico);
	}
	
	@PutMapping(value = "/editEsameDiagnostico/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<EsameDiagnostico> editEsameDiagnostico(@RequestBody EsameDiagnostico EsameDiagnostico) {
	    EsameDiagnostico nuovoEsameDiagnostico = esameDiagnosticoService.saveOrUpdate(EsameDiagnostico);
	    return ResponseEntity.ok(nuovoEsameDiagnostico);
	}
	
	@DeleteMapping(value = "/deleteEsameDiagnostico/{id}")
	public ResponseEntity<Void> deleteEsameDiagnostico(@PathVariable Long id) {
	    esameDiagnosticoService.deleteEsameDiagnostico(id);
	    return ResponseEntity.noContent().build();
	}
}