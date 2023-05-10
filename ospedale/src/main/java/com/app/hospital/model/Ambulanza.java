package com.app.hospital.model;

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
@Table(name="Ambulanza")
public class Ambulanza {
	
	@Id
	@Column(name="idAmbulanza")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAmbulanza;
	
	@Column(name="descrizione")
	@JsonProperty("descrizione")
	private String descrizione;
	
	@Column(name="targa")
	@JsonProperty("targa")
	@NotNull
	private String targa;
	
	@Column(name="disponibile")
	@JsonProperty("disponibile")
	@NotNull
	private Boolean disponibile;

	public Long getIdAmbulanza() {
		return idAmbulanza;
	}

	public void setIdAmbulanza(Long idAmbulanza) {
		this.idAmbulanza = idAmbulanza;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Boolean getDisponibile() {
		return disponibile;
	}

	public void setDisponibile(Boolean disponibile) {
		this.disponibile = disponibile;
	}
	
	

}
