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
@RequestMapping("/kontakts")
@RequiredArgsConstructor
public class KontaktController {
	private final KontaktService kontaktService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllKontakts")
	public ResponseEntity<List<Kontakt>> getAllKontakts(@RequestParam(name = "q", required = false) Specification<Kontakt> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(kontaktService.findAll(specification, sort));
	}

	@GetMapping("/{kontaktId}")
	@ApiOperation(value = "", nickname = "getKontaktById")
	public ResponseEntity<Kontakt> getKontaktById(@PathVariable Integer kontaktId) {
		return ResponseEntity.ok(kontaktService.findById(kontaktId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveKontakt")
	public ResponseEntity<Kontakt> saveKontakt(@RequestBody Kontakt kontakt) {
		return ResponseEntity.status(HttpStatus.CREATED).body(kontaktService.save(kontakt));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateKontakt")
	public ResponseEntity<Kontakt> updateKontakt(@RequestBody Kontakt kontakt) {
		return ResponseEntity.ok(kontaktService.update(kontakt));
	}

	@DeleteMapping("/{kontaktId}")
	@ApiOperation(value = "", nickname = "deleteKontaktById")
	public void deleteKontaktById(@PathVariable Integer kontaktId) {
		kontaktService.deleteById(kontaktId);
	}

}

