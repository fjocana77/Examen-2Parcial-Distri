package com.espe.micro_miembros.services;

import com.espe.micro_miembros.models.entities.Miembros;

import java.util.List;

public interface MiembroService {
    Miembros save(Miembros miembro);
    List<Miembros> findAll();
    Miembros findById(Long id);
    void deleteById(Long id);
}
