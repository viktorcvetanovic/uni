package com.viktor.viktor.controller;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/osobas")
@RequiredArgsConstructor
public class OsobaController {
	private final OsobaService osobaService;

	@GetMapping
	public ResponseEntity<List<Osoba>> getAllOsobas() {
		return ResponseEntity.ok(osobaService.findAll());
	}

	@GetMapping("/{osobaId}")
	public ResponseEntity<Osoba> getOsobaById(@PathVariable Integer osobaId) {
		return ResponseEntity.ok(osobaService.findById(osobaId));
	}

	@PostMapping
	public ResponseEntity<Osoba> saveOsoba(@RequestBody Osoba osoba) {
		return ResponseEntity.status(HttpStatus.CREATED).body(osobaService.save(osoba));
	}

	@PutMapping
	public ResponseEntity<Osoba> updateOsoba(@RequestBody Osoba osoba) {
		return ResponseEntity.ok(osobaService.update(osoba));
	}

	@DeleteMapping("/{osobaId}")
	public void deleteOsobaById(@PathVariable Integer osobaId) {
		osobaService.deleteById(osobaId);
	}

}

