package org.example.lab05_20192434.Repository;

import org.example.lab05_20192434.Entity.Canciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancionesRepository extends JpaRepository<Canciones, Integer> {

    @Query("SELECT c.nombreCancion FROM Canciones c WHERE c.tipoCancion = '0'")
    List<String> findByTipoCancion0();

    @Query("SELECT c.nombreCancion FROM Canciones c WHERE c.tipoCancion = '1'")
    List<String> findByTipoCancion1();

    @Query("SELECT c.nombreCancion FROM Canciones c WHERE c.tipoCancion = '2'")
    List<String> findByTipoCancion2();
}
