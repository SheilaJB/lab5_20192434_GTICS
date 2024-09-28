package org.example.lab05_20192434.Repository;

import org.example.lab05_20192434.Entity.Frases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrasesRepository extends JpaRepository<Frases, Integer> {

    @Query("SELECT f.frase FROM Frases f")
    List<String> findByFrases();
}
