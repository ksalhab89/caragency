package com.ksalhab.caragency.layers.service;

import com.ksalhab.caragency.layers.converter.ShopConverter;
import com.ksalhab.caragency.layers.domain.Shop;
import com.ksalhab.caragency.layers.dto.ShopDTO;
import com.ksalhab.caragency.layers.exceptions.DataNotFoundException;
import com.ksalhab.caragency.layers.exceptions.SemanticException;
import com.ksalhab.caragency.layers.repository.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShopService {
	private ShopRepository shopRepository;

	private ShopConverter shopConverter;

	public ShopDTO getShop(Long id) {
		return shopConverter.fromDomain(shopRepository.getShop(id));
	}

	public List<ShopDTO> getAllShops() {
		return shopRepository.getAllShops()
				       .stream()
				       .map(shop -> shopConverter.fromDomain(shop))
				       .collect(Collectors.toList());
	}

	public ShopDTO addShop(ShopDTO shopDTO) {
		checkInventory(shopDTO);

		Shop shopToAdd = shopRepository.addShop(shopConverter.fromDTO(shopDTO));
		return shopConverter.fromDomain(shopToAdd);
	}

	public ShopDTO updateShop(Long id, ShopDTO shopDTO) {
		checkInventory(shopDTO);

		Shop updateShop = shopRepository.updateShop(id, shopConverter.fromDTO(shopDTO));
		return shopConverter.fromDomain(updateShop);
	}

	public void deleteShop(Long id) {
		checkIfExists(id);

		shopRepository.deleteShop(id);
	}

	private void checkIfExists(Long id) {
		Shop shop = shopRepository.getShop(id);
		if (shop == null) {
			throw new DataNotFoundException(String.format("CarShop with id %s not found", id));
		}
	}

	private void checkInventory(ShopDTO shopDTO) {
		if (shopDTO.getInventory() < 0) {
			throw new SemanticException("Inventory must be 0 or more");
		}
	}

}
