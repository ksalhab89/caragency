package com.ksalhab.caragency.layers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {
	private String location;
	private Integer inventory;
	private Boolean currentlyOpen;
	private Integer numberOfEmployees;
	private Instant openSince;
}
