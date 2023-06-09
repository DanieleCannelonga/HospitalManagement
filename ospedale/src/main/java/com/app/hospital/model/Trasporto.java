package com.app.hospital.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="Trasporto")
public class Trasporto {
	
	@Id
	@Column(name="idTrasporto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTrasporto;
	
	@Column(name="descrizione")
	@JsonProperty("descrizione")
	private String descrizione;
	
	@Column(name="oraInizio")
	@JsonProperty("ora_inizio")
	@NotNull
	private LocalDateTime oraInizio;
	
	@Column(name="oraFine")
	@JsonProperty("ora_fine")
	@NotNull
	private LocalDateTime oraFine;
	
	@OneToOne
	@JoinColumn(name="idPaziente")
	@JsonProperty("paziente")
	@NotNull
	private Paziente paziente;

	@OneToOne
	@JoinColumn(name="idAmbulanza")
	@JsonProperty("ambulanza")
	@NotNull
	private Ambulanza Ambulanza;

}
