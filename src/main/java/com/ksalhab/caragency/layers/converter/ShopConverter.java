package com.ksalhab.caragency.layers.converter;

import com.ksalhab.caragency.layers.domain.Shop;
import com.ksalhab.caragency.layers.dto.ShopDTO;

public class ShopConverter {
	public ShopDTO fromDomain(Shop shop) {
		return new ShopDTO(shop.getLocation(), shop.getInventory(), shop.getCurrentlyOpen(),
				shop.getNumberOfEmployees(), shop.getOpenSince());
	}

	public Shop fromDTO(ShopDTO shopDTO) {
		return new Shop(shopDTO.getLocation(), shopDTO.getInventory(), shopDTO.getCurrentlyOpen(),
				shopDTO.getNumberOfEmployees(), shopDTO.getOpenSince());
	}
}
