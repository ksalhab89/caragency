package com.ksalhab.caragency.layers.controller;

import com.ksalhab.caragency.layers.dto.ShopDTO;
import com.ksalhab.caragency.layers.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
@AllArgsConstructor
public class ShopController {
	private ShopService shopService;

	@GetMapping(path = "/{id}")
	public ShopDTO getShop(@PathVariable Long id) {
		return shopService.getShop(id);
	}

	@GetMapping
	public List<ShopDTO> getAllShops() {
		return shopService.getAllShops();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ShopDTO addShop(@RequestBody ShopDTO shopDTO) {
		return shopService.addShop(shopDTO);
	}

	@DeleteMapping(path = "{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteShop(@PathVariable Long id) {
		shopService.deleteShop(id);
	}

	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ShopDTO updateShop(@PathVariable Long id,
	                          @RequestBody ShopDTO shopDTO) {
		return shopService.updateShop(id, shopDTO);
	}

}
