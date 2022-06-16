package com.viktor.backend.service;

import com.viktor.backend.entity.*;
import java.util.Collection;
import java.util.List;

public interface PostService {

	List<Post> findAll();

	Post save(Post post);

	Post update(Post post);

	Post findById(Integer postId);

	void deleteById(Integer postId);

}