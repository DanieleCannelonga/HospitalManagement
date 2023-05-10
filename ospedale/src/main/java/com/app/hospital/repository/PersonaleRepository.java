package com.app.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hospital.model.Personale;

public interface PersonaleRepository extends JpaRepository<Personale, Long> {

}
