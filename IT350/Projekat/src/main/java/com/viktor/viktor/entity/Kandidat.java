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
@Table(name = "kandidat")
public class Kandidat extends Auditable {
	@Id
	@Column(name = "profil_id")
	private Integer id;
	@Column(name = "korisnicko_ime")
	private String korisnickoIme;
	@Column(name = "sifra")
	private String sifra;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Kandidat kandidat = (Kandidat) o;
		return id.equals(kandidat.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}