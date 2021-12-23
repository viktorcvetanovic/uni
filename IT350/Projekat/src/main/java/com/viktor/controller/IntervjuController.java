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
@RequestMapping("/intervjus")
@RequiredArgsConstructor
public class IntervjuController {
	private final IntervjuService intervjuService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllIntervjus")
	public ResponseEntity<List<Intervju>> getAllIntervjus(@RequestParam(name = "q", required = false) Specification<Intervju> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(intervjuService.findAll(specification, sort));
	}

	@GetMapping("/{intervjuId}")
	@ApiOperation(value = "", nickname = "getIntervjuById")
	public ResponseEntity<Intervju> getIntervjuById(@PathVariable Integer intervjuId) {
		return ResponseEntity.ok(intervjuService.findById(intervjuId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveIntervju")
	public ResponseEntity<Intervju> saveIntervju(@RequestBody Intervju intervju) {
		return ResponseEntity.status(HttpStatus.CREATED).body(intervjuService.save(intervju));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateIntervju")
	public ResponseEntity<Intervju> updateIntervju(@RequestBody Intervju intervju) {
		return ResponseEntity.ok(intervjuService.update(intervju));
	}

	@DeleteMapping("/{intervjuId}")
	@ApiOperation(value = "", nickname = "deleteIntervjuById")
	public void deleteIntervjuById(@PathVariable Integer intervjuId) {
		intervjuService.deleteById(intervjuId);
	}

}

