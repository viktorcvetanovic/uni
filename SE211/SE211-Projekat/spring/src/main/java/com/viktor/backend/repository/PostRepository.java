package com.viktor.backend.repository;

import com.viktor.backend.entity.Post;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}