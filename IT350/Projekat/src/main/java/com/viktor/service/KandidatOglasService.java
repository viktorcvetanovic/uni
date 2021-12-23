package com.viktor.service;

import com.viktor.entity.*;
import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public interface KandidatOglasService {

	List<KandidatOglas> findAll(Specification<KandidatOglas> specification, Sort sort);

	KandidatOglas save(KandidatOglas kandidatOglas);

	KandidatOglas update(KandidatOglas kandidatOglas);

	KandidatOglas findById(Integer profilOglasId);

	void deleteById(Integer profilOglasId);

}