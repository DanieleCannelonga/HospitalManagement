package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Trasporto;
import com.app.hospital.repository.TrasportoRepository;

@Service
@Transactional
public class TrasportoServiceImpl implements TrasportoService {
	
	@Autowired
	TrasportoRepository trasportoRepository;

	@Override
	public List<Trasporto> getAllTrasporti() {
		return (List<Trasporto>) trasportoRepository.findAll();
	}

	@Override
	public Trasporto getTrasportoById(Long idTrasporto) {
		return trasportoRepository.findById(idTrasporto).get();
	}

	@Override
	public Trasporto saveOrUpdate(Trasporto trasporto) {
		return trasportoRepository.save(trasporto);
	}

	@Override
	public void deleteTrasporto(Long idTrasporto) {
		trasportoRepository.deleteById(idTrasporto);
	}

}
