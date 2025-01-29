package com.espe.micro_miembros.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
public class Miembros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")  // No puede estar vacío
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")  // Longitud mínima y máxima
    private String nombre;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @NotBlank(message = "El género es obligatorio")  // No puede estar vacío
    @Pattern(regexp = "^(Masculino|Femenino|Otro)$", message = "Género debe ser 'Masculino', 'Femenino' o 'Otro'") // Valida valores específicos
    private String genero;

    @Size(min = 3, max = 50, message = "El rol debe tener entre 3 y 50 caracteres")
    @NotBlank(message = "El rol no debe estar vacío")
    private String rol;


    @PrePersist
    public void prePersist() {
        if (this.fechaCreacion == null) { // Solo asigna la fecha si es null
            this.fechaCreacion = LocalDateTime.now();
        }
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        // No permitimos actualizar la fecha de creación
        throw new UnsupportedOperationException("La fecha de creación no se puede actualizar");
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
