package com.espe.micro_bandas.controllers;

import com.espe.micro_bandas.exception.ResourceNotFoundException;
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
    public ResponseEntity<?> assignMiembroToBanda(@PathVariable Long bandaId, @PathVariable Long miembroId) {
        try {
            BandasMiembros asignacion = service.assignMiembroToBanda(bandaId, miembroId);
            return ResponseEntity.ok(asignacion);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(errorResponse(e.getMessage()));
        }
    }

    // Obtener miembros por banda
    @GetMapping("/banda/{bandaId}/miembros")
    public ResponseEntity<?> getMiembrosByBanda(@PathVariable Long bandaId) {
        try {
            List<BandasMiembros> miembros = service.getMiembrosByBanda(bandaId);
            return ResponseEntity.ok(miembros);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(errorResponse(e.getMessage()));
        }
    }

    // Obtener bandas por miembro
    @GetMapping("/miembro/{miembroId}/bandas")
    public ResponseEntity<?> getBandasByMiembro(@PathVariable Long miembroId) {
        try {
            List<BandasMiembros> bandas = service.getBandasByMiembro(miembroId);
            return ResponseEntity.ok(bandas);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(errorResponse(e.getMessage()));
        }
    }

    // Eliminar miembro de una banda
    @DeleteMapping("/{bandaId}/miembros/{miembroId}")
    public ResponseEntity<?> removeMiembroFromBanda(@PathVariable Long bandaId, @PathVariable Long miembroId) {
        try {
            service.removeMiembroFromBanda(bandaId, miembroId);
            return ResponseEntity.ok().body(errorResponse("Miembro eliminado de la banda exitosamente"));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(errorResponse(e.getMessage()));
        }
    }

    // Método para estructurar las respuestas de error
    private static java.util.Map<String, String> errorResponse(String message) {
        return java.util.Collections.singletonMap("mensaje", message);
    }
}
