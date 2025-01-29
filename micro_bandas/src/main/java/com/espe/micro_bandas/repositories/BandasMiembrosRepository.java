package com.espe.micro_bandas.repositories;

import com.espe.micro_bandas.models.entities.BandasMiembros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BandasMiembrosRepository extends JpaRepository<BandasMiembros, Long> {
    List<BandasMiembros> findByBandaId(Long bandaId);

    List<BandasMiembros> findByMiembroId(Long miembroId);
}
