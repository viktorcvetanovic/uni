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
@RequestMapping("/osobas")
@RequiredArgsConstructor
public class OsobaController {
	private final OsobaService osobaService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllOsobas")
	public ResponseEntity<List<Osoba>> getAllOsobas(@RequestParam(name = "q", required = false) Specification<Osoba> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(osobaService.findAll(specification, sort));
	}

	@GetMapping("/{osobaId}")
	@ApiOperation(value = "", nickname = "getOsobaById")
	public ResponseEntity<Osoba> getOsobaById(@PathVariable Integer osobaId) {
		return ResponseEntity.ok(osobaService.findById(osobaId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveOsoba")
	public ResponseEntity<Osoba> saveOsoba(@RequestBody Osoba osoba) {
		return ResponseEntity.status(HttpStatus.CREATED).body(osobaService.save(osoba));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateOsoba")
	public ResponseEntity<Osoba> updateOsoba(@RequestBody Osoba osoba) {
		return ResponseEntity.ok(osobaService.update(osoba));
	}

	@DeleteMapping("/{osobaId}")
	@ApiOperation(value = "", nickname = "deleteOsobaById")
	public void deleteOsobaById(@PathVariable Integer osobaId) {
		osobaService.deleteById(osobaId);
	}

}

