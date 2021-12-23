package com.viktor.repository;

import com.viktor.entity.Oglas;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface OglasRepository extends JpaRepository<Oglas, Integer>, JpaSpecificationExecutor<Oglas> {

}