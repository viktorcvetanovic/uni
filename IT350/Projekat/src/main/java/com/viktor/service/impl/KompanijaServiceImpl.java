package com.viktor.service.impl;

import com.viktor.entity.*;
import com.viktor.repository.KompanijaRepository;
import com.viktor.service.KompanijaService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KompanijaServiceImpl implements KompanijaService {
	private final KompanijaRepository kompanijaRepository;

	@Override
	public List<Kompanija> findAll(Specification<Kompanija> specification, Sort sort) {
		return kompanijaRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Kompanija findById(Vlasnik osobaId, Vlasnik vlasnikId, Integer kompanijaId) {
		return kompanijaRepository.findById(new Kompanija.KompanijaId(osobaId, vlasnikId, kompanijaId))
				.orElseThrow(() -> new NoSuchElementException("KompanijaService.notFound"));
	}

	@Override
	public Kompanija save(Kompanija kompanija) {
		return kompanijaRepository.save(kompanija);
	}

	@Override
	public Kompanija update(Kompanija kompanija) {
		return kompanijaRepository.save(kompanija);
	}

	@Override
	public void deleteById(Vlasnik osobaId, Vlasnik vlasnikId, Integer kompanijaId) {
		kompanijaRepository.deleteById(new Kompanija.KompanijaId(osobaId, vlasnikId, kompanijaId));
	}


}