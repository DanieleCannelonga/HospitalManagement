package com.app.hospital.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="Laboratorio")
public class Laboratorio {
	
	@Id
	@Column(name="idLaboratorio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLaboratorio;
	
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
	
	@Column(name="pec")
	@JsonProperty("pec")
	private String pec;

	@OneToMany
	@JoinColumn(name="idFornitore")
	@JsonProperty("fornitore")
	private List<Fornitore> listaFornitori;

	@OneToMany
	@JoinColumn(name="idAttrezzatureMediche")
	@JsonProperty("attrezzature_mediche")
	private List<AttrezzaturaMedica> listaAttrezzatureMediche;

}
