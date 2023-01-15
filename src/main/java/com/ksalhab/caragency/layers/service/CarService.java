package com.ksalhab.caragency.layers.service;

import com.ksalhab.caragency.layers.converter.CarConverter;
import com.ksalhab.caragency.layers.domain.Car;
import com.ksalhab.caragency.layers.dto.CarDTO;
import com.ksalhab.caragency.layers.exceptions.SemanticException;
import com.ksalhab.caragency.layers.repository.CarRepo;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {

	private final CarRepo carRepo;
	private CarConverter carConverter;

	public CarDTO getCar(Long id) {
		return carConverter.fromDomain(carRepo.findById(id).get());
	}

	public List<CarDTO> getAllCars() {
		return carRepo.findAll()
				       .stream()
				       .map(car -> carConverter.fromDomain(car))
				       .collect(Collectors.toList());
	}

	public CarDTO addCar(@NotNull CarDTO carDTO) {
		checkYear(carDTO);

		Car carToAdd = carRepo.save(carConverter.fromDTO(carDTO));
		return carConverter.fromDomain(carToAdd);
	}

	public CarDTO updateCar(Long id, CarDTO carDTO) {
		checkYear(carDTO);

		return carRepo.findById(id)
				       .map(car -> {
					       Car carToUpdate = carConverter.fromDTO(carDTO);
					       carToUpdate.setId(car.getId());
					       return carRepo.save(carToUpdate);
				       })
				       .map(savedCar -> carConverter.fromDomain(savedCar))
				       .orElseThrow(RuntimeException::new);

	}

	public void deleteCar(Long id) {
		carRepo.deleteById(id);
	}

	public List<CarDTO> getCarsStartWith(String startWith) {
		return carRepo.findAllByModelStartsWith(startWith)
				       .stream()
				       .map(car -> carConverter.fromDomain(car))
				       .collect(Collectors.toList());
	}

	private void checkYear(@NotNull CarDTO carDTO) {
		if (carDTO.getYear() < 0) {
			throw new SemanticException("Year must be positive");
		}
	}

}
