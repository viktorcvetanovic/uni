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
@RequestMapping("/kandidats")
@RequiredArgsConstructor
public class KandidatController {
	private final KandidatService kandidatService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllKandidats")
	public ResponseEntity<List<Kandidat>> getAllKandidats(@RequestParam(name = "q", required = false) Specification<Kandidat> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(kandidatService.findAll(specification, sort));
	}

	@GetMapping("/{osobaId}/{profilId}")
	@ApiOperation(value = "", nickname = "getKandidatById")
	public ResponseEntity<Kandidat> getKandidatById(@PathVariable Osoba osobaId, @PathVariable Integer profilId) {
		return ResponseEntity.ok(kandidatService.findById(osobaId, profilId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveKandidat")
	public ResponseEntity<Kandidat> saveKandidat(@RequestBody Kandidat kandidat) {
		return ResponseEntity.status(HttpStatus.CREATED).body(kandidatService.save(kandidat));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateKandidat")
	public ResponseEntity<Kandidat> updateKandidat(@RequestBody Kandidat kandidat) {
		return ResponseEntity.ok(kandidatService.update(kandidat));
	}

	@DeleteMapping("/{osobaId}/{profilId}")
	@ApiOperation(value = "", nickname = "deleteKandidatById")
	public void deleteKandidatById(@PathVariable Osoba osobaId, @PathVariable Integer profilId) {
		kandidatService.deleteById(osobaId, profilId);
	}

}

