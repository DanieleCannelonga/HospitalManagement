package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.CartellaClinica;
import com.app.hospital.repository.CartellaClinicaRepository;

@Service
@Transactional
public class CartellaClinicaServiceImpl implements CartellaClinicaService {
	
	@Autowired
	CartellaClinicaRepository cartellaClinicaRepository;

	@Override
	public List<CartellaClinica> getAllCartelleCliniche() {
		return (List<CartellaClinica>) cartellaClinicaRepository.findAll();
	}

	@Override
	public CartellaClinica getCartellaClinicaById(Long idCartellaClinica) {
		return cartellaClinicaRepository.findById(idCartellaClinica).get();
	}

	@Override
	public CartellaClinica saveOrUpdate(CartellaClinica cartellaClinica) {
		return cartellaClinicaRepository.save(cartellaClinica);
	}

	@Override
	public void deleteCartellaClinica(Long idCartellaClinica) {
		cartellaClinicaRepository.deleteById(idCartellaClinica);
	}

}
