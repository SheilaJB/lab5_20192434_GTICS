package org.example.lab05_20192434.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "citas")
public class Citas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCitas")
    private int idCitas;

    @Column(name = "motivoConsulta")
    private String motivoConsulta;

    @Column(name = "precio")
    private int precio;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Pacientes paciente;

    @ManyToOne
    @JoinColumn(name = "idArea")
    private Areas area;

    @ManyToOne
    @JoinColumn(name = "idProfesional")
    private Profesionales profesionales;

    @ManyToOne
    @JoinColumn(name = "idSede")
    private Sedes sedes;

    @ManyToOne
    @JoinColumn(name = "idFechaConsulta")
    private Fechas fecha;

    @ManyToOne
    @JoinColumn(name = "idRiesgo")
    private Riesgos riesgos;

    public Object getSede() {
        return sedes;
    }
}
