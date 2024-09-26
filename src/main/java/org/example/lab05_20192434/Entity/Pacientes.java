package org.example.lab05_20192434.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pacientes")
public class Pacientes {

    @Id
    @Column(name = "idPacientes")
    private int idPacientes;

    @Column(name = "nombrePaciente")
    private String nombrePaciente;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "Edad")
    private int edad;

    @Column(name = "Pacientescol")
    private String pacientescol;

}
