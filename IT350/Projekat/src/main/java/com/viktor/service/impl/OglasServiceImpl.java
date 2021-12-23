package com.viktor.service.impl;

import com.viktor.entity.*;
import com.viktor.repository.OglasRepository;
import com.viktor.service.OglasService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OglasServiceImpl implements OglasService {
	private final OglasRepository oglasRepository;

	@Override
	public List<Oglas> findAll(Specification<Oglas> specification, Sort sort) {
		return oglasRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
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