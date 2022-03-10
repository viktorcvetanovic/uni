package com.viktor.viktor.service.impl;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.repository.KandidatOglasRepository;
import com.viktor.viktor.service.KandidatOglasService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KandidatOglasServiceImpl implements KandidatOglasService {
	private final KandidatOglasRepository kandidatOglasRepository;

	@Override
	public List<KandidatOglas> findAll() {
		return kandidatOglasRepository.findAll();
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