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
@Table(name="SistemaSicurezza")
public class SistemaSicurezza {
	
	@Id
	@Column(name="idSistemaSicurezza")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSistemaSicurezza;
	
	@Column(name="registrazioneAccessi")
	@JsonProperty("registrazione_accessi")
	private String registrazioneAccessi;
	
	@Column(name="controlloAccessi")
	@JsonProperty("controllo_accessi")
	private String controlloAccessi;
	
	@Column(name="sistemaAllarme")
	@JsonProperty("sistema_allarme")
	private String sistemaAllarme;
	
	@Column(name="sistemaVideosorveglianza")
	@JsonProperty("sistema_videosorveglianza")
	private String sistemaVideosorveglianza;

}
