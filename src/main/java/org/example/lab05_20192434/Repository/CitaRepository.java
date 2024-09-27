package org.example.lab05_20192434.Repository;

import org.example.lab05_20192434.Entity.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Citas, Integer> {
}
