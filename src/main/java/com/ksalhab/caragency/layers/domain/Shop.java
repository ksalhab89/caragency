package com.ksalhab.caragency.layers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
	private String location;
	private Integer inventory;
	private Boolean currentlyOpen;
	private Integer numberOfEmployees;
	private Instant openSince;
}
