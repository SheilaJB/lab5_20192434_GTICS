package org.example.lab05_20192434.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "canciones")
public class Canciones {

    @Id
    @Column(name = "idCanciones")
    private int idCanciones;

    @Column(name = "nombreCancion")
    private String nombreCancion;

    @Column(name = "tipoCancion")
    private String tipoCancion;
    @ManyToOne
    @JoinColumn(name = "idRecurso")
    private Recursos recurso;
}
