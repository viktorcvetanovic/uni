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
@Table(name = "kompanija")
public class Kompanija extends Auditable {
	@Id
	@Column(name = "osoba_id")
	private Integer kompanijaId;




}