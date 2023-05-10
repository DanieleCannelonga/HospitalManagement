package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Pagamento;
import com.app.hospital.repository.PagamentoRepository;

@Service
@Transactional
public class PagamentoServiceImpl implements PagamentoService {
	
	@Autowired
	PagamentoRepository pagamentoRepository;

	@Override
	public List<Pagamento> getAllPagamenti() {
		return (List<Pagamento>) pagamentoRepository.findAll();
	}

	@Override
	public Pagamento getPagamentoById(Long idPagamento) {
		return pagamentoRepository.findById(idPagamento).get();
	}

	@Override
	public Pagamento saveOrUpdate(Pagamento pagamento) {
		return pagamentoRepository.save(pagamento);
	}

	@Override
	public void deletePagamento(Long idPagamento) {
		pagamentoRepository.deleteById(idPagamento);
	}

}
