package org.example.lab05_20192434.Repository;

import org.example.lab05_20192434.Entity.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Citas, Integer> {

    //Pacientes por cada tipo de Riesgo
    @Query("SELECT r.tipo AS tipoRiesgo, COUNT(DISTINCT c.paciente) AS numeroPacientes " +
            "FROM Citas c " +
            "JOIN c.riesgos r " +
            "GROUP BY r.tipo")
    List<Object[]> obtenerNumeroPacientesPorRiesgo();

    // Número de citas por sede
    @Query("SELECT s.nombreSede AS sede, COUNT(c.idCitas) AS totalCitas " +
            "FROM Citas c " +
            "JOIN c.sedes s " +
            "GROUP BY s.nombreSede")
    List<Object[]> obtenerCitasPorSede();

    // Número de citas por especialidad (área)
    @Query("SELECT a.nombreArea AS especialidad, COUNT(c.idCitas) AS totalCitas " +
            "FROM Citas c " +
            "JOIN c.area a " +
            "GROUP BY a.nombreArea")
    List<Object[]> obtenerCitasPorEspecialidad();

    // Número de citas por profesional
    @Query("SELECT p.nombre AS profesional, COUNT(c.idCitas) AS totalCitas " +
            "FROM Citas c " +
            "JOIN c.profesionales p " +
            "GROUP BY p.nombre")
    List<Object[]> obtenerCitasPorProfesional();



}
