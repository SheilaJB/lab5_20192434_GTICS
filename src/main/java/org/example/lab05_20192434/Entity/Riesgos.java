package org.example.lab05_20192434.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Riesgos")
public class Riesgos {

    @Id
    @Column(name = "idRiesgos",nullable = false)
    private int idRiesgos;

    @Column(name = "tipo",nullable = false)
    private String tipo;



}
