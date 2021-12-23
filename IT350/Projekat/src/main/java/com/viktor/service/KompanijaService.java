package com.viktor.service;

import com.viktor.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface KompanijaService {

	List<Kompanija> findAll(Specification<Kompanija> specification, Sort sort);

	Kompanija save(Kompanija kompanija);

	Kompanija update(Kompanija kompanija);

	Kompanija findById(Vlasnik osobaId, Vlasnik vlasnikId, Integer kompanijaId);

	void deleteById(Vlasnik osobaId, Vlasnik vlasnikId, Integer kompanijaId);

}