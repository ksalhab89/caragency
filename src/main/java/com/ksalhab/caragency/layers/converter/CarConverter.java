package com.ksalhab.caragency.layers.converter;

import com.ksalhab.caragency.layers.domain.Car;
import com.ksalhab.caragency.layers.dto.CarDTO;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

	public CarDTO fromDomain(Car car) {
		return new CarDTO(car.getYear(), car.getModel(), car.getHorsePower(),
				car.getElectric(), car.getUsed(), car.getNumberOfSeats());
	}

	public Car fromDTO(CarDTO carDTO) {
		return new Car(carDTO.getYear(), carDTO.getModel(), carDTO.getHorsePower(),
				carDTO.getElectric(), carDTO.getUsed(), carDTO.getNumberOfSeats());
	}
}
