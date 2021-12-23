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
@RequestMapping("/kompanijas")
@RequiredArgsConstructor
public class KompanijaController {
	private final KompanijaService kompanijaService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllKompanijas")
	public ResponseEntity<List<Kompanija>> getAllKompanijas(@RequestParam(name = "q", required = false) Specification<Kompanija> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(kompanijaService.findAll(specification, sort));
	}

	@GetMapping("/{osobaId}/{vlasnikId}/{kompanijaId}")
	@ApiOperation(value = "", nickname = "getKompanijaById")
	public ResponseEntity<Kompanija> getKompanijaById(@PathVariable Vlasnik osobaId, @PathVariable Vlasnik vlasnikId, @PathVariable Integer kompanijaId) {
		return ResponseEntity.ok(kompanijaService.findById(osobaId, vlasnikId, kompanijaId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveKompanija")
	public ResponseEntity<Kompanija> saveKompanija(@RequestBody Kompanija kompanija) {
		return ResponseEntity.status(HttpStatus.CREATED).body(kompanijaService.save(kompanija));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateKompanija")
	public ResponseEntity<Kompanija> updateKompanija(@RequestBody Kompanija kompanija) {
		return ResponseEntity.ok(kompanijaService.update(kompanija));
	}

	@DeleteMapping("/{osobaId}/{vlasnikId}/{kompanijaId}")
	@ApiOperation(value = "", nickname = "deleteKompanijaById")
	public void deleteKompanijaById(@PathVariable Vlasnik osobaId, @PathVariable Vlasnik vlasnikId, @PathVariable Integer kompanijaId) {
		kompanijaService.deleteById(osobaId, vlasnikId, kompanijaId);
	}

}

