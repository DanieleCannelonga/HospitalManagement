package com.app.hospital.model;

import java.time.LocalDateTime;
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

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="InterventoChirurgico")
public class InterventoChirurgico {
		
		@Id
		@Column(name="idInterventoChirurgico")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idInterventoChirurgico;
		
		@Column(name="esito")
		@JsonProperty("esito")
		private Boolean esito;
		
		@Column(name="note")
		@JsonProperty("note")
		private String note;
		
		@Column(name="oraInizio")
		@JsonProperty("ora_inizio")
		private LocalDateTime oraInizio;
		
		@Column(name="oraFine")
		@JsonProperty("ora_fine")
		private LocalDateTime oraFine;

		@OneToMany
		@JoinColumn(name="idAttrezzaturaMedica")
		@JsonProperty("attrezzatura_medicha")
		private List<AttrezzaturaMedica> listaAttrezzatureMediche;

		@OneToOne
		@JoinColumn(name="idSalaOperatoria")
		@JsonProperty("sala_operatoria")
		private SalaOperatoria salaOperatoria;
}
