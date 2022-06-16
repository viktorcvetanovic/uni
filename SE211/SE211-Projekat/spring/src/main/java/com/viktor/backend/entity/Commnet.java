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
@Table(name = "commnet")
@RequiredArgsConstructor
public class Commnet implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private Integer id;
	@Column(name = "content")
	private String content;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Commnet commnet = (Commnet) o;
		return id.equals(commnet.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}