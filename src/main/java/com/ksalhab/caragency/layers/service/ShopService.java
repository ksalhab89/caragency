package com.ksalhab.caragency.layers.service;

import com.ksalhab.caragency.layers.converter.ShopConverter;
import com.ksalhab.caragency.layers.domain.Shop;
import com.ksalhab.caragency.layers.dto.ShopDTO;
import com.ksalhab.caragency.layers.exceptions.SemanticException;
import com.ksalhab.caragency.layers.repository.ShopRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShopService {
	private final ShopRepo shopRepo;

	private ShopConverter shopConverter;

	public ShopDTO getShop(Long id) {
		return shopConverter.fromDomain(shopRepo.findById(id).get());
	}

	public List<ShopDTO> getAllShops() {
		return shopRepo.findAll()
				       .stream()
				       .map(shop -> shopConverter.fromDomain(shop))
				       .collect(Collectors.toList());
	}

	public ShopDTO addShop(ShopDTO shopDTO) {
		checkInventory(shopDTO);

		Shop shopToAdd = shopRepo.save(shopConverter.fromDTO(shopDTO));
		return shopConverter.fromDomain(shopToAdd);
	}

	public ShopDTO updateShop(Long id, ShopDTO shopDTO) {
		checkInventory(shopDTO);

		return shopRepo.findById(id)
				       .map(shop -> {
					       Shop shopToUpdate = shopConverter.fromDTO(shopDTO);
					       shopToUpdate.setId(shop.getId());
					       return shopRepo.save(shopToUpdate);
				       })
				       .map(savedShop -> shopConverter.fromDomain(savedShop))
				       .orElseThrow(RuntimeException::new);
	}

	public void deleteShop(Long id) {
		shopRepo.deleteById(id);
	}

	private void checkInventory(ShopDTO shopDTO) {
		if (shopDTO.getInventory() < 0) {
			throw new SemanticException("Inventory must be 0 or more");
		}
	}

}
