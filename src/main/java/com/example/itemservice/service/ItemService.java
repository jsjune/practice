package com.example.itemservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.itemservice.controller.req.RequestItem;
import com.example.itemservice.entity.Item;
import com.example.itemservice.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
	private final ItemRepository itemRepository;

	public Item registerItem(RequestItem request) {
		Item item = Item.builder()
			.title(request.title())
			.content(request.content())
			.price(request.price())
			.username(request.username())
			.build();
		itemRepository.save(item);
		return itemRepository.save(item);
	}

	public List<Item> findAll() {
		return itemRepository.findAllByOrderByIdDesc();
	}

	public Item findItem(Long id) {
		return itemRepository.findById(id).orElseThrow(() -> {
			throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
		});
	}

	public Item updateItem(Long id, RequestItem request) {
		Item item = itemRepository.findById(id).orElseThrow(() -> {
			throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
		});
		item.update(request);
		return item;
	}

	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
	}
}
