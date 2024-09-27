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
    private int idPacientes;

    @Column(name = "nombrePaciente")
    private String nombrePaciente;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "Edad")
    private int edad;

    @Column(name = "Pacientescol")
    private String pacientescol;

    @OneToMany
    @JoinColumn(name = "Citas")
    private List<Citas> citas;

}
