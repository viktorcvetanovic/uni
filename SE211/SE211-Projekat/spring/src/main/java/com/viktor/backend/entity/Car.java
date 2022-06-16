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
@Table(name = "car")
@RequiredArgsConstructor
public class Car implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private Integer id;
	@Column(name = "brand")
	private String brand;
	@Column(name = "model")
	private String model;


	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return id.equals(car.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


}