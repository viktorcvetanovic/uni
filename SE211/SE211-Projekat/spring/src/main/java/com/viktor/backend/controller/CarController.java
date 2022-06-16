package com.viktor.backend.controller;

import com.viktor.backend.entity.*;
import com.viktor.backend.service.*;
import java.util.List;

import com.viktor.backend.util.scraper.CarScraper;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
	private final CarService carService;
	private final CarScraper carScraper;

	@GetMapping
	public ResponseEntity<List<Car>> getAllCars() {
		return ResponseEntity.ok(carService.findAll());
	}

	@GetMapping("/{carId}")
	public ResponseEntity<Car> getCarById(@PathVariable Integer carId) {
		return ResponseEntity.ok(carService.findById(carId));
	}

	@PostMapping
	public ResponseEntity<Car> saveCar(@RequestBody Car car) {
		return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(car));
	}

	@PutMapping
	public ResponseEntity<Car> updateCar(@RequestBody Car car) {
		return ResponseEntity.ok(carService.update(car));
	}

	@DeleteMapping("/{carId}")
	public void deleteCarById(@PathVariable Integer carId) {
		carService.deleteById(carId);
	}

	@PostMapping("/scrap")
	public void scrap(){
		carScraper.writeToDatabase();
	}

}

