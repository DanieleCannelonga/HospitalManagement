package com.app.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hospital.model.Ambulanza;

public interface AmbulanzaRepository extends JpaRepository<Ambulanza, Long> {

}
