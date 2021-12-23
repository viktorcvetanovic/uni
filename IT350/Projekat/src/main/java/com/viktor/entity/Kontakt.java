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
@Table(name = "kontakt")
@RequiredArgsConstructor
public class Kontakt extends Auditable {
	@Id
	@Column(name = "kontakt_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "kom_osoba_id", referencedColumnName = "osoba_id")
	private Kompanija komOsobaId;
	@ManyToOne
	@JoinColumn(name = "vlasnik_id", referencedColumnName = "osoba_id")
	private Kompanija vlasnikId;
	@ManyToOne
	@JoinColumn(name = "kompanija_id", referencedColumnName = "osoba_id")
	private Kompanija kompanijaId;
	@ManyToOne
	@JoinColumn(name = "osoba_id", referencedColumnName = "osoba_id")
	private Osoba osobaId;
	@Column(name = "tip_kontakta")
	private String tipKontakta;
	@Column(name = "vrednost")
	private String vrednost;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Kontakt kontakt = (Kontakt) o;
		return id.equals(kontakt.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}