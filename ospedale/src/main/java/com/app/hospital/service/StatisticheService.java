package com.app.hospital.service;

import java.util.List;

import com.app.hospital.model.Statistiche;

public interface StatisticheService {
	
	public List<Statistiche> getAllStatistiche();

	Statistiche saveOrUpdate(Statistiche statistiche);

	Statistiche getStatisticheById(Long idStatistiche);

	void deleteStatistiche(Long idStatistiche);

}
