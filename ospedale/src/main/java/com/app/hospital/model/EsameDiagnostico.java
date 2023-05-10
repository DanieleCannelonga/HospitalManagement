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
@Table(name="EsameDiagnostico")
public class EsameDiagnostico {
	
	@Id
	@Column(name="idEsameDiagnostico")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEsameDiagnostico;
	
	@Column(name="tipoEsame")
	@JsonProperty("tipo_esame")
	private String tipoEsame;
	
	@Column(name="risultatiEsame")
	@JsonProperty("risultati_esame")
	private String risultatiEsame;
	
	@Column(name="note")
	@JsonProperty("note")
	private String note;
	
	@Column(name="oraInizio")
	@JsonProperty("ora_inizio")
	private LocalDateTime oraInizio;
	
	@Column(name="oraFine")
	@JsonProperty("ora_fine")
	private LocalDateTime oraFine;

}
