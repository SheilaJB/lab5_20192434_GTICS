package org.example.lab05_20192434.Repository;

import org.example.lab05_20192434.Entity.Sedes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepository extends JpaRepository<Sedes, Integer> {
}
