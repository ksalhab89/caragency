package com.ksalhab.caragency.layers.repository;

import com.ksalhab.caragency.layers.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CarRepository {

	private final JdbcTemplate jdbcTemplate;

	public Car getCar(Long id) {
		RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
		return jdbcTemplate.queryForObject("select * from cars where id=?", rowMapper, id);
	}
}
