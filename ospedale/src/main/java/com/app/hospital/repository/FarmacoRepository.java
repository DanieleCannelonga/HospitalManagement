package com.app.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hospital.model.Farmaco;

public interface FarmacoRepository extends JpaRepository<Farmaco, Long> {

}
