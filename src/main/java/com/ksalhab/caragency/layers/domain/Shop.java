package com.ksalhab.caragency.layers.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Carshop")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "shops_id_seq")
	private Long id;
	private String location;
	private Integer inventory;
	@Column(name = "currently_open")
	private Boolean currentlyOpen;
	@Column(name = "number_of_employees")
	private Integer numberOfEmployees;
	private Instant openSince;

	public Shop(String location, Integer inventory, Boolean currentlyOpen,
	            Integer numberOfEmployees, Instant openSince) {
		this.location = location;
		this.inventory = inventory;
		this.currentlyOpen = currentlyOpen;
		this.numberOfEmployees = numberOfEmployees;
		this.openSince = openSince;
	}

}
