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
@Table(name="Ambulanza")
public class Ambulanza {
	
	@Id
	@Column(name="idAmbulanza")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAmbulanza;
	
	@Column(name="descrizione")
	@JsonProperty("descrizione")
	private String descrizione;
	
	@Column(name="targa")
	@JsonProperty("targa")
	private String targa;
	
	@Column(name="disponibile")
	@JsonProperty("disponibile")
	private Boolean disponibile;

}
