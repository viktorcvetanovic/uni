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
@RequestMapping("/oglases")
@RequiredArgsConstructor
public class OglasController {
	private final OglasService oglasService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllOglases")
	public ResponseEntity<List<Oglas>> getAllOglases(@RequestParam(name = "q", required = false) Specification<Oglas> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(oglasService.findAll(specification, sort));
	}

	@GetMapping("/{oglasId}")
	@ApiOperation(value = "", nickname = "getOglasById")
	public ResponseEntity<Oglas> getOglasById(@PathVariable Integer oglasId) {
		return ResponseEntity.ok(oglasService.findById(oglasId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveOglas")
	public ResponseEntity<Oglas> saveOglas(@RequestBody Oglas oglas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(oglasService.save(oglas));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateOglas")
	public ResponseEntity<Oglas> updateOglas(@RequestBody Oglas oglas) {
		return ResponseEntity.ok(oglasService.update(oglas));
	}

	@DeleteMapping("/{oglasId}")
	@ApiOperation(value = "", nickname = "deleteOglasById")
	public void deleteOglasById(@PathVariable Integer oglasId) {
		oglasService.deleteById(oglasId);
	}

}

