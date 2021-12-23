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
@RequestMapping("/kandidat-oglases")
@RequiredArgsConstructor
public class KandidatOglasController {
	private final KandidatOglasService kandidatOglasService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllKandidatOglases")
	public ResponseEntity<List<KandidatOglas>> getAllKandidatOglases(@RequestParam(name = "q", required = false) Specification<KandidatOglas> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(kandidatOglasService.findAll(specification, sort));
	}

	@GetMapping("/{profilOglasId}")
	@ApiOperation(value = "", nickname = "getKandidatOglasById")
	public ResponseEntity<KandidatOglas> getKandidatOglasById(@PathVariable Integer profilOglasId) {
		return ResponseEntity.ok(kandidatOglasService.findById(profilOglasId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveKandidatOglas")
	public ResponseEntity<KandidatOglas> saveKandidatOglas(@RequestBody KandidatOglas kandidatOglas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(kandidatOglasService.save(kandidatOglas));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateKandidatOglas")
	public ResponseEntity<KandidatOglas> updateKandidatOglas(@RequestBody KandidatOglas kandidatOglas) {
		return ResponseEntity.ok(kandidatOglasService.update(kandidatOglas));
	}

	@DeleteMapping("/{profilOglasId}")
	@ApiOperation(value = "", nickname = "deleteKandidatOglasById")
	public void deleteKandidatOglasById(@PathVariable Integer profilOglasId) {
		kandidatOglasService.deleteById(profilOglasId);
	}

}

