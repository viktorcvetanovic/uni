package com.viktor.viktor.controller;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oglases")
@RequiredArgsConstructor
public class OglasController {
	private final OglasService oglasService;

	@GetMapping
	public ResponseEntity<List<Oglas>> getAllOglases() {
		return ResponseEntity.ok(oglasService.findAll());
	}

	@GetMapping("/{oglasId}")
	public ResponseEntity<Oglas> getOglasById(@PathVariable Integer oglasId) {
		return ResponseEntity.ok(oglasService.findById(oglasId));
	}

	@PostMapping
	public ResponseEntity<Oglas> saveOglas(@RequestBody Oglas oglas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(oglasService.save(oglas));
	}

	@PutMapping
	public ResponseEntity<Oglas> updateOglas(@RequestBody Oglas oglas) {
		return ResponseEntity.ok(oglasService.update(oglas));
	}

	@DeleteMapping("/{oglasId}")
	public void deleteOglasById(@PathVariable Integer oglasId) {
		oglasService.deleteById(oglasId);
	}

}

