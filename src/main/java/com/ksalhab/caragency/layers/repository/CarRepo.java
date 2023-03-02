package com.ksalhab.caragency.layers.repository;

import com.ksalhab.caragency.layers.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

	List<Car> findAllByModelStartsWith(String startWith);

}