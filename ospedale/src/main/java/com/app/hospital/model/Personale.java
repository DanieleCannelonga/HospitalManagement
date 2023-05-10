package com.app.hospital.model;

import java.time.LocalDateTime;
import java.util.Date;

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
@Table(name="Personale")
public class Personale {
	
	@Id
	@Column(name="idPersonale")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonale;
	
	@Column(name="nome")
	@JsonProperty("nome")
	private String nome;
	
	@Column(name="cognome")
	@JsonProperty("cognome")
	private String cognome;
	
	@Column(name="dataNascita")
	@JsonProperty("data_nascita")
	private Date dataNascita;
	
	@Column(name="codiceFiscale")
	@JsonProperty("codice_fiscale")
	private String codiceFiscale;
	
	@Column(name="indirizzo")
	@JsonProperty("indirizzo")
	private String indirizzo;
	
	@Column(name="numeroTelefono")
	@JsonProperty("numero_telefono")
	private Integer numeroTelefono;
	
	@Column(name="email")
	@JsonProperty("email")
	private String email;
	
	@Column(name="specializzazione")
	@JsonProperty("specializzazione")
	private String specializzazione;
	
	@Column(name="ruolo")
	@JsonProperty("ruolo")
	private String ruolo;
	
	@Column(name="orarioLavoro")
	@JsonProperty("orario_lavoro")
	private LocalDateTime orarioLavoro;
	
	@Column(name="stipendio")
	@JsonProperty("stipendio")
	private Float stipendio;

}
