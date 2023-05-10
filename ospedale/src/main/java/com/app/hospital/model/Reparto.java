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
@Table(name="Reparto")
public class Reparto {
	
	@Id
	@Column(name="idReparto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReparto;
	
	@Column(name="nomeReparto")
	@JsonProperty("nome_reparto")
	@NotNull
	private String nomeReparto;
	
	@Column(name="descrizione")
	@JsonProperty("descrizione")
	private String descrizione;
	
	@Column(name="postiLetto")
	@JsonProperty("posti_letto")
	private Integer numeroPostiLetto;

}
