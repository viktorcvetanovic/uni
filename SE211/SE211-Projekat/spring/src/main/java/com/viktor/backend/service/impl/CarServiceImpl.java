package com.viktor.backend.service.impl;

import com.viktor.backend.entity.*;
import com.viktor.backend.repository.CarRepository;
import com.viktor.backend.service.CarService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
	private final CarRepository carRepository;

	@Override
	public List<Car> findAll() {
		return carRepository.findAll();
	}

	@Override
	public Car findById(Integer carId) {
		return carRepository.findById(carId)
				.orElseThrow(() -> new NoSuchElementException("CarService.notFound"));
	}

	@Override
	public Car save(Car car) {
		return carRepository.save(car);
	}

	@Override
	public Car update(Car car) {
		return carRepository.save(car);
	}

	@Override
	public void deleteById(Integer carId) {
		carRepository.deleteById(carId);
	}


}