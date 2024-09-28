package org.example.lab05_20192434.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Pacientes")
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPacientes", nullable = false)
    private Integer idPacientes;

    @Column(name = "nombrePaciente")
    private String nombrePaciente;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "Edad")
    private int edad;

    @OneToMany
    @JoinColumn(name = "idCitas")
    private List<Citas> citas;

}
