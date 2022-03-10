package com.viktor.viktor.repository;

import com.viktor.viktor.entity.Vlasnik;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface VlasnikRepository extends JpaRepository<Vlasnik, Integer> {

}