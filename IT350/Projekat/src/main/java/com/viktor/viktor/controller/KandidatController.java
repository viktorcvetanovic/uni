package com.viktor.viktor.controller;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kandidats")
@RequiredArgsConstructor
public class KandidatController {
	private final KandidatService kandidatService;

	@GetMapping
	public ResponseEntity<List<Kandidat>> getAllKandidats() {
		return ResponseEntity.ok(kandidatService.findAll());
	}

	@GetMapping("/{profilId}")
	public ResponseEntity<Kandidat> getKandidatById(@PathVariable Integer profilId) {
		return ResponseEntity.ok(kandidatService.findById(profilId));
	}

	@PostMapping
	public ResponseEntity<Kandidat> saveKandidat(@RequestBody Kandidat kandidat) {
		return ResponseEntity.status(HttpStatus.CREATED).body(kandidatService.save(kandidat));
	}

	@PutMapping
	public ResponseEntity<Kandidat> updateKandidat(@RequestBody Kandidat kandidat) {
		return ResponseEntity.ok(kandidatService.update(kandidat));
	}

	@DeleteMapping("/{profilId}")
	public void deleteKandidatById(@PathVariable Integer profilId) {
		kandidatService.deleteById(profilId);
	}

}

