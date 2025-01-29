package com.espe.micro_bandas.controllers;

import com.espe.micro_bandas.models.entities.BandasMiembros;
import com.espe.micro_bandas.services.BandasMiembrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bandas-miembros")
public class BandasMiembrosController {

    @Autowired
    private BandasMiembrosService service;

    // Asignar miembro a una banda
    @PostMapping("/{bandaId}/miembros/{miembroId}")
    public ResponseEntity<BandasMiembros> assignMiembroToBanda(@PathVariable Long bandaId, @PathVariable Long miembroId) {
        return ResponseEntity.ok(service.assignMiembroToBanda(bandaId, miembroId));
    }

    // Obtener miembros por banda
    @GetMapping("/banda/{bandaId}/miembros")
    public List<BandasMiembros> getMiembrosByBanda(@PathVariable Long bandaId) {
        return service.getMiembrosByBanda(bandaId);
    }

    // Obtener bandas por miembro
    @GetMapping("/miembro/{miembroId}/bandas")
    public List<BandasMiembros> getBandasByMiembro(@PathVariable Long miembroId) {
        return service.getBandasByMiembro(miembroId);
    }

    // Eliminar miembro de una banda
    @DeleteMapping("/{bandaId}/miembros/{miembroId}")
    public ResponseEntity<Void> removeMiembroFromBanda(@PathVariable Long bandaId, @PathVariable Long miembroId) {
        service.removeMiembroFromBanda(bandaId, miembroId);
        return ResponseEntity.noContent().build();
    }
}
