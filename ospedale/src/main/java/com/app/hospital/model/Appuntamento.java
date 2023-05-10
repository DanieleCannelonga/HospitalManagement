package com.app.hospital.model;

import java.time.LocalDateTime;

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
@Table(name="Appuntamento")
public class Appuntamento {
	
	@Id
	@Column(name="idAppuntamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAppuntamento;
	
	@Column(name="tipoAppuntamento")
	@JsonProperty("tipo_appuntamento")
	@NotNull
	private String tipoAppuntamento;
	
	@Column(name="oraInizio")
	@JsonProperty("ora_inizio")
	@NotNull
	private LocalDateTime oraInizio;
	
	@Column(name="oraFine")
	@JsonProperty("ora_fine")
	@NotNull
	private LocalDateTime oraFine;

}
