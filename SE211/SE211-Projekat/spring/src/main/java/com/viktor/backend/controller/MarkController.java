package com.viktor.backend.controller;

import com.viktor.backend.entity.*;
import com.viktor.backend.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marks")
@RequiredArgsConstructor
public class MarkController {
	private final MarkService markService;

	@GetMapping
	public ResponseEntity<List<Mark>> getAllMarks() {
		return ResponseEntity.ok(markService.findAll());
	}

	@GetMapping("/{markId}")
	public ResponseEntity<Mark> getMarkById(@PathVariable Integer markId) {
		return ResponseEntity.ok(markService.findById(markId));
	}

	@PostMapping
	public ResponseEntity<Mark> saveMark(@RequestBody Mark mark) {
		return ResponseEntity.status(HttpStatus.CREATED).body(markService.save(mark));
	}

	@PutMapping
	public ResponseEntity<Mark> updateMark(@RequestBody Mark mark) {
		return ResponseEntity.ok(markService.update(mark));
	}

	@DeleteMapping("/{markId}")
	public void deleteMarkById(@PathVariable Integer markId) {
		markService.deleteById(markId);
	}

}

