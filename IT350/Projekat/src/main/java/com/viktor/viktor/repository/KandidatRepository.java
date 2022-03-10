package com.viktor.viktor.repository;

import com.viktor.viktor.entity.Kandidat;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface KandidatRepository extends JpaRepository<Kandidat, Integer> {

}