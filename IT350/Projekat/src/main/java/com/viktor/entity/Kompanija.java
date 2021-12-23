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
@Table(name = "kompanija")
public class Kompanija extends Auditable {
	@EmbeddedId
	private KompanijaId kompanijaId;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Embeddable
	public static final class KompanijaId implements java.io.Serializable {
		@ManyToOne
		@JoinColumn(name = "osoba_id", referencedColumnName = "osoba_id")
		private Vlasnik osobaId;
		@ManyToOne
		@JoinColumn(name = "vlasnik_id", referencedColumnName = "osoba_id")
		private Vlasnik vlasnikId;
		@Id
		@Column(name = "kompanija_id")
		private Integer id;
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			KompanijaId kompanijaId = (KompanijaId) o;
			return osobaId.equals(kompanijaId.osobaId) && vlasnikId.equals(kompanijaId.vlasnikId) && kompanijaId.equals(kompanijaId.kompanijaId);
		}
	
	
		@Override
		public int hashCode() {
			return Objects.hash(osobaId, vlasnikId, kompanijaId);
		}
	
	
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Kompanija kompanija = (Kompanija) o;
		return kompanijaId.equals(kompanija.kompanijaId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(kompanijaId);
	}


}