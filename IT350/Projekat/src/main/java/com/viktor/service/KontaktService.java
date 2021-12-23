package com.viktor.service;

import com.viktor.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface KontaktService {

	List<Kontakt> findAll(Specification<Kontakt> specification, Sort sort);

	Kontakt save(Kontakt kontakt);

	Kontakt update(Kontakt kontakt);

	Kontakt findById(Integer kontaktId);

	void deleteById(Integer kontaktId);

}