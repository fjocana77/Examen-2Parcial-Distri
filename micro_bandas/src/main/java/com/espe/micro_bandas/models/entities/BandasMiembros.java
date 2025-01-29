package com.espe.micro_bandas.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class BandasMiembros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Validar que la banda no sea nula
    @ManyToOne
    @JoinColumn(name = "banda_id", nullable = false)
    @NotNull(message = "La banda es obligatoria")
    private Banda banda;

    // Validar que el miembroId no sea nulo
    @Column(nullable = false)
    @NotNull(message = "El ID del miembro es obligatorio")
    private Long miembroId; // ID del miembro, obtenido del microservicio de miembros

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public Long getMiembroId() {
        return miembroId;
    }

    public void setMiembroId(Long miembroId) {
        this.miembroId = miembroId;
    }
}
