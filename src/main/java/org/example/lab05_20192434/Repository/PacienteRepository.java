package org.example.lab05_20192434.Repository;

import org.example.lab05_20192434.Entity.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Pacientes, Integer> {
}
