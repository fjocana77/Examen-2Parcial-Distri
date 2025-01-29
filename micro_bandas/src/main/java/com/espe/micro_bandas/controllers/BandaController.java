package com.espe.micro_bandas.controllers;

import com.espe.micro_bandas.models.entities.Banda;
import com.espe.micro_bandas.services.BandaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bandas")
public class BandaController {

    @Autowired
    private BandaService service;

    // Crear nueva banda
    @PostMapping
    public ResponseEntity<Banda> create(@Valid @RequestBody Banda banda) {
        Banda savedBanda = service.save(banda);
        return ResponseEntity.ok(savedBanda);
    }

    // Obtener todas las bandas
    @GetMapping
    public List<Banda> findAll() {
        return service.findAll();
    }

    // Obtener banda por ID
    @GetMapping("/{id}")
    public ResponseEntity<Banda> findById(@PathVariable Long id) {
        Banda banda = service.findById(id);
        return banda != null ? ResponseEntity.ok(banda) : ResponseEntity.notFound().build();
    }

    // Eliminar banda por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar banda por ID
    @PutMapping("/{id}")
    public ResponseEntity<Banda> update(@PathVariable Long id, @Valid @RequestBody Banda banda) {
        Banda existingBanda = service.findById(id);
        if (existingBanda != null) {
            banda.setId(id);  // Asigna el ID de la banda existente para la actualización
            Banda updatedBanda = service.save(banda);
            return ResponseEntity.ok(updatedBanda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
