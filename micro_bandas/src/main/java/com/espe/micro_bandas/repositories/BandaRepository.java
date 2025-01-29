package com.espe.micro_bandas.repositories;

import com.espe.micro_bandas.models.entities.Banda;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BandaRepository extends JpaRepository<Banda, Long> {
}
