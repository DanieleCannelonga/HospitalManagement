package com.app.hospital.model;

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
@Table(name="AttrezzaturaMedica")
public class AttrezzaturaMedica {
	
	@Id
	@Column(name="idAttrezzaturaMedica")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAttrezzaturaMedica;
	
	@Column(name="nome")
	@JsonProperty("nome")
	private String nome;
	
	@Column(name="descrizione")
	@JsonProperty("descrizione")
	private String descrizione;
	
	@Column(name="costo")
	@JsonProperty("costo")
	private String costo;
	
	@Column(name="dataAcquisto")
	@JsonProperty("data_acquisto")
	private Date dataAcquisto;
	
	@Column(name="dataManutenzione")
	@JsonProperty("data_manutenzione")
	private Date dataManutenzione;

}
