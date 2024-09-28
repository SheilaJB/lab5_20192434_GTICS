package org.example.lab05_20192434.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "foro")
public class Foro {

    @Id
    @Column(name = "idForo")
    private int idForo;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "nombrePersona")
    private String nombrePersona;
    @Column(name = "edad")
    private int edad;
}
