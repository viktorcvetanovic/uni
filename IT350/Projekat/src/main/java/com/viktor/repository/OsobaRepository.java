package com.viktor.repository;

import com.viktor.entity.Osoba;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface OsobaRepository extends JpaRepository<Osoba, Integer>, JpaSpecificationExecutor<Osoba> {

}