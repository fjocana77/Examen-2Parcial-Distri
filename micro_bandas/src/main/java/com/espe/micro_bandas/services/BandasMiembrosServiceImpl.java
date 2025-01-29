package com.espe.micro_bandas.services;

import com.espe.micro_bandas.models.entities.Banda;
import com.espe.micro_bandas.models.entities.BandasMiembros;
import com.espe.micro_bandas.repositories.BandaRepository;
import com.espe.micro_bandas.repositories.BandasMiembrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BandasMiembrosServiceImpl implements BandasMiembrosService {

    @Autowired
    private BandasMiembrosRepository repository;

    @Autowired
    private BandaRepository bandaRepository;

    @Override
    public BandasMiembros assignMiembroToBanda(Long bandaId, Long miembroId) {
        Banda banda = bandaRepository.findById(bandaId)
                .orElseThrow(() -> new RuntimeException("Banda no encontrada"));

        BandasMiembros relacion = new BandasMiembros();
        relacion.setBanda(banda);
        relacion.setMiembroId(miembroId);

        return repository.save(relacion);
    }

    @Override
    public List<BandasMiembros> getMiembrosByBanda(Long bandaId) {
        return repository.findByBandaId(bandaId);
    }

    @Override
    public List<BandasMiembros> getBandasByMiembro(Long miembroId) {
        return repository.findByMiembroId(miembroId);
    }

    @Override
    public void removeMiembroFromBanda(Long bandaId, Long miembroId) {
        List<BandasMiembros> relaciones = repository.findByBandaId(bandaId);
        relaciones.stream()
                .filter(relacion -> relacion.getMiembroId().equals(miembroId))
                .findFirst()
                .ifPresent(repository::delete);
    }
}