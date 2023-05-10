package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.CartellaClinica;

public interface CartellaClinicaService {
	
	public List<CartellaClinica> getAllCartelleCliniche();

	CartellaClinica saveOrUpdate(CartellaClinica cartellaClinica);

	CartellaClinica getCartellaClinicaById(Long idCartellaClinica);

	void deleteCartellaClinica(Long idCartellaClinica);

}
