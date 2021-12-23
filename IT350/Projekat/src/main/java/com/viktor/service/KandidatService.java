package com.viktor.service;

import com.viktor.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface KandidatService {

	List<Kandidat> findAll(Specification<Kandidat> specification, Sort sort);

	Kandidat save(Kandidat kandidat);

	Kandidat update(Kandidat kandidat);

	Kandidat findById(Osoba osobaId, Integer profilId);

	void deleteById(Osoba osobaId, Integer profilId);

}