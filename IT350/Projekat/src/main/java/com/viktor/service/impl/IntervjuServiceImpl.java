package com.viktor.service.impl;

import com.viktor.entity.*;
import com.viktor.repository.IntervjuRepository;
import com.viktor.service.IntervjuService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IntervjuServiceImpl implements IntervjuService {
	private final IntervjuRepository intervjuRepository;

	@Override
	public List<Intervju> findAll(Specification<Intervju> specification, Sort sort) {
		return intervjuRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
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