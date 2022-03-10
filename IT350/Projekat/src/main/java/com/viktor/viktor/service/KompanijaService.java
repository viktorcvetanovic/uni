package com.viktor.viktor.service;

import com.viktor.viktor.entity.*;
import java.util.Collection;
import java.util.List;

public interface KompanijaService {

	List<Kompanija> findAll();

	Kompanija save(Kompanija kompanija);

	Kompanija update(Kompanija kompanija);

	Kompanija findById(Integer osobaId, Vlasnik vlasnikId, Integer kompanijaId);

	void deleteById(Integer osobaId, Vlasnik vlasnikId, Integer kompanijaId);

}