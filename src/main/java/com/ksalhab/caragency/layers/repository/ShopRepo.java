package com.ksalhab.caragency.layers.repository;

import com.ksalhab.caragency.layers.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepo extends JpaRepository<Shop, Long> {

}
