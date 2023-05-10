package com.app.hospital.model;

import java.util.Date;

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
@Table(name="Pagamento")
public class Pagamento {
	
	@Id
	@Column(name="idPagamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPagamento;
	
	@Column(name="importo")
	@JsonProperty("importo")
	@NotNull
	private Float importo;
	
	@Column(name="ticket")
	@JsonProperty("ticket")
	private String ticket;
	
	@Column(name="dataPagamento")
	@JsonProperty("dataPagamento")
	@NotNull
	private Date dataPagamento;

}
