package com.app.hospital.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="CartellaClinica")
public class CartellaClinica {
	
	@Id
	@Column(name="idCartellaClinica")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCartellaClinica;
	
	@Column(name="diagnosi")
	@JsonProperty("diagnosi")
	private String diagnosi;
	
	@Column(name="esamiEffettuati")
	@JsonProperty("esami_effettuati")
	private String esamiEffettuati;
	
	@Column(name="prescrizioni")
	@JsonProperty("prescrizioni")
	private String prescrizioni;
	
	@Column(name="terapie")
	@JsonProperty("terapie")
	private String terapie;
	
	@Column(name="note")
	@JsonProperty("note")
	private String note;
	
	@Column(name="dataCreazione")
	@JsonProperty("data_creazione")
	private Date dataCreazione;
	
	@Column(name="dataAggiornamento")
	@JsonProperty("data_aggiornamento")
	private Date dataAggiornamento;
	
	@OneToOne
	@JoinColumn(name="idPaziente")
	@JsonProperty("paziente")
	@NotNull
	private Paziente paziente;
	
	@OneToMany
	@JoinColumn(name="idPersonale")
	@JsonProperty("personale")
	@NotNull
	private List<Personale> listaPersonale;
	
	@OneToMany
	@JoinColumn(name="idVisita")
	@JsonProperty("visite")
	private List<Visita> listaVisite;
	
	@OneToMany
	@JoinColumn(name="idFarmaco")
	@JsonProperty("farmaci")
	private List<Farmaco> listaFarmaci;

	@OneToMany
	@JoinColumn(name="idInterventoChirurgico")
	@JsonProperty("interventi_chirurgici")
	private List<InterventoChirurgico> listaInterventiChirurgici;

	@OneToMany
	@JoinColumn(name="idEsameDiagnostico")
	@JsonProperty("esami_diagnostici")
	private List<EsameDiagnostico> ListaEsamiDiagnostici;

	@OneToMany
	@JoinColumn(name="idRicovero")
	@JsonProperty("ricoveri")
	@NotNull
	private List<Ricovero> listaRicoveri;

	@OneToMany
	@JoinColumn(name="idReparto")
	@JsonProperty("reparti")
	@NotNull
	private List<Reparto> listaReparti;

	@OneToMany
	@JoinColumn(name="idAppuntamento")
	@JsonProperty("appuntamenti")
	private List<Appuntamento> listaAppuntamenti;
}
