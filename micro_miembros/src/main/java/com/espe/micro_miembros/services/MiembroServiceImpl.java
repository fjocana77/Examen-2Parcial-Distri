package com.espe.micro_miembros.services;

import com.espe.micro_miembros.models.entities.Miembros;
import com.espe.micro_miembros.repositories.MiembroRepository;
import com.espe.micro_miembros.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MiembroServiceImpl implements MiembroService {

    @Autowired
    private MiembroRepository repository;

    @Override
    public Miembros save(Miembros miembro) {
        return repository.save(miembro);
    }

    @Override
    public List<Miembros> findAll() {
        return repository.findAll();
    }

    @Override
    public Miembros findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Miembro no encontrado"));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
