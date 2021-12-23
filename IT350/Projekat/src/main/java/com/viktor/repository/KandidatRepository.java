package com.viktor.repository;

import com.viktor.entity.Kandidat;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface KandidatRepository extends JpaRepository<Kandidat, Kandidat.KandidatId>, JpaSpecificationExecutor<Kandidat> {

}