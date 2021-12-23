package com.viktor.service.impl;

import com.viktor.entity.*;
import com.viktor.repository.KontaktRepository;
import com.viktor.service.KontaktService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KontaktServiceImpl implements KontaktService {
	private final KontaktRepository kontaktRepository;

	@Override
	public List<Kontakt> findAll(Specification<Kontakt> specification, Sort sort) {
		return kontaktRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Kontakt findById(Integer kontaktId) {
		return kontaktRepository.findById(kontaktId)
				.orElseThrow(() -> new NoSuchElementException("KontaktService.notFound"));
	}

	@Override
	public Kontakt save(Kontakt kontakt) {
		return kontaktRepository.save(kontakt);
	}

	@Override
	public Kontakt update(Kontakt kontakt) {
		return kontaktRepository.save(kontakt);
	}

	@Override
	public void deleteById(Integer kontaktId) {
		kontaktRepository.deleteById(kontaktId);
	}


}