package com.viktor.service.impl;

import com.viktor.entity.*;
import com.viktor.repository.VlasnikRepository;
import com.viktor.service.VlasnikService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VlasnikServiceImpl implements VlasnikService {
	private final VlasnikRepository vlasnikRepository;

	@Override
	public List<Vlasnik> findAll(Specification<Vlasnik> specification, Sort sort) {
		return vlasnikRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Vlasnik findById(Osoba osobaId, Integer vlasnikId) {
		return vlasnikRepository.findById(new Vlasnik.VlasnikId(osobaId, vlasnikId))
				.orElseThrow(() -> new NoSuchElementException("VlasnikService.notFound"));
	}

	@Override
	public Vlasnik save(Vlasnik vlasnik) {
		return vlasnikRepository.save(vlasnik);
	}

	@Override
	public Vlasnik update(Vlasnik vlasnik) {
		return vlasnikRepository.save(vlasnik);
	}

	@Override
	public void deleteById(Osoba osobaId, Integer vlasnikId) {
		vlasnikRepository.deleteById(new Vlasnik.VlasnikId(osobaId, vlasnikId));
	}


}