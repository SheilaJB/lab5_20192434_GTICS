package org.example.lab05_20192434.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "frases")
public class Frases {

    @Id
    @Column(name = "idFrases")
    private String idFrases;

    @Column(name = "frase")
    private String frase;
    @ManyToOne
    @JoinColumn(name = "idRecurso")
    private Recursos recurso;

}
