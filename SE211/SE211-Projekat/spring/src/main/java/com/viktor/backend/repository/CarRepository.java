package com.viktor.backend.repository;

import com.viktor.backend.entity.Car;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}