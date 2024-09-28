package org.example.lab05_20192434.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.geom.Area;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "Profesionales")
public class Profesionales {

    @Id
    @Column(name = "idProfesionales",nullable = false)
    private Integer idProfesionales;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "imagen",nullable = false)
    private String imagen;

    @Column(name = "descripcionProfesional",nullable = false)
    private String descripcionProfesional;

    @ManyToOne
    @JoinColumn(name = "idArea",nullable = false)
    private Areas area;

    @ManyToOne
    @JoinColumn(name = "idSede",nullable = false)
    private Sedes sedes;



    public Collection<Object> getFechasDisponibles() {

        return List.of();
    }

    public Object getSede() {
        return sedes;
    }
}
