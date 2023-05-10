package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Pagamento;

public interface PagamentoService {
	
	public List<Pagamento> getAllPagamenti();

	Pagamento saveOrUpdate(Pagamento pagamento);

	Pagamento getPagamentoById(Long idPagamento);

	void deletePagamento(Long idPagamento);

}
