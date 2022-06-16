package com.viktor.backend.service.impl;

import com.viktor.backend.entity.*;
import com.viktor.backend.repository.CommnetRepository;
import com.viktor.backend.service.CommnetService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommnetServiceImpl implements CommnetService {
	private final CommnetRepository commnetRepository;

	@Override
	public List<Commnet> findAll() {
		return commnetRepository.findAll();
	}

	@Override
	public Commnet findById(Integer commentId) {
		return commnetRepository.findById(commentId)
				.orElseThrow(() -> new NoSuchElementException("CommnetService.notFound"));
	}

	@Override
	public Commnet save(Commnet commnet) {
		return commnetRepository.save(commnet);
	}

	@Override
	public Commnet update(Commnet commnet) {
		return commnetRepository.save(commnet);
	}

	@Override
	public void deleteById(Integer commentId) {
		commnetRepository.deleteById(commentId);
	}


}