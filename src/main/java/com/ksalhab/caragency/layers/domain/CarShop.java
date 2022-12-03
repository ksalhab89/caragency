package com.ksalhab.caragency.layers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarShop {
	private String location;
	private Instant openSince;
	private Integer inventory;
	private Boolean currentlyOpen;
	private Integer numberOfEmployees;

}
