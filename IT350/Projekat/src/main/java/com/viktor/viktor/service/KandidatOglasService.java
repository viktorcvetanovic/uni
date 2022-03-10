package com.viktor.viktor.service;

import com.viktor.viktor.entity.*;
import java.util.Collection;
import java.util.List;

public interface KandidatOglasService {

	List<KandidatOglas> findAll();

	KandidatOglas save(KandidatOglas kandidatOglas);

	KandidatOglas update(KandidatOglas kandidatOglas);

	KandidatOglas findById(Integer profilOglasId);

	void deleteById(Integer profilOglasId);

}