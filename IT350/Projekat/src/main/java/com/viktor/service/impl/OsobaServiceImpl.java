package com.viktor.service.impl;

import com.viktor.entity.*;
import com.viktor.repository.OsobaRepository;
import com.viktor.service.OsobaService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OsobaServiceImpl implements OsobaService {
	private final OsobaRepository osobaRepository;

	@Override
	public List<Osoba> findAll(Specification<Osoba> specification, Sort sort) {
		return osobaRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Osoba findById(Integer osobaId) {
		return osobaRepository.findById(osobaId)
				.orElseThrow(() -> new NoSuchElementException("OsobaService.notFound"));
	}

	@Override
	public Osoba save(Osoba osoba) {
		return osobaRepository.save(osoba);
	}

	@Override
	public Osoba update(Osoba osoba) {
		return osobaRepository.save(osoba);
	}

	@Override
	public void deleteById(Integer osobaId) {
		osobaRepository.deleteById(osobaId);
	}


}