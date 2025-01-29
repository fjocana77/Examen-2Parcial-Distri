package com.espe.micro_bandas.services;

import com.espe.micro_bandas.models.entities.Banda;
import com.espe.micro_bandas.repositories.BandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BandaServiceImpl implements BandaService {

    @Autowired
    private BandaRepository repository;

    @Override
    public Banda save(Banda banda) {
        return repository.save(banda);
    }

    @Override
    public List<Banda> findAll() {
        return repository.findAll();
    }

    @Override
    public Banda findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
