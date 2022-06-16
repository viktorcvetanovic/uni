package com.viktor.backend.service.impl;

import com.viktor.backend.entity.*;
import com.viktor.backend.repository.MarkRepository;
import com.viktor.backend.service.MarkService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {
	private final MarkRepository markRepository;

	@Override
	public List<Mark> findAll() {
		return markRepository.findAll();
	}

	@Override
	public Mark findById(Integer markId) {
		return markRepository.findById(markId)
				.orElseThrow(() -> new NoSuchElementException("MarkService.notFound"));
	}

	@Override
	public Mark save(Mark mark) {
		return markRepository.save(mark);
	}

	@Override
	public Mark update(Mark mark) {
		return markRepository.save(mark);
	}

	@Override
	public void deleteById(Integer markId) {
		markRepository.deleteById(markId);
	}


}