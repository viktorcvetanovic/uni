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
@Table(name = "osoba")
@RequiredArgsConstructor
public class Osoba extends Auditable {
	@Id
	@Column(name = "osoba_id")
	private Integer id;
	@Column(name = "ime")
	private String ime;
	@Column(name = "prezime")
	private String prezime;
	@Column(name = "pol")
	private String pol;
	@Column(name = "godina_rodjenja")
	private LocalDate godinaRodjenja;
	@Column(name = "mesto")
	private String mesto;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Osoba osoba = (Osoba) o;
		return id.equals(osoba.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}