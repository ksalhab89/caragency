package com.ksalhab.caragency.layers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	private Integer year;
	private String model;
	private Integer horsePower;
	private Boolean electric;
	private Boolean used;
	private Integer numberOfSeats;
}
