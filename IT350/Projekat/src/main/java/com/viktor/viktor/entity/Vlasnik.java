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
@Table(name = "vlasnik")
@RequiredArgsConstructor
public class Vlasnik  {
	@Id
	@Column(name = "vlasnik_id")
	private Integer id;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Vlasnik vlasnik = (Vlasnik) o;
		return id.equals(vlasnik.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}