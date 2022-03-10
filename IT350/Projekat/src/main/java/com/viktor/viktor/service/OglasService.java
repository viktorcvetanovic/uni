package com.viktor.viktor.service;

import com.viktor.viktor.entity.*;
import java.util.Collection;
import java.util.List;

public interface OglasService {

	List<Oglas> findAll();

	Oglas save(Oglas oglas);

	Oglas update(Oglas oglas);

	Oglas findById(Integer oglasId);

	void deleteById(Integer oglasId);

}