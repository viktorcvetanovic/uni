package com.viktor.viktor.controller;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kompanijas")
@RequiredArgsConstructor
public class KompanijaController {
	private final KompanijaService kompanijaService;

	@GetMapping
	public ResponseEntity<List<Kompanija>> getAllKompanijas() {
		return ResponseEntity.ok(kompanijaService.findAll());
	}

	@GetMapping("/{osobaId}/{vlasnikId}/{kompanijaId}")
	public ResponseEntity<Kompanija> getKompanijaById(@PathVariable Integer osobaId, @PathVariable Vlasnik vlasnikId, @PathVariable Integer kompanijaId) {
		return ResponseEntity.ok(kompanijaService.findById(osobaId, vlasnikId, kompanijaId));
	}

	@PostMapping
	public ResponseEntity<Kompanija> saveKompanija(@RequestBody Kompanija kompanija) {
		return ResponseEntity.status(HttpStatus.CREATED).body(kompanijaService.save(kompanija));
	}

	@PutMapping
	public ResponseEntity<Kompanija> updateKompanija(@RequestBody Kompanija kompanija) {
		return ResponseEntity.ok(kompanijaService.update(kompanija));
	}

	@DeleteMapping("/{osobaId}/{vlasnikId}/{kompanijaId}")
	public void deleteKompanijaById(@PathVariable Integer osobaId, @PathVariable Vlasnik vlasnikId, @PathVariable Integer kompanijaId) {
		kompanijaService.deleteById(osobaId, vlasnikId, kompanijaId);
	}

}

