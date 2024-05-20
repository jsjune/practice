package com.example.itemservice.controller.res;

import com.example.itemservice.entity.Item;

public record ResponseItem
	(
		Long id,
		String username,
		String title,
		String content,
		int price
	) {

	public ResponseItem(Item item) {
		this(
			item.getId(),
			item.getUsername(),
			item.getTitle(),
			item.getContent(),
			item.getPrice()
		);
	}
}
