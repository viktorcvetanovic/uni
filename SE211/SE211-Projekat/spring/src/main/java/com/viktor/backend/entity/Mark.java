package com.viktor.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "mark")
@RequiredArgsConstructor
public class Mark implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mark_id")
	private Integer id;
	@Column(name = "mark_value")
	private Integer markValue;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Mark mark = (Mark) o;
		return id.equals(mark.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}