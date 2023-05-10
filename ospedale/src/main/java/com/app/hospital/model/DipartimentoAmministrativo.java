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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="DipartimentoAmministrativo")
public class DipartimentoAmministrativo {
	
	@Id
	@Column(name="idDipartimentoAmministrativo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDipartimentoAmministrativo;
	
	@Column(name="nome")
	@JsonProperty("nome")
	@NotNull
	private String nome;
	
	@Column(name="descrizione")
	@JsonProperty("descrizione")
	private String descrizione;
	
	@Column(name="indirizzo")
	@JsonProperty("indirizzo")
	@NotNull
	private String indirizzo;
	
	@Column(name="numeroTelefono")
	@JsonProperty("numero_telefono")
	@NotNull
	private Integer numeroTelefono;
	
	@Column(name="email")
	@JsonProperty("email")
	private String email;
	
	@Column(name="pec")
	@JsonProperty("pec")
	@NotNull
	private String pec;

	@OneToMany
	@JoinColumn(name="idArchivio")
	@JsonProperty("archivio")
	private List<Archivio> listaArchivio;

	@OneToMany
	@JoinColumn(name="idSistemaSicurezza")
	@JsonProperty("sistema_sicurezza")
	private List<SistemaSicurezza> listaSistemaSicurezza;

	@OneToMany
	@JoinColumn(name="idStatistiche")
	@JsonProperty("statistiche")
	private List<Statistiche> listaStatistiche;

	@OneToMany
	@JoinColumn(name="idLaboratorio")
	@JsonProperty("laboratori")
	private List<Laboratorio> listaLaboratori;

}
