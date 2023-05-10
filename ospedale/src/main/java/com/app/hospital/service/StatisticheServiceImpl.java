package com.app.hospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hospital.model.Statistiche;
import com.app.hospital.repository.StatisticheRepository;

@Service
@Transactional
public class StatisticheServiceImpl implements StatisticheService {
	
	@Autowired
	StatisticheRepository statisticheRepository;

	@Override
	public List<Statistiche> getAllStatistiche() {
		return (List<Statistiche>) statisticheRepository.findAll();
	}

	@Override
	public Statistiche getStatisticheById(Long idStatistiche) {
		return statisticheRepository.findById(idStatistiche).get();
	}

	@Override
	public Statistiche saveOrUpdate(Statistiche statistiche) {
		return statisticheRepository.save(statistiche);
	}

	@Override
	public void deleteStatistiche(Long idStatistiche) {
		statisticheRepository.deleteById(idStatistiche);
	}

}
