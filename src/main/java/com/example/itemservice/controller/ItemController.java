package com.example.itemservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.itemservice.controller.req.RequestItem;
import com.example.itemservice.controller.res.CheckResponse;
import com.example.itemservice.controller.res.ResponseItem;
import com.example.itemservice.service.ItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ItemController {
	private final ItemService itemService;

	@PostMapping("/post")
	public ResponseItem registerItem(@RequestBody RequestItem request) {
		return new ResponseItem(itemService.registerItem(request));
	}

	@GetMapping("/post")
	public List<ResponseItem> findAll() {
		return itemService.findAll().stream()
			.map(ResponseItem::new)
			.collect(Collectors.toList());
	}

	@GetMapping("/post/{id}")
	public ResponseItem findItem(@PathVariable Long id) {
		return new ResponseItem(itemService.findItem(id));
	}

	@PutMapping("/post/{id}")
	public ResponseItem updateItem(@PathVariable Long id, @RequestBody RequestItem request) {
		return new ResponseItem(itemService.updateItem(id, request));
	}

	@DeleteMapping("/post/{id}")
	public CheckResponse deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
		return new CheckResponse("삭제완료");
	}
}
