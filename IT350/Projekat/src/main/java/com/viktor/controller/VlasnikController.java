package com.viktor.controller;

import com.viktor.entity.*;
import com.viktor.service.*;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vlasniks")
@RequiredArgsConstructor
public class VlasnikController {
	private final VlasnikService vlasnikService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllVlasniks")
	public ResponseEntity<List<Vlasnik>> getAllVlasniks(@RequestParam(name = "q", required = false) Specification<Vlasnik> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(vlasnikService.findAll(specification, sort));
	}

	@GetMapping("/{osobaId}/{vlasnikId}")
	@ApiOperation(value = "", nickname = "getVlasnikById")
	public ResponseEntity<Vlasnik> getVlasnikById(@PathVariable Osoba osobaId, @PathVariable Integer vlasnikId) {
		return ResponseEntity.ok(vlasnikService.findById(osobaId, vlasnikId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveVlasnik")
	public ResponseEntity<Vlasnik> saveVlasnik(@RequestBody Vlasnik vlasnik) {
		return ResponseEntity.status(HttpStatus.CREATED).body(vlasnikService.save(vlasnik));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateVlasnik")
	public ResponseEntity<Vlasnik> updateVlasnik(@RequestBody Vlasnik vlasnik) {
		return ResponseEntity.ok(vlasnikService.update(vlasnik));
	}

	@DeleteMapping("/{osobaId}/{vlasnikId}")
	@ApiOperation(value = "", nickname = "deleteVlasnikById")
	public void deleteVlasnikById(@PathVariable Osoba osobaId, @PathVariable Integer vlasnikId) {
		vlasnikService.deleteById(osobaId, vlasnikId);
	}

}

