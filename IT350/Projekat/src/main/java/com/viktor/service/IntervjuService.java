package com.viktor.service;

import com.viktor.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface IntervjuService {

	List<Intervju> findAll(Specification<Intervju> specification, Sort sort);

	Intervju save(Intervju intervju);

	Intervju update(Intervju intervju);

	Intervju findById(Integer intervjuId);

	void deleteById(Integer intervjuId);

}