package com.ksalhab.caragency.layers.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cars_id_seq")
	private Long id;
	private Integer year;
	private String model;
	@Column(name = "horse_power")
	private Integer horsePower;
	private Boolean electric;
	private Boolean used;
	@Column(name = "number_of_seats")
	private Integer numberOfSeats;

	public Car(Integer year, String model, Integer horsePower,
	           Boolean electric, Boolean used, Integer numberOfSeats) {
		this.year = year;
		this.model = model;
		this.horsePower = horsePower;
		this.electric = electric;
		this.used = used;
		this.numberOfSeats = numberOfSeats;
	}

}
