package com.viktor.backend.repository;

import com.viktor.backend.entity.Mark;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer> {

}