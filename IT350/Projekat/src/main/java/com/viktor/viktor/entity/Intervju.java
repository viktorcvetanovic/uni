package com.viktor.viktor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "intervju")
public class Intervju extends Auditable {
	@Id
	@Column(name = "intervju_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "profil_oglas_id", referencedColumnName = "profil_oglas_id")
	private KandidatOglas profilOglasId;
	@Column(name = "mesto")
	private String mesto;
	@Column(name = "vreme")
	private LocalDate vreme;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Intervju intervju = (Intervju) o;
		return id.equals(intervju.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}