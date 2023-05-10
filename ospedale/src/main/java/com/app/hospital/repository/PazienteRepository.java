package com.app.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hospital.model.Paziente;

public interface PazienteRepository extends JpaRepository<Paziente, Long> {

}
