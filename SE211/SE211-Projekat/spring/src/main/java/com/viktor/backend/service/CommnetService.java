package com.viktor.backend.service;

import com.viktor.backend.entity.*;
import java.util.Collection;
import java.util.List;

public interface CommnetService {

	List<Commnet> findAll();

	Commnet save(Commnet commnet);

	Commnet update(Commnet commnet);

	Commnet findById(Integer commentId);

	void deleteById(Integer commentId);

}