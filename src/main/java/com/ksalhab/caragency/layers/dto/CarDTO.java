package com.ksalhab.caragency.layers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
	private Integer year;
	private String model;
	private Integer horsePower;
	private Boolean electric;
	private Boolean used;
	private Integer numberOfSeats;
}
