package com.viktor.backend.controller;

import com.viktor.backend.entity.*;
import com.viktor.backend.service.*;
import java.util.List;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;

	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts() {
		return ResponseEntity.ok(postService.findAll());
	}

	@GetMapping("/{postId}")
	public ResponseEntity<Post> getPostById(@PathVariable Integer postId) {
		return ResponseEntity.ok(postService.findById(postId));
	}

	@PostMapping
	public ResponseEntity<Post> savePost(@RequestBody Post post) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post));
	}

	@PutMapping
	public ResponseEntity<Post> updatePost(@RequestBody Post post) {
		return ResponseEntity.ok(postService.update(post));
	}

	@DeleteMapping("/{postId}")
	public void deletePostById(@PathVariable Integer postId) {
		postService.deleteById(postId);
	}

}

