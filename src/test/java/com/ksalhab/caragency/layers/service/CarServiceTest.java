package com.ksalhab.caragency.layers.service;

import com.ksalhab.caragency.layers.converter.CarConverter;
import com.ksalhab.caragency.layers.domain.Car;
import com.ksalhab.caragency.layers.dto.CarDTO;
import com.ksalhab.caragency.layers.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

class CarServiceTest {

	@InjectMocks
	private CarService carService;
	@Mock
	private CarRepository carRepository;
	@Mock
	private CarConverter carConverter;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void whenCarExistsThenReturnCarValues() {
		Car car = new Car(2011, "Corolla", 110,
				false, true, 5);
		when(carConverter.fromDomain(any())).thenCallRealMethod();
		when(carRepository.getCar(21L)).thenReturn(car);
		CarDTO carDTO = carService.getCar(21L);
		assertNotNull(carDTO);
		assertEquals("Corolla", carDTO.getModel());
		assertEquals(2011, carDTO.getYear());
		assertEquals(110, carDTO.getHorsePower());
		assertFalse(carDTO.getElectric());
		assertTrue(car.getUsed());
		assertEquals(5, carDTO.getNumberOfSeats());
		//...etc for all fields, if it's time create a variable to assertEquals.
	}

	public void getCarShouldThrowException() {
		when(carConverter.fromDomain(any())).thenCallRealMethod();
		when(carRepository.getCar(21L)).thenThrow(new RuntimeException());
		assertThrows(EmptyResultDataAccessException.class, () -> carService.getCar(21L));
		verifyNoInteractions();
	}

}