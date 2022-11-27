package com.ksalhab.caragency.layers.appEvent;

import com.ksalhab.caragency.layers.domain.Car;
import com.ksalhab.caragency.layers.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ApplicationReady {

	private CarRepository repository;

	@EventListener(ApplicationContextEvent.class)
	public void doSomeEventOnce() {
		Car car = repository.getCar(2L);
		System.out.println(car.toString());
	}
}
