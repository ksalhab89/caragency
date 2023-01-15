package com.ksalhab.caragency.layers.appEvent;

import com.ksalhab.caragency.layers.domain.Car;
import com.ksalhab.caragency.layers.repository.jdbcRepositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;

@AllArgsConstructor
public class ApplicationReadyRepoExamples {

	private CarRepository carRepository;

	@EventListener(ApplicationContextEvent.class)
	public void doSomeEventOnce() {
		Car car = carRepository.getCar(2L);
		System.out.println(car);
		Car carToBeCreated = new Car(1996, "Civic", 100, false, true, 5);
		Car addedCar = carRepository.addCar(carToBeCreated);
		System.out.println(addedCar);
		addedCar.setYear(1997);
		carRepository.updateCar(18L, addedCar);
		System.out.println(addedCar);
	}
}
