package com.app.hospital;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.app.hospital.controller.AmbulanzaController;
import com.app.hospital.model.Ambulanza;
import com.app.hospital.service.AmbulanzaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AmbulanzaController.class)
public class AmbulanzaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AmbulanzaService ambulanzaService;
	
	@Test
	public void testListaAmbulanze() throws Exception {
		List<Ambulanza> listaAmbulanze = new ArrayList<Ambulanza>();
		listaAmbulanze.add(new Ambulanza(1L, "Ambulanza1"));
		listaAmbulanze.add(new Ambulanza(2L, "Ambulanza2"));
		
		when(ambulanzaService.getAllAmbulanze()).thenReturn(listaAmbulanze);
		
		mockMvc.perform(get("/Ambulanza/listaAmbulanze")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json("[{\"id\":1,\"nome\":\"Ambulanza1\"},{\"id\":2,\"nome\":\"Ambulanza2\"}]"));
	}
	
	@Test
	public void testAmbulanzaById() throws Exception {
		Ambulanza ambulanza = new Ambulanza(1L, "Ambulanza1");
		
		when(ambulanzaService.getAmbulanzaById(1L)).thenReturn(ambulanza);
		
		mockMvc.perform(get("/Ambulanza/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json("{\"id\":1,\"nome\":\"Ambulanza1\"}"));
	}
	
	@Test
	public void testAddAmbulanza() throws Exception {
		Ambulanza ambulanza = new Ambulanza(1L, "Ambulanza1");
		
		when(ambulanzaService.saveOrUpdate(ambulanza)).thenReturn(ambulanza);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String ambulanzaJson = objectMapper.writeValueAsString(ambulanza);
		
		mockMvc.perform(post("/Ambulanza/addAmbulanza")
				.content(ambulanzaJson)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.nome").value("Ambulanza1"));
	}
	
	@Test
	public void testEditAmbulanza() throws Exception {
		Ambulanza ambulanza = new Ambulanza(1L, "Ambulanza1");
		
		when(ambulanzaService.saveOrUpdate(ambulanza)).thenReturn(ambulanza);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String ambulanzaJson = objectMapper.writeValueAsString(ambulanza);
		
		mockMvc.perform(put("/Ambulanza/editAmbulanza/1")
				.content(ambulanzaJson)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.nome").value("Ambulanza1"));
	}
	
	@Test
	public void testDeleteAmbulanza() throws Exception {
		mockMvc.perform(delete("/Ambulanza/deleteAmbulanza/1"))
		.andExpect(status().isNoContent());
	}
}