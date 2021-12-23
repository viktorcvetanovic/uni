package com.viktor.entity;

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
@Table(name = "kandidat_oglas")
public class KandidatOglas extends Auditable {
	@Id
	@Column(name = "profil_oglas_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "oglas_id", referencedColumnName = "oglas_id")
	private Oglas oglasId;
	@ManyToOne
	@JoinColumn(name = "osoba_id", referencedColumnName = "osoba_id")
	private Kandidat osobaId;
	@ManyToOne
	@JoinColumn(name = "profil_id", referencedColumnName = "osoba_id")
	private Kandidat profilId;
	@Column(name = "datum")
	private LocalDate datum;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		KandidatOglas kandidatOglas = (KandidatOglas) o;
		return id.equals(kandidatOglas.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}