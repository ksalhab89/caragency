package com.ksalhab.caragency.layers.config;

import com.ksalhab.caragency.layers.domain.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class ApplicationConfig {

	@Bean
	public RowMapper<Car> carRowMapper() {
		return new BeanPropertyRowMapper<>(Car.class);
	}

}
