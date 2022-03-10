package com.viktor.viktor.service;

import com.viktor.viktor.entity.*;
import java.util.Collection;
import java.util.List;

public interface VlasnikService {

	List<Vlasnik> findAll();

	Vlasnik save(Vlasnik vlasnik);

	Vlasnik update(Vlasnik vlasnik);

	Vlasnik findById(Integer vlasnikId);

	void deleteById(Integer vlasnikId);

}