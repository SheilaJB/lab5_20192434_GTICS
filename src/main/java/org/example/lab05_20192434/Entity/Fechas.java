package org.example.lab05_20192434.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Fechas")
public class Fechas {

    @Id
    @Column(name = "idFechas")
    private int idFechas;

    @Column(name = "fechaDisponibilidad")
    private String fechaDisponibilidad;

    @ManyToOne
    @JoinColumn(name = "idProfesional")
    private Profesionales profesionales;

}
