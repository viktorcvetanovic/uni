package com.viktor.viktor.service.impl;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.repository.KompanijaRepository;
import com.viktor.viktor.service.KompanijaService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KompanijaServiceImpl implements KompanijaService {
	private final KompanijaRepository kompanijaRepository;

	@Override
	public List<Kompanija> findAll() {
		return kompanijaRepository.findAll();
	}

	@Override
	public Kompanija findById(Integer osobaId, Vlasnik vlasnikId, Integer kompanijaId) {
		return kompanijaRepository.findById(kompanijaId)
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
	public void deleteById(Integer osobaId, Vlasnik vlasnikId, Integer kompanijaId) {
		kompanijaRepository.deleteById(kompanijaId);
	}


}