package com.viktor.service.impl;

import com.viktor.entity.*;
import com.viktor.repository.KandidatOglasRepository;
import com.viktor.service.KandidatOglasService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KandidatOglasServiceImpl implements KandidatOglasService {
	private final KandidatOglasRepository kandidatOglasRepository;

	@Override
	public List<KandidatOglas> findAll(Specification<KandidatOglas> specification, Sort sort) {
		return kandidatOglasRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public KandidatOglas findById(Integer profilOglasId) {
		return kandidatOglasRepository.findById(profilOglasId)
				.orElseThrow(() -> new NoSuchElementException("KandidatOglasService.notFound"));
	}

	@Override
	public KandidatOglas save(KandidatOglas kandidatOglas) {
		return kandidatOglasRepository.save(kandidatOglas);
	}

	@Override
	public KandidatOglas update(KandidatOglas kandidatOglas) {
		return kandidatOglasRepository.save(kandidatOglas);
	}

	@Override
	public void deleteById(Integer profilOglasId) {
		kandidatOglasRepository.deleteById(profilOglasId);
	}


}