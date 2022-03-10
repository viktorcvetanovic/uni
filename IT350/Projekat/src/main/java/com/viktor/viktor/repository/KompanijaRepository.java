package com.viktor.viktor.repository;

import com.viktor.viktor.entity.Kompanija;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface KompanijaRepository extends JpaRepository<Kompanija, Integer> {

}