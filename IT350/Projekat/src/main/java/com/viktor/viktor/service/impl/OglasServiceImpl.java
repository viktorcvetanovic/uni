package com.viktor.viktor.service.impl;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.repository.OglasRepository;
import com.viktor.viktor.service.OglasService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OglasServiceImpl implements OglasService {
	private final OglasRepository oglasRepository;

	@Override
	public List<Oglas> findAll() {
		return oglasRepository.findAll();
	}

	@Override
	public Oglas findById(Integer oglasId) {
		return oglasRepository.findById(oglasId)
				.orElseThrow(() -> new NoSuchElementException("OglasService.notFound"));
	}

	@Override
	public Oglas save(Oglas oglas) {
		return oglasRepository.save(oglas);
	}

	@Override
	public Oglas update(Oglas oglas) {
		return oglasRepository.save(oglas);
	}

	@Override
	public void deleteById(Integer oglasId) {
		oglasRepository.deleteById(oglasId);
	}


}