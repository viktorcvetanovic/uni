package com.viktor.viktor.repository;

import com.viktor.viktor.entity.KandidatOglas;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface KandidatOglasRepository extends JpaRepository<KandidatOglas, Integer> {

}