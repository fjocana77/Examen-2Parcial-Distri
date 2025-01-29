package com.espe.micro_miembros.controllers;

import com.espe.micro_miembros.models.entities.Miembros;
import com.espe.micro_miembros.services.MiembroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/miembros")
public class MiembroController {

    @Autowired
    private MiembroService service;

    @PostMapping
    public ResponseEntity<Miembros> create(@Valid @RequestBody Miembros miembro) {
        return ResponseEntity.ok(service.save(miembro));
    }

    @GetMapping
    public List<Miembros> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Miembros> findById(@PathVariable Long id) {
        Miembros miembro = service.findById(id);
        return miembro != null ? ResponseEntity.ok(miembro) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Miembros> update(@PathVariable Long id, @Valid @RequestBody Miembros miembro) {
        // Buscar el miembro existente
        Miembros existingMiembro = service.findById(id);

        if (existingMiembro == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar los campos: nombre, genero, rol
        existingMiembro.setNombre(miembro.getNombre());
        existingMiembro.setGenero(miembro.getGenero());  // Actualiza el campo genero
        existingMiembro.setRol(miembro.getRol());        // Actualiza el campo rol

        // La fecha de creación se mantiene intacta, no la actualizamos
        Miembros updatedMiembro = service.save(existingMiembro);

        return ResponseEntity.ok(updatedMiembro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

