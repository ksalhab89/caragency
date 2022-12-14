package com.ksalhab.caragency.layers.controller;

import com.ksalhab.caragency.layers.dto.CarDTO;
import com.ksalhab.caragency.layers.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {

	private CarService carService;

	@GetMapping(path = "/{id}")
	public CarDTO getCar(@PathVariable Long id) {
		return carService.getCar(id);
	}

	@GetMapping
	public List<CarDTO> getAllCars() {
		return carService.getAllCars();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CarDTO addCar(@RequestBody CarDTO carDTO) {
		return carService.addCar(carDTO);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCar(@PathVariable Long id) {
		carService.deleteCar(id);
	}

	@PutMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public CarDTO updateCar(@PathVariable Long id,
	                        @RequestBody CarDTO carDTO) {
		return carService.updateCar(id, carDTO);
	}

}
