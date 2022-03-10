package com.viktor.viktor.service.impl;

import com.viktor.viktor.entity.*;
import com.viktor.viktor.repository.VlasnikRepository;
import com.viktor.viktor.service.VlasnikService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VlasnikServiceImpl implements VlasnikService {
	private final VlasnikRepository vlasnikRepository;

	@Override
	public List<Vlasnik> findAll() {
		return vlasnikRepository.findAll();
	}

	@Override
	public Vlasnik findById(Integer vlasnikId) {
		return vlasnikRepository.findById(vlasnikId)
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
	public void deleteById(Integer vlasnikId) {
		vlasnikRepository.deleteById(vlasnikId);
	}


}