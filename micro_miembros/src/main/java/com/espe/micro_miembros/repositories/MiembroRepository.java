package com.espe.micro_miembros.repositories;

import com.espe.micro_miembros.models.entities.Miembros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiembroRepository extends JpaRepository<Miembros, Long> {
}
