package com.viktor.backend.service;

import com.viktor.backend.entity.*;
import java.util.Collection;
import java.util.List;

public interface CarService {

	List<Car> findAll();

	Car save(Car car);

	Car update(Car car);

	Car findById(Integer carId);

	void deleteById(Integer carId);

}