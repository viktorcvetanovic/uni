package com.viktor.viktor.service.impl;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.repository.OsobaRepository;
import com.viktor.viktor.service.OsobaService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OsobaServiceImpl implements OsobaService {
	private final OsobaRepository osobaRepository;

	@Override
	public List<Osoba> findAll() {
		return osobaRepository.findAll();
	}

	@Override
	public Osoba findById(Integer osobaId) {
		return osobaRepository.findById(osobaId)
				.orElseThrow(() -> new NoSuchElementException("OsobaService.notFound"));
	}

	@Override
	public Osoba save(Osoba osoba) {
		return osobaRepository.save(osoba);
	}

	@Override
	public Osoba update(Osoba osoba) {
		return osobaRepository.save(osoba);
	}

	@Override
	public void deleteById(Integer osobaId) {
		osobaRepository.deleteById(osobaId);
	}


}