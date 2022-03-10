package com.viktor.viktor.service;

import com.viktor.viktor.entity.*;
import java.util.Collection;
import java.util.List;

public interface IntervjuService {

	List<Intervju> findAll();

	Intervju save(Intervju intervju);

	Intervju update(Intervju intervju);

	Intervju findById(Integer intervjuId);

	void deleteById(Integer intervjuId);

}