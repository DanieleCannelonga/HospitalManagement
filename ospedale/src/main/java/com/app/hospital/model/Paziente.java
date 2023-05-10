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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="Paziente")
public class Paziente {
	
	@Id
	@Column(name="idPaziente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPaziente;
	
	@Column(name="nome")
	@JsonProperty("nome")
	@NotNull
	private String nome;
	
	@Column(name="cognome")
	@JsonProperty("cognome")
	@NotNull
	private String cognome;
	
	@Column(name="dataNascita")
	@JsonProperty("data_nascita")
	@NotNull
	private Date dataNascita;
	
	@Column(name="codiceFiscale")
	@JsonProperty("codice_fiscale")
	@NotNull
	private String codiceFiscale;
	
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
	@NotNull
	private String email;
	
	@Column(name="patologiePregresse")
	@JsonProperty("patologie_pregresse")
	private String patologiePregresse;
	
	@Column(name="allergie")
	@JsonProperty("allergie")
	private String allergie;
	
	@Column(name="dataRegistrazione")
	@JsonProperty("dataRegistrazione")
	@NotNull
	private Date dataRegistrazione;
	
	@OneToMany
	@JoinColumn(name="idPagamento")
	@JsonProperty("pagamenti")
	private List<Pagamento> listaPagamenti;

}
