package com.viktor.backend.controller;

import com.viktor.backend.entity.*;
import com.viktor.backend.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commnets")
@RequiredArgsConstructor
public class CommnetController {
	private final CommnetService commnetService;

	@GetMapping
	public ResponseEntity<List<Commnet>> getAllCommnets() {
		return ResponseEntity.ok(commnetService.findAll());
	}

	@GetMapping("/{commentId}")
	public ResponseEntity<Commnet> getCommnetById(@PathVariable Integer commentId) {
		return ResponseEntity.ok(commnetService.findById(commentId));
	}

	@PostMapping
	public ResponseEntity<Commnet> saveCommnet(@RequestBody Commnet commnet) {
		return ResponseEntity.status(HttpStatus.CREATED).body(commnetService.save(commnet));
	}

	@PutMapping
	public ResponseEntity<Commnet> updateCommnet(@RequestBody Commnet commnet) {
		return ResponseEntity.ok(commnetService.update(commnet));
	}

	@DeleteMapping("/{commentId}")
	public void deleteCommnetById(@PathVariable Integer commentId) {
		commnetService.deleteById(commentId);
	}

}

