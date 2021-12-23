package com.viktor.service;

import com.viktor.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface VlasnikService {

	List<Vlasnik> findAll(Specification<Vlasnik> specification, Sort sort);

	Vlasnik save(Vlasnik vlasnik);

	Vlasnik update(Vlasnik vlasnik);

	Vlasnik findById(Osoba osobaId, Integer vlasnikId);

	void deleteById(Osoba osobaId, Integer vlasnikId);

}