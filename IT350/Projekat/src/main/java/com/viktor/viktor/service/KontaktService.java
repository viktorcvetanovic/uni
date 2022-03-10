package com.viktor.viktor.service;

import com.viktor.viktor.entity.*;
import java.util.Collection;
import java.util.List;

public interface KontaktService {

	List<Kontakt> findAll();

	Kontakt save(Kontakt kontakt);

	Kontakt update(Kontakt kontakt);

	Kontakt findById(Integer kontaktId);

	void deleteById(Integer kontaktId);

}