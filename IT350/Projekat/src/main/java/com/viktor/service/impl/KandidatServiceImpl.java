package com.viktor.service.impl;

import com.viktor.entity.*;
import com.viktor.repository.KandidatRepository;
import com.viktor.service.KandidatService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KandidatServiceImpl implements KandidatService {
	private final KandidatRepository kandidatRepository;

	@Override
	public List<Kandidat> findAll(Specification<Kandidat> specification, Sort sort) {
		return kandidatRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Kandidat findById(Osoba osobaId, Integer profilId) {
		return kandidatRepository.findById(new Kandidat.KandidatId(osobaId, profilId))
				.orElseThrow(() -> new NoSuchElementException("KandidatService.notFound"));
	}

	@Override
	public Kandidat save(Kandidat kandidat) {
		return kandidatRepository.save(kandidat);
	}

	@Override
	public Kandidat update(Kandidat kandidat) {
		return kandidatRepository.save(kandidat);
	}

	@Override
	public void deleteById(Osoba osobaId, Integer profilId) {
		kandidatRepository.deleteById(new Kandidat.KandidatId(osobaId, profilId));
	}


}