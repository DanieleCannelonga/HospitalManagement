package com.app.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hospital.model.Ricovero;

public interface RicoveroRepository extends JpaRepository<Ricovero, Long> {

}
