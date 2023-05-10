package com.app.hospital.model;

import java.time.LocalDateTime;

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
@Table(name="Visita")
public class Visita {
	
	@Id
	@Column(name="idVisita")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVisita;
	
	@Column(name="diagnosi")
	@JsonProperty("diagnosi")
	private String diagnosi;
	
	@Column(name="prescrizioni")
	@JsonProperty("prescrizioni")
	private String prescrizioni;
	
	@Column(name="note")
	@JsonProperty("note")
	private String note;
	
	@Column(name="oraInizio")
	@JsonProperty("ora_inizio")
	private LocalDateTime oraInizio;
	
	@Column(name="oraFine")
	@JsonProperty("ora_fine")
	private LocalDateTime oraFine;

}
