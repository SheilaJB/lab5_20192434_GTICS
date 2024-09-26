package org.example.lab05_20192434.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "riesgos")
public class Riesgos {

    @Id
    @Column(name = "idRiesgos")
    private int idRiesgos;

    @Column(name = "Bajo")
    private String Bajo;

    @Column(name = "Moderado")
    private String Moderado;

    @Column(name = "Alto")
    private String Alto;

    @Column(name = "Muy Alto")
    private String MuyAlto;


}
