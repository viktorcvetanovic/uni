package com.viktor.viktor.controller;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vlasniks")
@RequiredArgsConstructor
public class VlasnikController {
	private final VlasnikService vlasnikService;

	@GetMapping
	public ResponseEntity<List<Vlasnik>> getAllVlasniks() {
		return ResponseEntity.ok(vlasnikService.findAll());
	}

	@GetMapping("/{vlasnikId}")
	public ResponseEntity<Vlasnik> getVlasnikById(@PathVariable Integer vlasnikId) {
		return ResponseEntity.ok(vlasnikService.findById(vlasnikId));
	}

	@PostMapping
	public ResponseEntity<Vlasnik> saveVlasnik(@RequestBody Vlasnik vlasnik) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vlasnikService.save(vlasnik));
	}

	@PutMapping
	public ResponseEntity<Vlasnik> updateVlasnik(@RequestBody Vlasnik vlasnik) {
		return ResponseEntity.ok(vlasnikService.update(vlasnik));
	}

	@DeleteMapping("/{vlasnikId}")
	public void deleteVlasnikById(@PathVariable Integer vlasnikId) {
		vlasnikService.deleteById(vlasnikId);
	}

}

