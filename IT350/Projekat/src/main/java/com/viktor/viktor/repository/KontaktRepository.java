package com.viktor.viktor.repository;

import com.viktor.viktor.entity.Kontakt;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface KontaktRepository extends JpaRepository<Kontakt, Integer> {

}