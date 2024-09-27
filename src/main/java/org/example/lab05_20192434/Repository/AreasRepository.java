package org.example.lab05_20192434.Repository;

import org.example.lab05_20192434.Entity.Areas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.geom.Area;

@Repository
public interface AreasRepository extends JpaRepository<Areas, Integer> {
}
