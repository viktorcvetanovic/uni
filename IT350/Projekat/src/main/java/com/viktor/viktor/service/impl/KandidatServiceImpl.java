package com.viktor.viktor.service.impl;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.repository.KandidatRepository;
import com.viktor.viktor.service.KandidatService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KandidatServiceImpl implements KandidatService {
	private final KandidatRepository kandidatRepository;

	@Override
	public List<Kandidat> findAll() {
		return kandidatRepository.findAll();
	}

	@Override
	public Kandidat findById(Integer profilId) {
		return kandidatRepository.findById(profilId)
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
	public void deleteById(Integer profilId) {
		kandidatRepository.deleteById(profilId);
	}


}