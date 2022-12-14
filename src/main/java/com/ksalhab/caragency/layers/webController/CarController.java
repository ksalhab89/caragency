package com.ksalhab.caragency.layers.webController;

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

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public CarDTO getCar(@PathVariable Long id) {
		return carService.getCar(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<CarDTO> getAllCars() {
		return carService.getAllCars();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public CarDTO addCar(@RequestBody CarDTO carDTO) {
		return carService.addCar(carDTO);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCar(@PathVariable Long id) {
		carService.deleteCar(id);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public CarDTO updateCar(@PathVariable Long id,
	                        @RequestBody CarDTO carDTO) {
		return carService.updateCar(id, carDTO);
	}

}
