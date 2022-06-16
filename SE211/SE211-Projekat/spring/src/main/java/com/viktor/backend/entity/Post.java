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
@Table(name = "post")
@RequiredArgsConstructor
public class Post implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Integer id;
	@Column(name = "header")
	private String header;
	@Column(name = "body")
	private String body;
	@ManyToOne
	@JoinColumn(name = "car_fk", referencedColumnName = "car_id")
	private Car car;
	@ManyToOne
	@JoinColumn(name = "mark_fk", referencedColumnName = "mark_id")
	private Mark mark;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Post post = (Post) o;
		return id.equals(post.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}