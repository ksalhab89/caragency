package com.ksalhab.caragency.layers.service;

import com.ksalhab.caragency.layers.converter.CarConverter;
import com.ksalhab.caragency.layers.domain.Car;
import com.ksalhab.caragency.layers.dto.CarDTO;
import com.ksalhab.caragency.layers.exceptions.DataNotFoundException;
import com.ksalhab.caragency.layers.exceptions.SemanticException;
import com.ksalhab.caragency.layers.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {

	private CarRepository carRepository;
	private CarConverter carConverter;

	public CarDTO addCar(@NotNull CarDTO carDTO) {
		checkYear(carDTO);

		Car carToAdd = carRepository.addCar(carConverter.fromDTO(carDTO));
		return carConverter.fromDomain(carToAdd);
	}

	public CarDTO updateCar(Long id, CarDTO carDTO) {
		checkIfExists(id);
		checkYear(carDTO);

		Car carToAdd = carRepository.updateCar(id, carConverter.fromDTO(carDTO));
		return carConverter.fromDomain(carToAdd);
	}

	public void deleteCar(Long id) {
		checkIfExists(id);
		carRepository.deleteCar(id);
	}

	private void checkYear(@NotNull CarDTO carDTO) {
		if (carDTO.getYear() < 0) {
			throw new SemanticException("Year must be positive");
		}
	}

	private void checkIfExists(Long id) {
		Car car = carRepository.getCar(id);
		if (car != null) {
			System.out.println("exists");
		} else {
			throw new DataNotFoundException(String.format("Car with id %s not found", id));
		}
	}

}
