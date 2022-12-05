package com.ksalhab.caragency.layers.appEvent;

import com.ksalhab.caragency.layers.dto.CarDTO;
import com.ksalhab.caragency.layers.exceptions.ApplicationException;
import com.ksalhab.caragency.layers.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ApplicationReadyServiceExamples {
	private CarService carService;

	@EventListener(ApplicationContextEvent.class)
	public void someExampleAfterStartup() {

		try {
			CarDTO carDTO = carService.addCar(new CarDTO(-1, "Mercedes", 220,
					false, true, 7));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			carService.deleteCar(24L);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}

	}

}
