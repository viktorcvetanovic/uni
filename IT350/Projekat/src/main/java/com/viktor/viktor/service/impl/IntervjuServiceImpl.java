package com.viktor.viktor.service.impl;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.repository.IntervjuRepository;
import com.viktor.viktor.service.IntervjuService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IntervjuServiceImpl implements IntervjuService {
	private final IntervjuRepository intervjuRepository;

	@Override
	public List<Intervju> findAll() {
		return intervjuRepository.findAll();
	}

	@Override
	public Intervju findById(Integer intervjuId) {
		return intervjuRepository.findById(intervjuId)
				.orElseThrow(() -> new NoSuchElementException("IntervjuService.notFound"));
	}

	@Override
	public Intervju save(Intervju intervju) {
		return intervjuRepository.save(intervju);
	}

	@Override
	public Intervju update(Intervju intervju) {
		return intervjuRepository.save(intervju);
	}

	@Override
	public void deleteById(Integer intervjuId) {
		intervjuRepository.deleteById(intervjuId);
	}


}