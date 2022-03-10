package com.viktor.viktor.service;

import com.viktor.viktor.entity.*;
import java.util.Collection;
import java.util.List;

public interface OsobaService {

	List<Osoba> findAll();

	Osoba save(Osoba osoba);

	Osoba update(Osoba osoba);

	Osoba findById(Integer osobaId);

	void deleteById(Integer osobaId);

}