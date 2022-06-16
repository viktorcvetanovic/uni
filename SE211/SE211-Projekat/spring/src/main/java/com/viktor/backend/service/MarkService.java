package com.viktor.backend.service;

import com.viktor.backend.entity.*;
import java.util.Collection;
import java.util.List;

public interface MarkService {

	List<Mark> findAll();

	Mark save(Mark mark);

	Mark update(Mark mark);

	Mark findById(Integer markId);

	void deleteById(Integer markId);

}