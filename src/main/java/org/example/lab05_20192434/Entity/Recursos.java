package org.example.lab05_20192434.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "recursos")
public class Recursos {

    @Id
    @Column(name = "idRecursos")
    private int idRecursos;

}
