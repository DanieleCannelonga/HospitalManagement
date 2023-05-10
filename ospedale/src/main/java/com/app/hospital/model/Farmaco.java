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
@Table(name="Farmaco")
public class Farmaco {
	
	@Id
	@Column(name="idFarmaco")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFarmaco;
	
	@Column(name="nome")
	@JsonProperty("nome")
	@NotNull
	private String nome;
	
	@Column(name="descrizione")
	@JsonProperty("descrizione")
	private String descrizione;
	
	@Column(name="dosaggio")
	@JsonProperty("dosaggio")
	@NotNull
	private String dosaggio;
	
	@Column(name="prezzo")
	@JsonProperty("prezzo")
	private String prezzo;
	
	@Column(name="produttore")
	@JsonProperty("produttore")
	private String produttore;
	
	@Column(name="effettiCollaterali")
	@JsonProperty("effetti_collaterali")
	private String effettiCollaterali;

}
