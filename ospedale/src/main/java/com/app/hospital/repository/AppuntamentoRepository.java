package com.app.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hospital.model.Appuntamento;

public interface AppuntamentoRepository extends JpaRepository<Appuntamento, Long> {

}
