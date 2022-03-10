package com.viktor.viktor.controller;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kontakts")
@RequiredArgsConstructor
public class KontaktController {
	private final KontaktService kontaktService;

	@GetMapping
	public ResponseEntity<List<Kontakt>> getAllKontakts() {
		return ResponseEntity.ok(kontaktService.findAll());
	}

	@GetMapping("/{kontaktId}")
	public ResponseEntity<Kontakt> getKontaktById(@PathVariable Integer kontaktId) {
		return ResponseEntity.ok(kontaktService.findById(kontaktId));
	}

	@PostMapping
	public ResponseEntity<Kontakt> saveKontakt(@RequestBody Kontakt kontakt) {
		return ResponseEntity.status(HttpStatus.CREATED).body(kontaktService.save(kontakt));
	}

	@PutMapping
	public ResponseEntity<Kontakt> updateKontakt(@RequestBody Kontakt kontakt) {
		return ResponseEntity.ok(kontaktService.update(kontakt));
	}

	@DeleteMapping("/{kontaktId}")
	public void deleteKontaktById(@PathVariable Integer kontaktId) {
		kontaktService.deleteById(kontaktId);
	}

}

