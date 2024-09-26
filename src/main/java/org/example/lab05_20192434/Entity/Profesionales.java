package org.example.lab05_20192434.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.geom.Area;
@Data
@Entity
@Table(name = "profesionales")
public class Profesionales {

    @Id
    @Column(name = "idProfesionales")
    private int idProfesionales;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "descripcionProfesional")
    private String descripcionProfesional;

    @ManyToOne
    @JoinColumn(name = "idArea")
    private Areas idArea;

    @ManyToOne
    @JoinColumn(name = "idSede")
    private Sedes idSede;







}
