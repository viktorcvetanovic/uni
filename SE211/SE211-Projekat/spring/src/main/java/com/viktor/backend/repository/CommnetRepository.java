package com.viktor.backend.repository;

import com.viktor.backend.entity.Commnet;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CommnetRepository extends JpaRepository<Commnet, Integer> {

}