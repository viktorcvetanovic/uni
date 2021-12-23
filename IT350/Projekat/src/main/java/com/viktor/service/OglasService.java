package com.viktor.service;

import com.viktor.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface OglasService {

	List<Oglas> findAll(Specification<Oglas> specification, Sort sort);

	Oglas save(Oglas oglas);

	Oglas update(Oglas oglas);

	Oglas findById(Integer oglasId);

	void deleteById(Integer oglasId);

}