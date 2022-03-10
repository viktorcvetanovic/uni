package com.viktor.viktor.controller;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kandidat-oglases")
@RequiredArgsConstructor
public class KandidatOglasController {
	private final KandidatOglasService kandidatOglasService;

	@GetMapping
	public ResponseEntity<List<KandidatOglas>> getAllKandidatOglases() {
		return ResponseEntity.ok(kandidatOglasService.findAll());
	}

	@GetMapping("/{profilOglasId}")
	public ResponseEntity<KandidatOglas> getKandidatOglasById(@PathVariable Integer profilOglasId) {
		return ResponseEntity.ok(kandidatOglasService.findById(profilOglasId));
	}

	@PostMapping
	public ResponseEntity<KandidatOglas> saveKandidatOglas(@RequestBody KandidatOglas kandidatOglas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(kandidatOglasService.save(kandidatOglas));
	}

	@PutMapping
	public ResponseEntity<KandidatOglas> updateKandidatOglas(@RequestBody KandidatOglas kandidatOglas) {
		return ResponseEntity.ok(kandidatOglasService.update(kandidatOglas));
	}

	@DeleteMapping("/{profilOglasId}")
	public void deleteKandidatOglasById(@PathVariable Integer profilOglasId) {
		kandidatOglasService.deleteById(profilOglasId);
	}

}

