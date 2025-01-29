package com.espe.micro_bandas.services;

import com.espe.micro_bandas.models.entities.BandasMiembros;

import java.util.List;

public interface BandasMiembrosService {
    BandasMiembros assignMiembroToBanda(Long bandaId, Long miembroId);
    List<BandasMiembros> getMiembrosByBanda(Long bandaId);
    List<BandasMiembros> getBandasByMiembro(Long miembroId);
    void removeMiembroFromBanda(Long bandaId, Long miembroId);
}
