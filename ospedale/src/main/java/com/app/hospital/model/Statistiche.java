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
@Table(name="Statistiche")
public class Statistiche {
	
	@Id
	@Column(name="idStatistiche")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStatistiche;
	
	@Column(name="datiPazienti")
	@JsonProperty("dati_pazienti")
	private String datiPazienti;
	
	@Column(name="datiPersonale")
	@JsonProperty("dati_personale")
	private String datiPersonale;
	
	@Column(name="datiRicoveri")
	@JsonProperty("dati_ricoveri")
	private String datiRicoveri;
	
	@Column(name="datiFarmaci")
	@JsonProperty("dati_farmaci")
	private String datiFarmaci;
	
	@Column(name="datiAttrezzatureMediche")
	@JsonProperty("dati_attrezzature_mediche")
	private String datiAttrezzatureMediche;
	
	@Column(name="datiCosti")
	@JsonProperty("dati_costi")
	private String datiCosti;

}
