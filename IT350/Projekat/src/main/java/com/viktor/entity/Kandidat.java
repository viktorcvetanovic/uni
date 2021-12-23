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
@Table(name = "kandidat")
public class Kandidat extends Auditable {
	@EmbeddedId
	private KandidatId kandidatId;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Embeddable
	public static final class KandidatId implements java.io.Serializable {
		@ManyToOne
		@JoinColumn(name = "osoba_id", referencedColumnName = "osoba_id")
		private Osoba osobaId;
		@Id
		@Column(name = "profil_id")
		private Integer id;
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			KandidatId kandidatId = (KandidatId) o;
			return osobaId.equals(kandidatId.osobaId) && profilId.equals(kandidatId.profilId);
		}
	
	
		@Override
		public int hashCode() {
			return Objects.hash(osobaId, profilId);
		}
	
	
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Kandidat kandidat = (Kandidat) o;
		return kandidatId.equals(kandidat.kandidatId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(kandidatId);
	}


}