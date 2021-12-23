package com.viktor.service;

import com.viktor.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface OsobaService {

	List<Osoba> findAll(Specification<Osoba> specification, Sort sort);

	Osoba save(Osoba osoba);

	Osoba update(Osoba osoba);

	Osoba findById(Integer osobaId);

	void deleteById(Integer osobaId);

}