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

import com.app.hospital.model.Pagamento;
import com.app.hospital.service.PagamentoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Pagamento")
public class PagamentoController {
	
	@Autowired
	PagamentoService pagamentoService;
	
	@GetMapping(value = "/listaPagamenti", produces = "application/json")
		public String listaPagamenti() throws JsonProcessingException {
			List<Pagamento> listaPagamenti = pagamentoService.getAllPagamenti();
			ObjectMapper objectMapper = new ObjectMapper();
			String listaPagamentiJson = objectMapper.writeValueAsString(listaPagamenti);
			return listaPagamentiJson;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public String PagamentoById(@PathVariable Long id) throws JsonProcessingException {
		Pagamento Pagamento = pagamentoService.getPagamentoById(id);
		ObjectMapper objectMapper = new ObjectMapper();
		String PagamentoJson = objectMapper.writeValueAsString(Pagamento);
		return PagamentoJson;
	}	
	
	@PostMapping(value = "/addPagamento", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Pagamento> addPagamento(@RequestBody Pagamento Pagamento) {
	    Pagamento nuovoPagamento = pagamentoService.saveOrUpdate(Pagamento);
	    return ResponseEntity.ok(nuovoPagamento);
	}
	
	@PutMapping(value = "/editPagamento/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Pagamento> editPagamento(@RequestBody Pagamento Pagamento) {
	    Pagamento nuovoPagamento = pagamentoService.saveOrUpdate(Pagamento);
	    return ResponseEntity.ok(nuovoPagamento);
	}
	
	@DeleteMapping(value = "/deletePagamento/{id}")
	public ResponseEntity<Void> deletePagamento(@PathVariable Long id) {
	    pagamentoService.deletePagamento(id);
	    return ResponseEntity.noContent().build();
	}
}