package com.espe.micro_bandas.services;

import com.espe.micro_bandas.models.entities.Banda;

import java.util.List;

public interface BandaService {
    Banda save(Banda banda);
    List<Banda> findAll();
    Banda findById(Long id);
    void deleteById(Long id);
}
