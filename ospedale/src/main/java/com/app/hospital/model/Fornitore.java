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
@Table(name="Fornitore")
public class Fornitore {
	
	@Id
	@Column(name="idFornitore")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFornitore;
	
	@Column(name="ragioneSociale")
	@JsonProperty("ragione_sociale")
	@NotNull
	private String ragioneSociale;
	
	@Column(name="descrizione")
	@JsonProperty("descrizione")
	private String descrizione;
	
	@Column(name="partitaIva")
	@JsonProperty("partita_iva")
	@NotNull
	private Integer partitaIva;
	
	@Column(name="indirizzo")
	@JsonProperty("indirizzo")
	private String indirizzo;
	
	@Column(name="numeroTelefono")
	@JsonProperty("numero_telefono")
	@NotNull
	private Integer numeroTelefono;
	
	@Column(name="email")
	@JsonProperty("email")
	private String email;
	
	@Column(name="prodottiForniti")
	@JsonProperty("prodotti_forniti")
	private String prodottiForniti;

}
