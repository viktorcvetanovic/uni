package com.viktor.viktor.controller;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/intervjus")
@RequiredArgsConstructor
public class IntervjuController {
	private final IntervjuService intervjuService;

	@GetMapping
	public ResponseEntity<List<Intervju>> getAllIntervjus() {
		return ResponseEntity.ok(intervjuService.findAll());
	}

	@GetMapping("/{intervjuId}")
	public ResponseEntity<Intervju> getIntervjuById(@PathVariable Integer intervjuId) {
		return ResponseEntity.ok(intervjuService.findById(intervjuId));
	}

	@PostMapping
	public ResponseEntity<Intervju> saveIntervju(@RequestBody Intervju intervju) {
		return ResponseEntity.status(HttpStatus.CREATED).body(intervjuService.save(intervju));
	}

	@PutMapping
	public ResponseEntity<Intervju> updateIntervju(@RequestBody Intervju intervju) {
		return ResponseEntity.ok(intervjuService.update(intervju));
	}

	@DeleteMapping("/{intervjuId}")
	public void deleteIntervjuById(@PathVariable Integer intervjuId) {
		intervjuService.deleteById(intervjuId);
	}

}

