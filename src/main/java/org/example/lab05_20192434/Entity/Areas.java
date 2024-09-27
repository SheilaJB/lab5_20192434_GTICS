package org.example.lab05_20192434.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Areas")
public class Areas {

    @Id
    @Column(name = "idAreas",nullable = false)
    private Integer idAreas;

    @Column(name = "nombreArea",nullable = false)
    private String nombreArea;

}
