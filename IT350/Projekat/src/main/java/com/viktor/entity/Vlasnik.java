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
@Table(name = "vlasnik")
@RequiredArgsConstructor
public class Vlasnik extends Auditable {
	@EmbeddedId
	private VlasnikId vlasnikId;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Embeddable
	public static final class VlasnikId implements java.io.Serializable {
		@ManyToOne
		@JoinColumn(name = "osoba_id", referencedColumnName = "osoba_id")
		private Osoba osobaId;
		@Id
		@Column(name = "vlasnik_id")
		private Integer id;
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			VlasnikId vlasnikId = (VlasnikId) o;
			return osobaId.equals(vlasnikId.osobaId) && vlasnikId.equals(vlasnikId.vlasnikId);
		}
	
	
		@Override
		public int hashCode() {
			return Objects.hash(osobaId, vlasnikId);
		}
	
	
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vlasnik vlasnik = (Vlasnik) o;
		return vlasnikId.equals(vlasnik.vlasnikId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vlasnikId);
	}


}