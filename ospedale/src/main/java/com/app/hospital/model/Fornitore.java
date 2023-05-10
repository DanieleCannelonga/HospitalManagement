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
@Table(name="Fornitore")
public class Fornitore {
	
	@Id
	@Column(name="idFornitore")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFornitore;
	
	@Column(name="nome")
	@JsonProperty("nome")
	private String nome;
	
	@Column(name="descrizione")
	@JsonProperty("descrizione")
	private String descrizione;
	
	@Column(name="indirizzo")
	@JsonProperty("indirizzo")
	private String indirizzo;
	
	@Column(name="numeroTelefono")
	@JsonProperty("numero_telefono")
	private Integer numeroTelefono;
	
	@Column(name="email")
	@JsonProperty("email")
	private String email;
	
	@Column(name="prodottiForniti")
	@JsonProperty("prodotti_forniti")
	private String prodottiForniti;

}
