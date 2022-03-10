package com.viktor.viktor.service;

import com.viktor.viktor.entity.*;
import java.util.Collection;
import java.util.List;

public interface KandidatService {

	List<Kandidat> findAll();

	Kandidat save(Kandidat kandidat);

	Kandidat update(Kandidat kandidat);

	Kandidat findById(Integer profilId);

	void deleteById(Integer profilId);

}