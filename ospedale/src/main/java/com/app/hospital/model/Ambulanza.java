package com.app.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@NotNull
	private String targa;
	
	@Column(name="disponibile")
	@JsonProperty("disponibile")
	@NotNull
	private Boolean disponibile;

}
