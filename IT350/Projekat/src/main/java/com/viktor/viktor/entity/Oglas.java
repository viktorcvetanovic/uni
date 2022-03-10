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
@Table(name = "oglas")
@RequiredArgsConstructor
public class Oglas extends Auditable {
	@Id
	@Column(name = "oglas_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "osoba_id", referencedColumnName = "osoba_id")
	private Kompanija osobaId;
	@ManyToOne
	@JoinColumn(name = "vlasnik_id", referencedColumnName = "osoba_id")
	private Kompanija vlasnikId;
	@ManyToOne
	@JoinColumn(name = "kompanija_id", referencedColumnName = "osoba_id")
	private Kompanija kompanijaId;
	@Column(name = "naziv_pozicije")
	private String nazivPozicije;
	@Column(name = "tip_posla")
	private String tipPosla;
	@Column(name = "plata")
	private Double plata;
	@Column(name = "radno_iskustvo")
	private Double radnoIskustvo;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Oglas oglas = (Oglas) o;
		return id.equals(oglas.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}