package com.app.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="Archivio")
public class Archivio {
	
	@Id
	@Column(name="idArchivio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArchivio;
	
	@Column(name="documentiCartacei")
	@JsonProperty("documenti_cartacei")
	private String documentiCartacei;
	
	@Column(name="documentiDigitali")
	@JsonProperty("documenti_digitali")
	private String documentiDigitali;
	
	@Column(name="registrazioniPazienti")
	@JsonProperty("registrazioni_pazienti")
	private String registrazioniPazienti;
	
	@Column(name="fatture")
	@JsonProperty("fatture")
	private String fatture;

}
