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
@Table(name="SalaOperatoria")
public class SalaOperatoria {
	
	@Id
	@Column(name="idSalaOperatoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSalaOperatoria;
	
	@Column(name="nome")
	@JsonProperty("nome")
	private String nome;
	
	@Column(name="descrizione")
	@JsonProperty("descrizione")
	private String descrizione;
	
	@Column(name="oraPrenotazione")
	@JsonProperty("ora_prenotazione")
	private LocalDateTime oraPrenotazione;

}
