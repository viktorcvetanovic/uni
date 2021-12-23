package com.viktor.repository;

import com.viktor.entity.Intervju;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervjuRepository extends JpaRepository<Intervju, Integer>, JpaSpecificationExecutor<Intervju> {

}