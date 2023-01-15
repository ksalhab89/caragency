package com.ksalhab.caragency.layers.appEvent;

import com.ksalhab.caragency.layers.domain.Car;
import com.ksalhab.caragency.layers.domain.Shop;
import com.ksalhab.caragency.layers.repository.CarRepo;
import com.ksalhab.caragency.layers.repository.ShopRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JpaReadyListener {

	private final CarRepo carRepo;
	private final ShopRepo shopRepo;

	@EventListener(ApplicationContextEvent.class)
	public void JpaWork() {
		Car car = carRepo.findById(20L).get();
		System.out.printf(" Spring JPA Print %s%n", car);

		Shop shops = shopRepo.findAll().get(0);
		System.out.printf("JPA Shops %s ", shops);
	}

}
